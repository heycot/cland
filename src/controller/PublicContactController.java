package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import model.bean.Contact;
import model.bean.ReplyContact;
import model.bean.User;
import model.dao.CatDao;
import model.dao.ContactDao;
import model.dao.NewsDao;

@Controller
public class PublicContactController {
	
	@Autowired
	private CatDao catDao;
	@Autowired
	private NewsDao newsDao;
	@Autowired
	private ContactDao contactDao;
	
	@ModelAttribute
	public void addcommon(ModelMap modelMap) {
		modelMap.addAttribute("listCat", catDao.getItems());
		modelMap.addAttribute("listNewsView", newsDao.getItemsPublic(0));
	}
	
	@RequestMapping(value="contact",method=RequestMethod.GET)
	public String index(){
		return "public.contact.index";
	}
	
	@RequestMapping(value="contact",method=RequestMethod.POST)
	public String index(@ModelAttribute("contact") Contact contact, RedirectAttributes ra){
		System.out.println(contact.getFullname() + "    " + contact.getEmail());
		if(contactDao.addItem(contact) > 0) {
			ra.addFlashAttribute("msg", "Bạn đã gửi liên hệ thành công. Chúng tôi sẽ gửi mail cho bạn sau");
		}else {
			ra.addFlashAttribute("msg", "Liên hệ của bạn chưa gửi được. Vui lòng thử lại sau");
		}
		return "redirect:/contact";
	}
	
}
