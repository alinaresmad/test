package com.service.products.prices.domain.exception;

@SuppressWarnings("serial")
public class PriceNotFoundException extends RuntimeException {

	public PriceNotFoundException(String msg) {
		super(msg);
	}
	
}
