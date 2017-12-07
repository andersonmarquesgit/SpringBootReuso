package com.engreuso.service;

import com.engreuso.model.Customer;
import com.engreuso.model.Order;

public interface CustomerService {

	Customer save(Customer customer);
	Iterable findAll();
	Customer findOne(Long id);
	Customer update(Long id, Customer customerUpdated);
	void delete(Long id);
	void deleteOrdersByCustomerID(Long id);
	Customer saveOrderByCustomerID(Long id, Order order);
	Iterable getOrdersByCustomerID(Long id);

}
