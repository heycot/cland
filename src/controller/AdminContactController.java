package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import constant.Defines;
import model.bean.Cat;
import model.bean.Contact;
import model.bean.ReplyContact;
import model.bean.User;
import model.dao.CatDao;
import model.dao.ContactDao;
import model.dao.ReplyDao;

@Controller
@RequestMapping("/admin")
public class AdminContactController {
	
	@Autowired
	private Defines defines;
	@Autowired
	private ContactDao contactDao;
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private MailSender mailSender;
	 
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("defines", defines);
	}
	
	@RequestMapping(value="/contact",method=RequestMethod.GET)
	public String index (ModelMap modelMap) {
		modelMap.addAttribute("listContact", contactDao.getItemNoReply());
		modelMap.addAttribute("listReply", replyDao.getItems());
		return "admin.contact.index";
	}
	

	@RequestMapping(value="/contact/delete",method=RequestMethod.POST)
	public String del (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra) {
		int result = 0;
		for (int i : iddel) {
			System.out.println(i);
			result += contactDao.activeItem(i, 0);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/contact";
	}
	

	@RequestMapping(value="/contact/reply/{id}",method=RequestMethod.GET)
	public String reply(@PathVariable("id") int id, ModelMap modelMap) {
		modelMap.addAttribute("contact", contactDao.getItemById(id));
		return "admin.contact.reply";
	}
	
	@RequestMapping(value="/contact/reply/{id}",method=RequestMethod.POST)
	public String index (@ModelAttribute("replyCon") ReplyContact replyCon, @PathVariable("id") int id, RedirectAttributes ra, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		replyCon.setContact_id(id);
		replyCon.setUser_id(user.getId());
		
		if( replyDao.addItem(replyCon) > 0) {
			contactDao.activeItem(id, 1);
			Contact contact = contactDao.getItemById(id);
			
			if( contact != null) {
			    System.out.println("Sending text...");
			    try {
				    SimpleMailMessage message = new SimpleMailMessage();
				    message.setFrom(defines.email);
				    message.setTo(contact.getEmail());
				    message.setSubject(contact.getSubject());
				    message.setText(replyCon.getContent());
				    // sending message
				    mailSender.send(message);
				    System.out.println("Sending text done!");
			    }catch( Exception e) {
			    	System.out.println(e.getMessage());
			    }
			}
			ra.addFlashAttribute("msg", "Bạn đã trả lời thành công");
		}
		return "redirect:/admin/contact";
	}
	
	@RequestMapping("/contact/recycle")
	public String recyle(ModelMap modelMap) {
		modelMap.addAttribute("listContact", contactDao.getItemRe());
		modelMap.addAttribute("listReply", replyDao.getItems());
		return "admin.contact.recycle";
	}
	
	@RequestMapping(value="/contact/recycle/del",method=RequestMethod.POST)
	public String RecycleDel (@RequestParam(value="item") int[] iddel,  RedirectAttributes ra) {
		int result = 0;
		for (int i : iddel) {
			System.out.println(i);
			result += contactDao.delItem(i);
		}
		if(result > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/contact/recycle";
	}
	
	@RequestMapping("/contact/recycle/active/{id}")
	public String RecycleDel (@PathVariable("id") int id,  RedirectAttributes ra) {
		
		if(contactDao.activeItem(id, 1) > 0) {
			ra.addFlashAttribute("msg", defines.success);
		}else {
			ra.addFlashAttribute("msg", defines.error);
		}
		return "redirect:/admin/contact/recycle";
	}
	
}
