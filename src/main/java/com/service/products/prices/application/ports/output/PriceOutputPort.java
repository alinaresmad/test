package com.service.products.prices.application.ports.output;

import java.util.Date;
import java.util.Optional;

import com.service.products.prices.domain.model.Price;

public interface PriceOutputPort {

	Optional<Price> getPriceByIdAndEffectiveDate(Long brandId, Long productId, Date effectiveDate);
	
}
