package com.engreuso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engreuso.model.Customer;
import com.engreuso.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository userRepository;

	@Override
	public Customer getById(Long id) {
		Customer user = userRepository.findOne(id);
		if (user == null) {
			throw new RuntimeException("User not found!");
		}
		return user;
	}

	@Override
	public Customer save(Customer user) {
		return userRepository.save(user);
	}
}
