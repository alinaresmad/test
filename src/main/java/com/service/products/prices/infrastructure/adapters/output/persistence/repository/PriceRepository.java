package com.service.products.prices.infrastructure.adapters.output.persistence.repository;

import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.products.prices.infrastructure.adapters.output.persistence.entity.PriceEntity;
import com.service.products.prices.infrastructure.adapters.output.persistence.entity.PriceId;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, PriceId> {
	
	@Query("SELECT pe FROM PriceEntity pe WHERE pe.brandId = ?1 and pe.productId = ?2 and (?3 BETWEEN pe.startDate AND pe.endDate)")
	Collection<PriceEntity>  getProductsBrandByDateRange(Long brandId, Long productId, Timestamp effectiveDate);

}
