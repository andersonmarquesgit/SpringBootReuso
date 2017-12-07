package com.engreuso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engreuso.exceptions.CustomerNotFoundException;
import com.engreuso.model.Customer;
import com.engreuso.model.Order;
import com.engreuso.repository.CustomerRepository;
import com.engreuso.repository.OrderRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Iterable findAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findOne(Long id) {
		Customer customer = customerRepository.findOne(id);
		if (customer == null) throw new CustomerNotFoundException(id);
		
		return customer;
	}

	@Override
	public Customer update(Long id, Customer customerUpdated) {
		Customer customer = customerRepository.findOne(id);
		
		if (customer == null) {
			throw new CustomerNotFoundException(id);
		}else {
			customer.setName(customerUpdated.getName());
		}
		
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Long id) {
		Customer customer = customerRepository.findOne(id);
		if (customer == null) {
			throw new CustomerNotFoundException(id);
		}else {
			customerRepository.delete(customer);		
		}
		
	}

	@Override
	public Customer saveOrderByCustomerID(Long id, Order order) {
		Customer customer = customerRepository.findOne(id);
		if (customer == null) {
			throw new CustomerNotFoundException(id);
		}else {
			order.setCustomer(customer);
			orderRepository.save(order);
		}
		return customer;
	}

	@Override
	public Iterable getOrdersByCustomerID(Long id) {
		Customer customer = customerRepository.findOne(id);
		Iterable orders;
		if (customer == null) {
			throw new CustomerNotFoundException(id);
		}else {
			orders = customer.getOrders();
		}
		return orders;
	}

	@Override
	public void deleteOrdersByCustomerID(Long id) {
		Customer customer = customerRepository.findOne(id);
		Iterable orders;
		if (customer == null) {
			throw new CustomerNotFoundException(id);
		}else {
			orders = customer.getOrders();
			orderRepository.deleteInBatch(orders);
		}
		
	}
}
