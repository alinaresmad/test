package com.service.products.prices.infrastructure.adapters.output.persistence.mapper;

import com.service.products.prices.domain.model.Price;
import com.service.products.prices.infrastructure.adapters.annotations.Mapper;
import com.service.products.prices.infrastructure.adapters.output.persistence.entity.PriceEntity;

@Mapper
public class PricePersistenceMapper {

	public PriceEntity toPriceEntity(Price price) {
		return PriceEntity.builder()
						  .brandId(price.getBrandId())
						  .productId(price.getProductId())
						  .build();
	}
	
	public Price toPrice(PriceEntity priceEntity) {
		return Price.builder()
					.brandId(priceEntity.getBrandId())
					.startDate(priceEntity.getStartDate())
					.endDate(priceEntity.getEndDate())
					.priceListId(priceEntity.getPriceListId())
					.price(priceEntity.getPrice())
					.productId(priceEntity.getProductId())
					.build();
	}
}
