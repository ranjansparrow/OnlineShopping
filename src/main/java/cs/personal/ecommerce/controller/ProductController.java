package cs.personal.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.DomainManagerOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.personal.ecommerce.domain.OrderLine;
import cs.personal.ecommerce.domain.Product;
import cs.personal.ecommerce.service.IOrderLineService;
import cs.personal.ecommerce.service.IProductService;
import cs.personal.ecommerce.service.IStorageService;

@SessionAttributes("listofProducts")
@Controller
public class ProductController {
	List<String> files = new ArrayList<String>();
	@Autowired
	IStorageService storageService;
	@Autowired
	IProductService productService;
	@Autowired
	IOrderLineService orderLineService;

	List<Product> listOfProducts = new ArrayList();

	@RequestMapping(value = "/addProduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		return "addProduct";
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product, RedirectAttributes redirectAttributes,
			@RequestParam("file") MultipartFile file, Model model) {
		String time = String.valueOf(System.currentTimeMillis());
		try {
			storageService.store(file, time);
			files.add(file.getOriginalFilename());
		} catch (Exception e) {
			model.addAttribute("message", "FAIL to upload " + file.getOriginalFilename() + "!");
		}
		productService.save(product, time);
		return "redirect:/viewProduct";
	}

	@RequestMapping(value = "/viewProduct", method = RequestMethod.GET)
	public String showProduct(Model model) {
		model.addAttribute("product", productService.findAllProduct());
		return "viewProduct";
	}

	@RequestMapping(value = "/viewDetails/{productId}")
	public String viewDetail(@PathVariable("productId") long productId, Product product, Model model) {
		model.addAttribute("product", productService.findOneProduct(productId));
		return "detail";
	}

	@RequestMapping(value = "/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") long productId, Model model) {
		Product dbProduct = productService.findOneProduct(productId);
		listOfProducts.add(dbProduct);

		model.addAttribute("listofProducts", listOfProducts);
		return "redirect:/myCart";
	}

	@RequestMapping(value = "/myCart", method = RequestMethod.POST)
	public String myCart() {
		return "redirect:/myCart";
	}

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String showMyCart() {
		return "myCart";
	}

	@RequestMapping(value = "/checkout")
	public String checkOut(OrderLine orderLine) {

		orderLineService.save(orderLine, listOfProducts);
		return "redirect:/login";
	}
}
