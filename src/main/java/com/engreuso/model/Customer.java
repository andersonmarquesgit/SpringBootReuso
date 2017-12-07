package com.engreuso.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name="tb_customer_orders", 
		joinColumns=@JoinColumn(table="tb_customer", name="customer_id", referencedColumnName="id"),
		inverseJoinColumns=@JoinColumn(table="tb_order",name="order_id", referencedColumnName="id")
	)
	private List<Order> orders;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
