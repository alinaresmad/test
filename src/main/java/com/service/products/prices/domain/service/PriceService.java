package com.service.products.prices.domain.service;

import com.service.products.prices.application.ports.input.GetPriceUseCase;
import com.service.products.prices.application.ports.output.PriceOutputPort;
import com.service.products.prices.domain.exception.PriceNotFoundException;
import com.service.products.prices.domain.model.Price;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PriceService implements GetPriceUseCase {
	
	
	private final PriceOutputPort priceOutputPort;
	
	@Override	
	public Price getPriceByIdAndEffectiveDate(Price price) {
		return priceOutputPort.getPriceByIdAndEffectiveDate(price.getBrandId(), price.getProductId(), price.getEffectiveDate())
							  .orElseThrow(() -> new PriceNotFoundException("Price not found for this brandId, productId and effective date"));
	}

}
