package com.engreuso.service;

import com.engreuso.model.Customer;

public interface CustomerService {

	Customer save(Customer user);
	Iterable findAll();
	Customer findOne(Long id);
	Customer update(Customer customer);
	void deleteById(Long id);

}
