package com.service.products.prices.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Price {

	private Long brandId;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date endDate;
	
	private Long priceListId;
	
	private Long productId;
	
	private int priority;
	
	private BigDecimal price;
	
	private String curr;
	
	private Date effectiveDate;
	
}
