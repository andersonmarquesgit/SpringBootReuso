package com.engreuso.service;

import com.engreuso.model.Customer;

public interface CustomerService {

	Customer getById(Long id);
	Customer save(Customer user);

}
