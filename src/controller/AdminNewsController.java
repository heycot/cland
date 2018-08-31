package controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Cat;
import model.bean.News;
import model.dao.CatDao;
import model.dao.NewsDao;

@Controller
@RequestMapping("/admin")
public class AdminNewsController {

	@Autowired
	private Defines defines;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CatDao catDao;
	@Autowired
	private ServletContext context;
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value= {"/news/{page}", "/news"},method=RequestMethod.GET)
	public String index (@PathVariable(value = "page", required=false) Integer page ,ModelMap modelMap) {
		if(page == null) {
			page = 1;
		}
		int sumpage = (int)Math.ceil((float)newsDao.countItem()/defines.row_count);
		int rowCount = defines.row_count;
		int offset = (page - 1) * rowCount;
		
		modelMap.addAttribute("sumpage", sumpage);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("listNews", newsDao.getItems(offset));
		return "admin.news.index";
	}

	@RequestMapping(value="/news/add",method=RequestMethod.GET)
	public String add (ModelMap modelMap) {
		modelMap.addAttribute("listCat", catDao.getItems());
		return "admin.news.add";
	}
	
	@RequestMapping(value="/news/add",method=RequestMethod.POST)
	public String add (@ModelAttribute("news") News news, BindingResult br,  RedirectAttributes ra ,@RequestParam("hinhanh") CommonsMultipartFile cmf) {
		if(br.hasErrors()) { 
			return "redirect:/admin/news/add";
		}
		String fileName = cmf.getOriginalFilename();
		String duoiFile = FilenameUtils.getExtension(fileName);
		
		
		if( "".equals(fileName)) {

			ra.addFlashAttribute("error", "chon file truoc khi them");
			return "redirect:/admin/news/add";
		}else if(!"png".equals(duoiFile) && !"jpg".equals(duoiFile) && !"gif".equals(duoiFile)) {

			ra.addFlashAttribute("error", "chi chon file anh (png, jpg, gif)");
			return "redirect:/admin/news/add";
		}else{
			fileName = new Date().getTime() + "." + FilenameUtils.getExtension(fileName);
			
			String dirPath = context.getRealPath("") + "files";
			File file = new File(dirPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			try {
				cmf.transferTo(new File(filePath));
				System.out.println("upload file thanh cong");
				System.out.println("dirpath: " + dirPath);
			} catch (IOException e) {
				System.out.println("error upload file");
				e.printStackTrace();
			}
			news.setPicture(fileName);
			if(newsDao.addItem(news) > 0) {
				ra.addFlashAttribute("msg", defines.success);
				return "redirect:/admin/news";
			}else {
				ra.addFlashAttribute("msg", defines.error);
				return "redirect:/admin/news";
			}
		}
	}

	@RequestMapping(value="/news/delete",method=RequestMethod.POST)
	public String del (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra, HttpServletRequest request) {
		int result = 0;
		for (int i : iddel) {
				result += newsDao.activeItem(i, 0);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value="/news/delete/{id}",method=RequestMethod.GET)
	public String del(@PathVariable("id") int id, RedirectAttributes ra) {
		if(newsDao.activeItem(id, 0) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/news";
	}
	
	@RequestMapping(value="/news/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable("id") int id, ModelMap modelMap) {
		News news = newsDao.getItem(id);
		if( news != null) {
			modelMap.addAttribute("newsEdit", news);
			modelMap.addAttribute("listCat", catDao.getItems());
		}
		return "admin.news.edit";
	}
	
	@RequestMapping(value="/news/edit/{id}", method=RequestMethod.POST)
	public String edit(@PathVariable("id") int id, ModelMap modelMap,ServletRequest request,@Valid @ModelAttribute("news") News news,BindingResult br, RedirectAttributes ra, @RequestParam("hinhanh") CommonsMultipartFile cmf) {
		if(br.hasErrors()) { 
			return "redirect:/admin/news/edit/" + id;
		}
		String fileName = cmf.getOriginalFilename();
		String duoiFile = FilenameUtils.getExtension(fileName);
		
		
		if( "".equals(fileName)) {

			ra.addFlashAttribute("error", "chon file truoc khi them");
			return "redirect:/admin/news/edit" + id;
		}else if(!"png".equals(duoiFile) && !"jpg".equals(duoiFile) && !"gif".equals(duoiFile)) {

			ra.addFlashAttribute("error", "chi chon file anh (png, jpg, gif)");
			return "redirect:/admin/news/edit" + id;
		}else{
			fileName = new Date().getTime() + "." + FilenameUtils.getExtension(fileName);
			String appPath = request.getServletContext().getRealPath("");
			String dirPath = appPath + defines.DIR_UPLOAD;
			File file;
			if(!"".equals(news.getPicture())) {
				file = new File(dirPath + File.separator + news.getPicture());
				file.delete();
			}
			file = new File(dirPath);
			if(!file.exists()) {
				file.mkdirs();
			}
			String filePath = dirPath + File.separator + fileName;
			try {
				cmf.transferTo(new File(filePath));
				System.out.println("edit file thanh cong");
				System.out.println("dirpath: " + dirPath);
			} catch (IOException e) {
				System.out.println("error edit file");
				e.printStackTrace();
			}
			news.setPicture(fileName);
			if(newsDao.editItem(news) > 0) {
				ra.addFlashAttribute("msg", defines.success);
				return "redirect:/admin/news";
			}else {
				ra.addFlashAttribute("msg", defines.error);
				return "redirect:/admin/news";
			}
		}
	}
	

	@RequestMapping("/news/recycle")
	public String recyle(ModelMap modelMap) {
		modelMap.addAttribute("listNews", newsDao.getItemRe());
		return "admin.news.recycle";
	}
	
	@RequestMapping(value="/news/recycle/del", method=RequestMethod.POST)
	public String RecycleDel (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra, HttpServletRequest request) {
		int result = 0;
		News news = new News();
		for (int i : iddel) {
			news = newsDao.getItem(i);
			if(news != null) {
				if(!"".equals(news.getPicture())) {
					String appPath = request.getServletContext().getRealPath("");
					String dirPath = appPath + defines.DIR_UPLOAD;
					File file = new File(dirPath + File.separator + news.getPicture());
					file.delete();
				}
				result += newsDao.deleteItem(i);
			}
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/news/recycle";
	}
	
	@RequestMapping("/news/recycle/active/{id}")
	public String recycleActive(@PathVariable("id") int id, HttpServletRequest request, RedirectAttributes ra) {
		if(newsDao.activeItem(id, 1) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/news/recycle";
	}
	
}
