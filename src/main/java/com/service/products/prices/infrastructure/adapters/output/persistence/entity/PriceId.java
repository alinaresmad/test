package com.service.products.prices.infrastructure.adapters.output.persistence.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class PriceId implements Serializable {

	private Long brandId;
	private Long productId;
	private Long priceListId;
	
}
