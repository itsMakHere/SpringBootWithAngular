package com.mytest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	/*@RequestMapping("")
	@ResponseBody
	public String CustomerHello(){
		return "Customer Hello";
	}*/
	@RequestMapping(value = "/index")
	public ModelAndView addNewCustomer(){
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("")
	public List<Customer> getAllCustomer() throws CustomerNotFound{
		List<Customer> lisOfCustomer1 = customerService.getAllCustomer();
		if(lisOfCustomer1 != null && lisOfCustomer1.size() != 0){
			return lisOfCustomer1;
		}
		throw new CustomerNotFound("Customer Not Found Exception");
	}
	
	@RequestMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) throws CustomerNotFound{
		Customer customer = customerService.getCustomerById(id);
		if(customer != null){
			return customer;
		}
		throw new CustomerNotFound("Customer Not Found Exception");
	}
	
	@RequestMapping(method=RequestMethod.POST,value = "")
	public List<String> addNewCustomer(@RequestBody Customer customer){
		String message = customerService.addNewCustomer(customer);
		List<String> list = new ArrayList<String>();
		if("success".equalsIgnoreCase(message)){
			list.add("success");
			return list;
		}
		list.add("failure");
		return list;
	}
	
	@RequestMapping(value= "/{id}",method = RequestMethod.PUT)
	public String updateCustomer(@PathVariable int id,@RequestBody Customer customer){
		return customerService.updateCustomerById(id, customer);
	}
	
	@RequestMapping(value= "/{id}",method = RequestMethod.DELETE)
	public List<String> deleteCustomer(@PathVariable int id){
		String message = customerService.deleteCustomerById(id);
		List<String> list = new ArrayList<String>();
		if("success".equalsIgnoreCase(message)){
			list.add("success");
			return list;
		}
		list.add("failure");
		return list;
	}
	
	/*@RequestMapping("/{name}")
	public Customer getCustomerByName(@PathVariable String name) throws CustomerNotFound{
		Customer customer = customerService.findByName(name);
		if(customer != null){
			return customer;
		}
		throw new CustomerNotFound("Customer Not Found Exception");
	}*/
	
	
}
