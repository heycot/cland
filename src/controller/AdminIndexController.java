package controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import constant.Defines;
import model.bean.User;
import model.dao.UserDao;

@Controller
@RequestMapping("admin")
public class AdminIndexController {

	@Autowired
	private Defines defines;
	@Autowired
	private UserDao userDao;
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("")
	public String index(Principal principal, HttpSession session){
		System.out.println("usrname : " + principal.getName());
		User user = userDao.getItemByUserName(principal.getName());
		session.setAttribute("userInfo", user);
		return "admin.index.index";
	}
}
