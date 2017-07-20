package com.mytest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepositry customerRepository;

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerRepository.findAll().forEach(customerList::add);
		 return customerList;
		
	}

	@Override
	public String addNewCustomer(Customer customer) {
		customerRepository.save(customer);
		return "success";
	}

	@Override
	public String updateCustomerById(int id,Customer customer) {
		customerRepository.save(customer);
		return "success";
	}

	@Override
	public String deleteCustomerById(int id) {
		customerRepository.delete(id);
		return "success";
	}

	@Override
	public Customer getCustomerById(int id) {
		return customerRepository.findOne(id);
	}

	@Override
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}
	
}
