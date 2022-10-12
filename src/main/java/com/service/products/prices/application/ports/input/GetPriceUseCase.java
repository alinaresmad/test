package com.service.products.prices.application.ports.input;

import com.service.products.prices.domain.model.Price;

public interface GetPriceUseCase {

	Price getPriceByIdAndEffectiveDate(Price price);
	
}
