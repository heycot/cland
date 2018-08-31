package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import model.dao.RoleDao;
import model.dao.UserDao;

@Controller
public class AdminRecycleController {

	@Autowired
	private Defines defines;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("/admin/recycleBin")
	public String index() {
		return "admin.recycle.index";
	}
}
