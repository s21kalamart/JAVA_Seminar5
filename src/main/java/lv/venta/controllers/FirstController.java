package lv.venta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/hello")	//localhost:8080/hello
	public String getHelloFunc() {
		System.out.println("Sveiki!");
		return "hello-page";	//there will be hello-page.html
	}
}
