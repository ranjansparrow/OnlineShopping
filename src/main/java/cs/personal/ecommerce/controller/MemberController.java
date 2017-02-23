package cs.personal.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cs.personal.ecommerce.domain.Member;
import cs.personal.ecommerce.service.IMemberService;


@Controller
public class MemberController {

	    List<String> files = new ArrayList<String>();
	
	@Autowired
	IMemberService memberService;
	@RequestMapping("/hello")
	public String hello(Model model,Member member){
		
		model.addAttribute("members",memberService.getAllMembers());
		return "hello";
	}
	
	@RequestMapping(value = {"/","/register"}, method = RequestMethod.GET)
	public String register(@ModelAttribute("member") Member member){
		return "register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String successregister(@ModelAttribute("member") Member member, BindingResult bindingresult, @RequestParam("file") MultipartFile file,Model model){
		try {
			memberService.store(file);
            model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
            files.add(file.getOriginalFilename());
        } catch (Exception e) {
            model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
        }
       
		memberService.save(member);
		return "login";
	}
}
