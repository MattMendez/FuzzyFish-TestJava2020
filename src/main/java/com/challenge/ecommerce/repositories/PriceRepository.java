package com.challenge.ecommerce.repositories;

import com.challenge.ecommerce.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query(value = "SELECT * FROM PRICE " +
            "WHERE (PRODUCT_ID =?1 AND BRAND_ID =?2 AND ?3 BETWEEN START_DATE AND END_DATE) " +
            "ORDER BY PRIORITY DESC LIMIT 1", nativeQuery = true)
    Optional<Price> findByProductIdAndBrandIdAndCurrentDate(Long productId, Long brandId,
                                                           LocalDateTime date);
}
