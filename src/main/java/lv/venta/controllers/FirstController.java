package lv.venta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lv.venta.model.*;

@Controller
public class FirstController {
	
	@GetMapping("/hello")	//localhost:8080/hello
	public String getHelloFunc() {
		System.out.println("Sveiki!");
		return "hello-page";	//there will be hello-page.html
	}
	
	//TODO create controller with model and add String in the model
	@GetMapping("/msg")		//localhost:8080/msg
	public String getMsgFunc(Model model) {
		model.addAttribute("packet", "Message from Marta");
		return "msg-page";		//will show msg-page.html
	}
	
	//TODO controller function which will send new product to front-end
	@GetMapping("/one-product")	//localhost:8080/one-product
	public String getOneProductFunc(Model model) {
		Product prod = new Product("Apple", "Tasty", 1.2f, 9);
		model.addAttribute("packet", prod);
		return "one-product-page";	//will show one-product-page.html
	}
}
