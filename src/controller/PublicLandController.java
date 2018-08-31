package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import constant.Defines;
import model.bean.News;
import model.dao.CatDao;
import model.dao.NewsDao;
import util.SlugUtil;

@Controller
public class PublicLandController {
	
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private CatDao catDao;
	@Autowired
	private Defines defines;
	@Autowired
	private SlugUtil slugUtil;

	
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("listCat", catDao.getItems());
		modelMap.addAttribute("listNewsView", newsDao.getItemsPublic(0));
		modelMap.addAttribute("slugUtil", slugUtil);
		modelMap.addAttribute("listCountView", newsDao.getItemsCountView());
		modelMap.addAttribute("active", (newsDao.getItemsCountView().get(0).getLid() ));
		
	}
	
	@RequestMapping(value= {"/{page}", ""},method=RequestMethod.GET)
	public String index(@PathVariable(value = "page", required=false) Integer page, ModelMap modelMap){
		if(page == null) {
			page = 1;
		}
		int sumpage = (int)Math.ceil((float)newsDao.countItem()/defines.row_count_public);
		int rowCount = defines.row_count_public;
		int offset = (page - 1) * rowCount;
		
		modelMap.addAttribute("sumpage", sumpage);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("listNews", newsDao.getItemsPublic(offset));
		return "public.land.index";
	}
	
	
	@RequestMapping(value= {"/cat/{id}/{page}", "/cat/{id}"}, method=RequestMethod.GET)
	public String cat(@PathVariable("id") int id,@PathVariable(value = "page", required=false) Integer page, ModelMap modelMap){
		if(page == null) {
			page = 1;
		}
		int sumpage = (int)Math.ceil((float)newsDao.countItem()/defines.row_count_public);
		int rowCount = defines.row_count_public;
		int offset = (page - 1) * rowCount;
		
		modelMap.addAttribute("sumpage", sumpage);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("listNewsSameCat", newsDao.getItemByIdCat(id, offset));
		return "public.land.cat";
	}
	
	@RequestMapping(value="{catName}/{landName}-{id}.html", method=RequestMethod.GET)
	public String detail(@PathVariable("id") int id, ModelMap modelMap){
		modelMap.addAttribute("minId", (newsDao.getMinID()).getLid());
		modelMap.addAttribute("maxId",( newsDao.getMaxID()).getLid());
		modelMap.addAttribute("newsDe", newsDao.getItem(id));
		modelMap.addAttribute("moreitem", newsDao.getItemSameCat((newsDao.getItem(id)).getCid()));
		return "public.land.detail";
	}
	
	@RequestMapping("{catName}/{landName}-{id}/bef.html")
	public String detailBef(@PathVariable("id") int id, ModelMap modelMap){
		News news = new News();
		do {
			news = newsDao.getItem(id - 1);
			id = id-1;
		}while( news == null);
		modelMap.addAttribute("newsDe", news);
		modelMap.addAttribute("moreitem", newsDao.getItemSameCat(news.getCid()));
		return "redirect:/" + SlugUtil.makeSlug(news.getCname())  + "/" + SlugUtil.makeSlug(news.getLname()) + "-" + news.getLid() + ".html";
	}
	
	@RequestMapping("{catName}/{landName}-{id}/aft.html")
	public String detailAft(@PathVariable("id") int id, ModelMap modelMap){
		News news = new News();
		do {
			news = newsDao.getItem(id + 1);
			id = id+ 1;
		}while( news == null);
		modelMap.addAttribute("newsDe", news);
		modelMap.addAttribute("moreitem", newsDao.getItemSameCat(news.getCid()));
		return "redirect:/" + SlugUtil.makeSlug(news.getCname())  + "/" + SlugUtil.makeSlug(news.getLname()) + "-" + news.getLid() + ".html";
	}
}
