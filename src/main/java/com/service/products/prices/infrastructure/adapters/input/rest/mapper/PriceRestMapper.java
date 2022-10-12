package com.service.products.prices.infrastructure.adapters.input.rest.mapper;

import com.service.products.prices.domain.model.Price;
import com.service.products.prices.infrastructure.adapters.annotations.Mapper;
import com.service.products.prices.infrastructure.adapters.input.rest.data.request.PriceParamsRequest;
import com.service.products.prices.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;

@Mapper
public class PriceRestMapper {
	
	public PriceRestMapper() {
		super();
	}

	public PriceQueryResponse toPriceQueryResponse(Price price) {
		return PriceQueryResponse.builder()
								 .brandId(price.getBrandId())
								 .startDate(price.getStartDate())
								 .endDate(price.getEndDate())
								 .priceListId(price.getPriceListId())
								 .price(price.getPrice())
								 .productId(price.getProductId())
								 .build();				   
	}
	
	public Price toPrice(PriceParamsRequest priceParamsRequest) {
		return Price.builder()
					.brandId(priceParamsRequest.getBrandId())
					.productId(priceParamsRequest.getProductId())
					.effectiveDate(priceParamsRequest.getEffectiveDate())
					.build();
	}
	
}
