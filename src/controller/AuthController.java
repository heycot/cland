package controller;

import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
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
import model.bean.User;
import model.dao.RoleDao;
import model.dao.UserDao;

@Controller
public class AuthController {

	@Autowired
	private Defines defines;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private MailSender mailSender;
	@Autowired
	private BCryptPasswordEncoder password;
	
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping("/login")
	public String index(){
		return "auth.login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String index1(){
		return "auth.login";
	}
	

	@RequestMapping("/profile/{id}")
	public String profile(@PathVariable("id") int id, ModelMap modelMap, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			modelMap.addAttribute("listRole", roleDao.getItems());
		 modelMap.addAttribute("userEdit", user );
	 }
	 return "admin.profile";
	}
	
	 @RequestMapping(value="/profile/{id}",method=RequestMethod.POST)
	 public String profile(@PathVariable("id") int id, @Valid @ModelAttribute("user") User user,BindingResult br, RedirectAttributes ra, ModelMap modelMap) {
		 if(br.hasErrors()) {
			 modelMap.addAttribute("userEdit", user);
		 return "admin.profile";
		 }
		 user.setId(id);
		 if(userDao.editProfile(user) > 0) {
			 ra.addFlashAttribute("msg", defines.success);
		 }else {
			 ra.addFlashAttribute("msg", defines.error);
		 }
		 return "redirect:/profile/" + user.getId();
	 }
	 
	 @RequestMapping("signInError")
	 public String signInErr() {
		 return "auth.changePass";
	 }
	 
	 @RequestMapping(value="changePass", method=RequestMethod.POST)
	 public String signInErr(@RequestParam("username") String username, ModelMap modelMap, RedirectAttributes ra) {
		 User user = userDao.getItemByUserName(username);
		 if( user == null) {
			 ra.addFlashAttribute("msg" ,"username của bạn không tồn tại");
		 }else {
			 System.out.println(user.getUsername() + "    " + user.getId());
			 Random rand = new Random();
			 String pass = "";
			 for(int i = 0; i < 5; i++) {
				 pass += rand.nextInt(10);
			 }
			 
			 System.out.println(password.encode(pass));
			 user.setPassword(password.encode(pass));
			 
			 if(userDao.editItem(user) > 0) {
				 try {
					    SimpleMailMessage message = new SimpleMailMessage();
					    message.setFrom(defines.email);
					    message.setTo(user.getEmail());
					    message.setSubject("Confirm your password");
					    message.setText("Mã password của bạn : " + pass + "  Vui lòng dùng mã code này để đăg nhập và đổi vào lần sử dụng sau. ");
					    // sending message
					    mailSender.send(message);
					    System.out.println("Sending text done!");
				    }catch( Exception e) {
				    	System.out.println(e.getMessage());
				    }
				 ra.addFlashAttribute("msg", "Truy cập vào email " + user.getEmail() + " để đổi mật khẩu của bạn");
			 }
		 }
		 return "redirect:/login";
	 }
	 
	 
	 
}
