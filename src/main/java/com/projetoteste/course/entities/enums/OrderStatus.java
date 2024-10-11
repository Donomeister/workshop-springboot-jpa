package com.projetoteste.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(0),
	PAID(1),
	SHIPPED(2),
	DELIVERED(3),
	CANCELED(4);
	
	private int code;
	
	public int getCode() {
		return code;
	}
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		return null;
	}
}
