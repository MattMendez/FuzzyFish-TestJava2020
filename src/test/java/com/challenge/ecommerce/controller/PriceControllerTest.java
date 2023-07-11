package com.challenge.ecommerce.controller;

import com.challenge.ecommerce.controllers.PriceController;
import com.challenge.ecommerce.dto.request.PriceRequest;
import com.challenge.ecommerce.dto.response.PriceResponse;
import com.challenge.ecommerce.exceptions.EmptySearchException;
import com.challenge.ecommerce.repositories.PriceRepository;
import com.challenge.ecommerce.services.PriceService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class PriceControllerTest {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceController priceController;

    @Autowired
    PriceService priceService;

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void test1(){

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2020-06-14T10:00:00"))
                .productId(35455L)
                .build();

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(1L)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price(35.5)
                .build();

        ResponseEntity<PriceResponse> responseEntity = ResponseEntity.ok(priceResponse);

        Assert.assertEquals( responseEntity, priceController.findPrice(priceRequest));

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void test2(){

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2020-06-14T16:00:00"))
                .productId(35455L)
                .build();

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(2L)
                .startDate(LocalDateTime.parse("2020-06-14T15:00:00"))
                .endDate(LocalDateTime.parse("2020-06-14T18:30:00"))
                .price(25.45)
                .build();

        ResponseEntity<PriceResponse> responseEntity = ResponseEntity.ok(priceResponse);

        Assert.assertEquals( responseEntity, priceController.findPrice(priceRequest));

    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)")
    public void test3() throws Exception {

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2020-06-14T21:00:00"))
                .productId(35455L)
                .build();

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(1L)
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price(35.50)
                .build();

        ResponseEntity<PriceResponse> responseEntity = ResponseEntity.ok(priceResponse);

        Assert.assertEquals( responseEntity, priceController.findPrice(priceRequest));

    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)")
    public void test4() throws Exception {

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2020-06-15T10:00:00"))
                .productId(35455L)
                .build();

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(3L)
                .startDate(LocalDateTime.parse("2020-06-15T00:00:00"))
                .endDate(LocalDateTime.parse("2020-06-15T11:00:00"))
                .price(30.50)
                .build();

        ResponseEntity<PriceResponse> responseEntity = ResponseEntity.ok(priceResponse);

        Assert.assertEquals( responseEntity, priceController.findPrice(priceRequest));

    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)")
    public void test5() throws Exception {

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2020-06-16T21:00:00"))
                .productId(35455L)
                .build();

        PriceResponse priceResponse = PriceResponse.builder()
                .productId(35455L)
                .brandId(1L)
                .priceList(4L)
                .startDate(LocalDateTime.parse("2020-06-15T16:00:00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59"))
                .price(38.95)
                .build();

        ResponseEntity<PriceResponse> responseEntity = ResponseEntity.ok(priceResponse);

        Assert.assertEquals( responseEntity, priceController.findPrice(priceRequest));

    }

    @Test(expected = EmptySearchException.class)
    @DisplayName("Test 6: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA) pero anio 2023")
    public void test6() throws Exception {

        PriceRequest priceRequest = PriceRequest.builder()
                .brandId(1L)
                .date(LocalDateTime.parse("2023-06-16T21:00:00"))
                .productId(35455L)
                .build();



        priceController.findPrice(priceRequest);

    }

}
