package com.engreuso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engreuso.model.Customer;
import com.engreuso.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

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
		return customerRepository.findOne(id);
	}

	@Override
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public void deleteById(Long id) {
		customerRepository.delete(id);		
	}
}
