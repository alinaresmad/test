package com.service.products.prices.infrastructure.adapters.output.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Builder
@Table(name = "PRICES")
@IdClass(PriceId.class)
public class PriceEntity implements Serializable {

	private static final long serialVersionUID = -4222171972045838589L;

	@Id
	@Column(name = "BRAND_ID")
	private Long brandId;
	
	@Column(name = "START_DATE")
	private Timestamp startDate;
	
	@Column(name = "END_DATE")
	private Timestamp endDate;
	
	@Id
	@Column(name = "PRICE_LIST")
	private Long priceListId;
	
	@Id
	@Column(name = "PRODUCT_ID")
	private Long productId;
	
	@Column(name = "PRIORITY")
	private int priority;
	
	@Column(name = "PRICE")
	private BigDecimal price;
	
	@Column(name = "CURR")
	private String curr;
	
	public PriceEntity() {
		
	}
	
	public PriceEntity (Long brandId, Timestamp startDate, Timestamp endDate, Long priceListId, Long productId, int priority, BigDecimal price, String curr) {
		this.brandId = brandId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceListId = priceListId;
		this.productId = productId;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
}
