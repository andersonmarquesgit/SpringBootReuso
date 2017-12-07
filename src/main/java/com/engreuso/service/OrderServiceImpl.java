package com.engreuso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engreuso.model.Order;
import com.engreuso.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrdersService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Iterable findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}

	@Override
	public Order update(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.delete(id);
	}

	@Override
	public void delete(Iterable orders) {
		orderRepository.deleteInBatch(orders);
	}

}
