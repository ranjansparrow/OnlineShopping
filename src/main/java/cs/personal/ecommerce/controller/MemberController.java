package cs.personal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs.personal.ecommerce.domain.Member;
import cs.personal.ecommerce.service.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	@RequestMapping("/hello")
	public String hello(){
		
		return "hello";
	}
	
	@RequestMapping(value = {"/","/register"}, method = RequestMethod.GET)
	public String register(@ModelAttribute("member") Member member){
		return "register";
	}
	
	@RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	public String successregister(@ModelAttribute("member") Member member, BindingResult bindingresult){
		memberService.save(member);
		return "login";
	}
}
