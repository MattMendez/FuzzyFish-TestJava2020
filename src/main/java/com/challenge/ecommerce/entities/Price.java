package com.challenge.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Price  {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long priceList;

  private Long brandId;

  private Long productId;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Integer priority;

  private Double price;

  private String currency;

}
