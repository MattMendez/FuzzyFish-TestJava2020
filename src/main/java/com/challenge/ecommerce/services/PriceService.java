package com.challenge.ecommerce.services;

import com.challenge.ecommerce.dto.request.PriceRequest;
import com.challenge.ecommerce.dto.response.PriceResponse;
import com.challenge.ecommerce.entities.Price;
import com.challenge.ecommerce.exceptions.EmptySearchException;
import com.challenge.ecommerce.exceptions.SqlException;
import com.challenge.ecommerce.repositories.PriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceService {

  @Autowired
  private PriceRepository priceRepository;

  private final Logger log = LoggerFactory.getLogger(PriceService.class);

  public ResponseEntity findByProductIdAndBrandIdAndCurrentDate(PriceRequest priceRequest) {
    log.info("[findByProductIdAndBrandIdAndCurrentDate] Method call Start");

    try {
      Optional<Price> optionalPrice = priceRepository.findByProductIdAndBrandIdAndCurrentDate(
              priceRequest.getProductId(), priceRequest.getBrandId(), priceRequest.getDate());

      if (optionalPrice.isPresent()) {
        Price price = optionalPrice.get();

        log.info("[findByProductIdAndBrandIdAndCurrentDate] Database retrieve : " + price);

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
        return ResponseEntity.ok(priceResponse);
      }
    } catch (Exception e) {
      log.info("[findByProductIdAndBrandIdAndCurrentDate] Error found : " + e.getMessage());
      throw new SqlException();
    }

    log.info("[findByProductIdAndBrandIdAndCurrentDate] Method call end with 0 results");
    throw new EmptySearchException();
  }

}