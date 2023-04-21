package lv.venta.controllers;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lv.venta.model.*;
import java.util.ArrayList;

@Controller
public class FirstController {
	
	private ArrayList<Product> allProducts = new ArrayList<>(Arrays.asList(
			new Product("Watermelon", "Red", 2.34f, 6),
			new Product("Lemon", "Sour", 5.34f, 3),
			new Product("Carrot", "Orange", 1.1f, 20)
			));
	
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
	public String getOneProdFunc(Model model) {
		Product prod = new Product("Apple", "Tasty", 1.2f, 9);
		model.addAttribute("packet", prod);
		return "one-product-page";	//will show one-product-page.html
	}
	
	@GetMapping("/all-products")	//localhost:8080/all-products
	public String getAllProdFunc(Model model) {
		model.addAttribute("packet", allProducts);
		return "all-products-page";	//will show all-products-page.html
	}
	
	@GetMapping("/all-products-find")	//localhost:8080/all-products-find?id=2
	public String getAllProdFindFunc(@RequestParam("id") long id, Model model) {
		if(id > 0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("packet", temp);
					return "one-product-page";	//will call one-product-page.html
				}
			}
		}
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";	//will call error-page.html
	}
	
	@GetMapping("/all-products/{id}")
	public String getAllProdByIdFunc(@PathVariable("id") long id, Model model) {
		if(id > 0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("packet", temp);
					return "one-product-page";	//will call one-product-page.html
				}
			}
		}
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";	//will call error-page.html
	}
	
	@GetMapping("/add-product")	//localhost:8080/add-product
	public String getAddProdFunc(Model model) {
		model.addAttribute("product", new Product());	//send an empty product
		return "add-product-page";	//will call add-product-page.html
	}
	
	@PostMapping("/add-product")
	public String postAddProdFunc(Product product) {	//retrieve product with all parameters
		//TODO verify if this product already exists
		Product newProduct = new Product(product.getTitle(), 
				product.getDescription(), product.getPrice(), product.getQuantity());
		allProducts.add(newProduct);
		
		return "redirect:/all-products";	//will call /all-products end-point
	}
	
	@GetMapping("/update-product/{id}")	//localhost:8080/update-product/2
	public String getUpdateProdFunc(@PathVariable("id") long id, Model model) {
		if(id > 0) {
			for(Product temp : allProducts) {
				if(temp.getId() == id) {
					model.addAttribute("product", temp);
					return "update-product-page";	//will call update-product-page.html
				}
			}
		}
		model.addAttribute("packetError", "Wrong ID");
		return "error-page";	//will call error-page.html
	}
	
	@PostMapping("/update-product/{id}")
	public String postUpdateProdFunc(@PathVariable("id") long id, Product product) {
		for(Product temp : allProducts ) {
			if(temp.getId() == id) {
				temp.setTitle(product.getTitle());
				temp.setDescription(product.getDescription());
				temp.setPrice(product.getPrice());
				temp.setQuantity(product.getQuantity());
				
				return "redirect:/all-products/" + id;	//will call localhost:8080/all-products/2 end-point
			}
		}
		return "redirect:/error";	//will call localhost:8080/error
	}
	
	@GetMapping("/error")	//localhost:8080/error
	public String getErrorFunc(Model model) {
		model.addAttribute("packetError", "Wrong id");
		return "error-page";	//will call error-page.html
	}
}
