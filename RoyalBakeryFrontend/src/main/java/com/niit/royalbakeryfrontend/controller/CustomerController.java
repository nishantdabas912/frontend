package com.niit.royalbakeryfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.royalbakerybackend.dao.CustomerRepository;
import com.niit.royalbakerybackend.model.Customer;


@Controller
public class CustomerController 
{
	@Autowired
	CustomerRepository customerRepository;
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String register(@ModelAttribute("user") Customer customer){
		customerRepository.addCustomer(customer);
		
		return "login";
		
	}
}

