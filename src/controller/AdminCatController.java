package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Cat;
import model.dao.CatDao;

@Controller
@RequestMapping("/admin")
public class AdminCatController {
	
	@Autowired
	private Defines defines;
	@Autowired
	private CatDao catDao;
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/cats",method=RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.addAttribute("listCat", catDao.getItems());
		return "admin.cat.index";
	}
	
	

	@RequestMapping(value="/cat/add",method=RequestMethod.GET)
	public String add () {
		return "admin.cat.add";
	}
	
	@RequestMapping(value="/cat/add",method=RequestMethod.POST)
	public String add (@Valid @ModelAttribute("cat") Cat cat, BindingResult br, RedirectAttributes ra, ModelMap modelMap) {
		if(br.hasErrors()) {
			modelMap.addAttribute("cat", cat);
			return "admin.cat.add";
		}
		if(catDao.addItem(cat) > 0) {
			ra.addFlashAttribute("msg", defines.success);
			return "redirect:/admin/cats";
		}
		ra.addFlashAttribute("msg", defines.error);
		return "redirect:/admin/cat/add";
	}
	
	@RequestMapping(value="/cat/delete/{id}",method=RequestMethod.GET)
	public String del (@PathVariable("id") int id, RedirectAttributes ra) {
		if(catDao.deleteItem(id) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/cats";
	}
	
	@RequestMapping(value="/cat/edit/{id}",method=RequestMethod.GET)
	public String edit (@PathVariable("id") int id, ModelMap modelMap, RedirectAttributes ra) {
		Cat cat = catDao.getItem(id);
		if(cat != null) {
			modelMap.addAttribute("catEdit", cat );
		}
		return "admin.cat.edit";
	}

	@RequestMapping(value="/cat/edit/{id}",method=RequestMethod.POST)
	public String edit (@PathVariable("id") int id, @Valid @ModelAttribute("cat") Cat cat,BindingResult br, RedirectAttributes ra, ModelMap modelMap) {
		if(br.hasErrors()) {
			modelMap.addAttribute("catEdit", cat);
			return "admin.cat.edit";
		}
		cat.setCid(id);
		if(catDao.editItem(cat) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/cats";
	}
	
	@RequestMapping(value="/cat/delete",method=RequestMethod.POST)
	public String del (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra) {
		int result = 0;
		for (int i : iddel) {
			System.out.println(i);
			result += catDao.deleteItem(i);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/cats";
	}
	
}
