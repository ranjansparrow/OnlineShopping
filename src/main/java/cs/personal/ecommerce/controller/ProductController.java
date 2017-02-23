package cs.personal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.personal.ecommerce.domain.Product;
import cs.personal.ecommerce.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	IProductService productService;
	@RequestMapping(value = "/addProduct")
	public String addProduct(@ModelAttribute("product") Product product){
		return "addProduct";
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,RedirectAttributes redirectAttributes, Model model){
		productService.save(product);
		redirectAttributes.addFlashAttribute("product", productService.findAllProduct());
		return "redirect:/viewProduct";
	}
	@RequestMapping(value = "/viewProduct")
	public String showProduct(){
		return "viewProduct";
	}
}
