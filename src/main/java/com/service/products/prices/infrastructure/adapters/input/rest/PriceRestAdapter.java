package com.service.products.prices.infrastructure.adapters.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.products.prices.application.ports.input.GetPriceUseCase;
import com.service.products.prices.domain.model.Price;
import com.service.products.prices.infrastructure.adapters.input.rest.data.request.PriceParamsRequest;
import com.service.products.prices.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;
import com.service.products.prices.infrastructure.adapters.input.rest.mapper.PriceRestMapper;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/products")
@AllArgsConstructor
public class PriceRestAdapter {

	private final PriceRestMapper priceRestMapper;
	
	private final GetPriceUseCase getPriceUseCase;
	
	@PostMapping(value = "/price")
	public ResponseEntity<PriceQueryResponse> getPrice(@RequestBody PriceParamsRequest priceParamsRequest){
		Price price = priceRestMapper.toPrice(priceParamsRequest);
		price = getPriceUseCase.getPriceByIdAndEffectiveDate(price);
		return new ResponseEntity<PriceQueryResponse>(priceRestMapper.toPriceQueryResponse(price), HttpStatus.OK); 
	}
	
}
