package com.service.products.prices.infrastructure.adapters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.service.products.prices.application.ports.output.PriceOutputPort;
import com.service.products.prices.domain.service.PriceService;
import com.service.products.prices.infrastructure.adapters.output.persistence.PricePersistenceAdapter;
import com.service.products.prices.infrastructure.adapters.output.persistence.mapper.PricePersistenceMapper;
import com.service.products.prices.infrastructure.adapters.output.persistence.repository.PriceRepository;

@Configuration
public class BeanConfig {

	@Bean
	public PricePersistenceAdapter pricePersistenceAdapter(PriceRepository priceRepository, PricePersistenceMapper pricePersistenceMapper) {
		return new PricePersistenceAdapter(priceRepository, pricePersistenceMapper);
	}
	
	@Bean
	public PriceService priceService(PriceOutputPort priceOutputPort) {
		return new PriceService(priceOutputPort);
	}
	
}
