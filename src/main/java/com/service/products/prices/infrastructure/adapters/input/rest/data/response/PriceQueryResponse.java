package com.service.products.prices.infrastructure.adapters.input.rest.data.response;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceQueryResponse {

	@JsonProperty("brandId")
	private Long brandId;
	
	@JsonProperty("startDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date startDate;
	
	@JsonProperty("endDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	private Date endDate;
	
	@JsonProperty("priceListId")
	private Long priceListId;
	
	@JsonProperty("productId")
	private Long productId;
	
	@JsonProperty("price")
	private BigDecimal price;
	
}
