package com.service.products.prices.infrastructure.adapters.output.persistence;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

import com.service.products.prices.application.ports.output.PriceOutputPort;
import com.service.products.prices.domain.model.Price;
import com.service.products.prices.infrastructure.adapters.output.persistence.entity.PriceEntity;
import com.service.products.prices.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import com.service.products.prices.infrastructure.adapters.output.persistence.repository.PriceRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PricePersistenceAdapter implements PriceOutputPort {
	
	private final PriceRepository priceRepository;
	
	private final PricePersistenceMapper pricePersistenceMapper;
	
	@Override
	public Optional<Price> getPriceByIdAndEffectiveDate(Long brandId, Long productId, Date effectiveDate) {
		Collection<PriceEntity> priceEntityList = priceRepository.getProductsBrandByDateRange(brandId, productId, new Timestamp(effectiveDate.getTime()));
		Price price = null;
		if(priceEntityList.isEmpty()) {
			return Optional.empty();
		}else {
			for (PriceEntity priceEntity : priceEntityList) {
				if(!Objects.isNull(priceEntity)) {
					if(Objects.isNull(price)) {
						price = pricePersistenceMapper.toPrice(priceEntity);
					}else {
						if((!Objects.isNull(priceEntity.getPriority()) && !Objects.isNull(priceEntity.getPriority())) && 
								(priceEntity.getPriority() > price.getPriority())) {
							price = pricePersistenceMapper.toPrice(priceEntity);
						}
					}
						
				}
			}
		}
		return Optional.of(price);
	}

}
