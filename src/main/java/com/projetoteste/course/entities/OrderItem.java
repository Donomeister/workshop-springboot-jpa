package com.projetoteste.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.projetoteste.course.entities.PK.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_orderitem")
public class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id;
	
	private Double price;
	private Integer quantity;
	
	public OrderItem(){
	}
	
	public OrderItem(Product product, Order order,Integer quantity,  Double price) {
		super();
		this.quantity = quantity;
		id.setOrder(order);
		id.setProduct(product);
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public void getProduct(Product product) {
		id.setProduct(product);
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
