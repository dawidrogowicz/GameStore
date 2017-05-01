package com.rogowiczdawid.gamestore.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rogowiczdawid.gamestore.models.Product;
import com.rogowiczdawid.gamestore.services.ProductService;

@Controller
public class MainController {
	
	@Autowired	
	ProductService productService;
	
	public void setProductService(ProductService ps){
		this.productService = ps;
	}

	@RequestMapping("/")
	public String showMain() {
		return "index";
	}
	
	@RequestMapping("/admin")
	@ResponseBody
	public String test() {
		return "admin page";
	}
	
	@RequestMapping("/product/{name}")
	@ResponseBody
	public String ddd(@PathVariable String name) {
		List<Product> l = productService.getProductsWhereNameContains(name);
		
		return l.toString();
	}
	
	@RequestMapping("/product")
	@ResponseBody
	public List<Product> getProductByName(@RequestParam String name){
		return productService.getProductsWhereNameContains(name);
	}
			
}
