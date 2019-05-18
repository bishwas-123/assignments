package assignment_lab.practice.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@RequestMapping(value={"/", "/products", "productmanagement","product_management", "/products/home", "home"},
			method=RequestMethod.GET)
	public String homepage() {
		return "home/index";
	}
	
}