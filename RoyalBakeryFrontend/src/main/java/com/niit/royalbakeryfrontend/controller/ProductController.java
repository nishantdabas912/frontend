package com.niit.royalbakeryfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.royalbakerybackend.dao.CategoryRepository;
import com.niit.royalbakerybackend.dao.ProductRepository;
import com.niit.royalbakerybackend.model.Category;
import com.niit.royalbakerybackend.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductRepository productRepository;
	@Autowired
	Product product;
	@Autowired
	CategoryRepository categoryRepository;

	@RequestMapping(value="/adminaddProduct",method=RequestMethod.POST)
	public String productAdd(@ModelAttribute("productOBJ") Product product)
	{
		if(product.getProductId()==0)
		{
			productRepository.addProduct(product);
		}
		else
		{
			productRepository.updateProduct(product);
		}
		
		return "redirect:/adminProduct";
	}
	
	
	@RequestMapping("/admindeleteProduct/{id}")
	
		public String productDelete(@PathVariable("id") int productId)
		{
		productRepository.deleteProduct(productId);
			return "redirect:/adminProduct";
	}
	
	
	@RequestMapping("/admineditProduct/{id}")
	
	public String productUpdate(@PathVariable("id") int productId,Model model)
	{
		Product productData=productRepository.getProductById(productId);
		model.addAttribute("productOBJ",productData);
		List<Product> allProducts= productRepository.getAllProduct();
		List<Category> allCategories= categoryRepository.getAllCategory();
		model.addAttribute("productList",allProducts);
		model.addAttribute("categoryList",allCategories);
		return "Product";
}
	
}
