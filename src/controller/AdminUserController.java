package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import model.bean.News;
import model.bean.User;
import model.dao.RoleDao;
import model.dao.UserDao;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private Defines defines;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private BCryptPasswordEncoder password;

	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String index(ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		modelMap.addAttribute("listUser", userDao.getItems());
		return "admin.user.index";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		modelMap.addAttribute("listRole", roleDao.getItems());
		return "admin.user.add";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String add(@Valid @ModelAttribute("user") User user, BindingResult br, RedirectAttributes ra,
			ModelMap modelMap, HttpSession session) {
		if (br.hasErrors()) {
			modelMap.addAttribute("user", user);
			return "admin.user.add";
		}
		user.setPassword(password.encode(user.getPassword()));
		if (userDao.addItem(user) > 0) {
			ra.addFlashAttribute("msg", defines.success);
			return "redirect:/admin/user";
		}
		ra.addFlashAttribute("msg", defines.error);
		return "redirect:/admin/user/add";
	}

	@RequestMapping(value="/user/delete/{id}",method=RequestMethod.GET)
	public String del (@PathVariable("id") int id, RedirectAttributes ra, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		if(userDao.activeItem(id, 0) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/user";
	}

	@RequestMapping(value="/user/delete",method=RequestMethod.POST)
	public String del (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra, HttpServletRequest request, HttpSession session) {
		int result = 0;
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		News news = new News();
		for (int i : iddel) {
			result += userDao.activeItem(i, 0);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/user";
	}
	
	 @RequestMapping(value="/user/edit/{id}",method=RequestMethod.GET)
	 public String edit (@PathVariable("id") int id, ModelMap modelMap, RedirectAttributes ra, HttpSession session) {
			User user = (User) session.getAttribute("userInfo");
			if(user.getRole_id() != 1) {
				return "redirect:/admin";
			}
		 user = userDao.getItem(id);
		 if(user != null) {
				modelMap.addAttribute("listRole", roleDao.getItems());
			 modelMap.addAttribute("userEdit", user );
		 }
		 return "admin.user.edit";
	 }
	
	 @RequestMapping(value="/user/edit/{id}",method=RequestMethod.POST)
	 public String edit (@PathVariable("id") int id, @Valid @ModelAttribute("user") User user,BindingResult br, RedirectAttributes ra, ModelMap modelMap, HttpSession session) {
		 if(br.hasErrors()) {
			 modelMap.addAttribute("userEdit", user);
		 return "admin.user.edit";
		 }
		 user.setId(id);
		 if(userDao.editItem(user) > 0) {
			 ra.addFlashAttribute("msg", defines.success);
		 }else {
			 ra.addFlashAttribute("msg", defines.error);
		 }
		 return "redirect:/admin/user";
	 }
	 
	@RequestMapping("/user/recycle")
	public String recyle(ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		modelMap.addAttribute("listUser", userDao.getItemRe());
		return "admin.user.recycle";
	}
	
	@RequestMapping(value="/user/recycle/del",method=RequestMethod.POST)
	public String recycleDel (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra, HttpServletRequest request) {
		int result = 0;
		News news = new News();
		for (int i : iddel) {
			result += userDao.deleteItem(i);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/user/recycle";
	}
	
	@RequestMapping(value="/user/recycle/active/{id}",method=RequestMethod.GET)
	public String recycleActive (@PathVariable("id") int id, RedirectAttributes ra, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user.getRole_id() != 1) {
			return "redirect:/admin";
		}
		if(userDao.activeItem(id, 1) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/user/recycle";
	}
	
		
}
