package cs.personal.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String hello(Model model, Member member) {

		model.addAttribute("members", memberService.getAllMembers());
		return "hello";
	}

	@RequestMapping(value = { "/", "/register" }, method = RequestMethod.GET)
	public String register(@ModelAttribute("member") Member member) {
		return "register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String successregister(@ModelAttribute("member") Member member, BindingResult bindingresult, Model model) {

		String formusername = member.getUsername();
		String dbusername = memberService.findUsername(member.getUsername());
		if (formusername.equals(dbusername)) {
			model.addAttribute("message", "Username already exists");
			return "register";
		}

		memberService.save(member);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String afterlogin(Model model, HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		String dbpass = memberService.findPassword(username);
		if (dbpass.equals(password)) {
			return "dashboard";
		}
		return "login";
	}
}
