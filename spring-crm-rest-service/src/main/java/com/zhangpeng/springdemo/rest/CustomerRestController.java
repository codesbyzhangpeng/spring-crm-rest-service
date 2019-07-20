package com.zhangpeng.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhangpeng.springdemo.entity.Customer;
import com.zhangpeng.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
		
	}
	
	//add mapping for get "/customers/{customerId}"
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer==null) { 
			throw new CustomerNotFoundException();
		}
		
		return theCustomer;
	}
	
	//add mapping for post/customers - add a new customer
	@PostMapping("customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		
		//just in case the pass an id in JSON ... set id to 0
		//this is force a save of new item ... instead of update
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add mapping for updateing an existing customers - add a new customer
	@PutMapping("customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String DeleteCustomer(@PathVariable int customerId) {
		
		Customer tempCustomer = customerService.getCustomer(customerId);
		
		if(tempCustomer==null) {
			throw new CustomerNotFoundException();
		}
		
		customerService.deleteCustomer(customerId);
		
		return "Deleted Customer id - " + customerId;
	}
	
}
