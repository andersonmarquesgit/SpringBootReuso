package com.engreuso.service;

import com.engreuso.model.Order;

public interface OrdersService {
	Order save(Order order);
	Iterable findAll();
	Order findOne(Long id);
	Order update(Order order);
	void delete(Order order);
	void delete(Iterable orders);
}
