package com.mytest;

import java.util.List;

public interface CustomerService {
	public List<Customer> getAllCustomer();
	public String addNewCustomer(Customer customer);
	public String deleteCustomerById(int id);
	public Customer getCustomerById(int id);
	public String updateCustomerById(int id, Customer customer);
	public Customer findByName(String name);
}
