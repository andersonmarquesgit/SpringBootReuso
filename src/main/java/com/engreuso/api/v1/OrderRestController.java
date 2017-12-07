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

import com.engreuso.exceptions.OrderNotFoundException;
import com.engreuso.model.Order;
import com.engreuso.service.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

	@Autowired
	private OrdersService orderService;
	
	@Autowired
	private OrdersService ordersService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody Iterable listAll() {
		return orderService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Order save(@RequestBody Order order) {
		return orderService.save(order);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Order get(@PathVariable("id") Long id) {
		Order order = orderService.findOne(id);
		if (order == null) throw new OrderNotFoundException(id);
		
		return order;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody Order update(@PathVariable("id") Long id, @RequestBody Order order) {
		Order orderUpdated = orderService.findOne(id);
		if (orderUpdated == null) {
			throw new OrderNotFoundException(id);
		}else {
			orderUpdated.setReason(order.getReason());
			orderUpdated.setService(order.getService());
			orderUpdated = orderService.update(orderUpdated);
		}
		
		return orderUpdated;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		Order order = orderService.findOne(id);
		if (order == null) {
			throw new OrderNotFoundException(id);
		}else {
			orderService.delete(order);
		}
		
	}
	
}