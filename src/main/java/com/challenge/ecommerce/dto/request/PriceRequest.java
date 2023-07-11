package com.challenge.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceRequest {

    @NotBlank
    @NotNull
    private LocalDateTime date;

    @NotBlank
    @NotNull
    private Long productId;

    @NotBlank
    @NotNull
    private Long brandId;

}