package com.service.products.prices.infrastructure.adapters.input.rest.data.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

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
public class PriceParamsRequest {

	@JsonProperty("brandId")
	@NotEmpty(message = "Brand id not be empty")
	private Long brandId;
	
	@JsonProperty("productId")
	@NotEmpty(message = "Product id not be empty")
	private Long productId;
	
	@JsonProperty("effectiveDate")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", locale = "es_ES", timezone = "Europe/Madrid")
	//@NotEmpty(message = "Effective date not be empty")
	private Date effectiveDate;
	
}
