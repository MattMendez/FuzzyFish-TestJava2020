package com.challenge.ecommerce.controllers;

import com.challenge.ecommerce.dto.request.PriceRequest;
import com.challenge.ecommerce.services.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController {

  @Autowired
  private PriceService priceService;

  @Operation(summary="Find the correct price", description ="Service to find the correct price of a product by ids and date")
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
          description = "Request format",
          required = true,
          content = @Content(
                  mediaType = MediaType.APPLICATION_JSON_VALUE,
                  examples = @ExampleObject("{\n" +
                          "  \"date\": \"2020-12-31T23:59:58\",\n" +
                          "  \"productId\": 35455,\n" +
                          "  \"brandId\": 1\n" +
                          "}")))
  @ApiResponses(value = {
          @ApiResponse(
                  responseCode = "200",
                  content = @Content(
                          mediaType = "application/json",
                          examples = @ExampleObject(
                                  name = "Search successfully",
                                  value = "{\n" +
                                          "    \"productId\": 35455,\n" +
                                          "    \"brandId\": 1,\n" +
                                          "    \"priceList\": 4,\n" +
                                          "    \"startDate\": \"2020-06-15T16:00:00\",\n" +
                                          "    \"endDate\": \"2020-12-31T23:59:59\",\n" +
                                          "    \"price\": 38.95\n" +
                                          "}")
                  )
          ),
          @ApiResponse(
                  responseCode = "204",
                  content = @Content(
                          mediaType = "application/json",
                          examples = @ExampleObject(
                                  name = "No price found",
                                  value =  "")
                  )
          ),
  })
  @GetMapping("/price")
  public ResponseEntity findPrice(@RequestBody PriceRequest request) {
    return priceService.findByProductIdAndBrandIdAndCurrentDate(request);
  }

}
