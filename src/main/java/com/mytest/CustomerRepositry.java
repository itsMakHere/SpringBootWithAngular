package com.mytest;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositry extends CrudRepository<Customer, Integer>{
}
