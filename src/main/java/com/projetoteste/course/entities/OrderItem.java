package com.projetoteste.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projetoteste.course.entities.PK.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Double price;
	private Integer quantity;
	
	public OrderItem(){
	}
	
	public OrderItem(Order order, Product product, Integer quantity,  Double price) {
		super();
		this.quantity = quantity;
		id.setOrder(order);
		id.setProduct(product);
		this.price = price;
	}
	
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}
	
	@JsonIgnore
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
	public void setProduct(Product product) {
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
	
	public Double getsubTotal() {
		return price*quantity;
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
