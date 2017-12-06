package com.engreuso.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.engreuso.model.Customer;
import com.engreuso.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable listAll() {
		return customerService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@RequestBody Customer customer) {
		return customerService.save(customer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer get(@PathVariable("id") Long id) {
		return customerService.findOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Customer update(@PathVariable("id") Long id, @RequestBody String name) {
		Customer customerUpdated = customerService.findOne(id);
		if(customerUpdated != null) {
			customerUpdated.setName(name);
		}
		return customerService.update(customerUpdated);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		customerService.deleteById(id);
	}
}