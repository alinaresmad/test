package com.service.products.prices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Supplier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.service.products.prices.infrastructure.adapters.input.rest.data.request.PriceParamsRequest;
import com.service.products.prices.infrastructure.adapters.input.rest.data.response.PriceQueryResponse;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PricesApplicationTests {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PricesApplicationTests.class);
	
	/*
	 * Indicar el puerto en el que se levanta la aplicación, valor default tomcat 8080
	 */
	private int port = 8080;
	
	/**
	 * Recursos locales
	 */
	private String baseUrl = "http://localhost"; //CAMBIAR POR HOST LOCAL
	private static RestTemplate restTemplate;
	private final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss";
	private final String apiResourceEndpoint = "/api/v1/products/price";
	
	long brandId = 1;
	long productId = 35455;
	private final String effectiveDateTest_1 = "2020-06-14T10:00:00";
	private final String effectiveDateTest_2 = "2020-06-14T16:00:00";
	private final String effectiveDateTest_3 = "2020-06-14T21:00:00";
	private final String effectiveDateTest_4 = "2020-06-15T10:00:00";
	private final String effectiveDateTest_5 = "2020-06-16T21:00:00";
	
	ObjectWriter jsonMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
	
	@BeforeAll
	public static void init() {
		restTemplate = new RestTemplate();
	}
	
	@BeforeEach
	public void setup() {
		baseUrl = baseUrl.concat(":").concat(Integer.toString(port)).concat(apiResourceEndpoint);
	}
	
	//
	//=======================INICIO TESTS========================================================
	//
	
	/**
	 * Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	@Test
	public void test_1() throws ParseException, JsonProcessingException {
		PriceQueryResponse priceQueryResponse = restTemplate.postForObject(baseUrl, setPriceParamsRequest(effectiveDateTest_1), PriceQueryResponse.class);
		LOGGER.info(setSupplierResult("Json result for test_1====================="));
		LOGGER.info(setSupplierResult(jsonMapper.writeValueAsString(priceQueryResponse)));
		LOGGER.info(setSupplierResult("test_1 finished====================="));
	}
	
	/**
	 * Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	@Test
	public void test_2() throws ParseException, JsonProcessingException {
		PriceQueryResponse priceQueryResponse = restTemplate.postForObject(baseUrl, setPriceParamsRequest(effectiveDateTest_2), PriceQueryResponse.class);
		LOGGER.info(setSupplierResult("Json result for test_2====================="));
		LOGGER.info(setSupplierResult(jsonMapper.writeValueAsString(priceQueryResponse)));
		LOGGER.info(setSupplierResult("test_1 finished====================="));
	}
	
	/**
	 * Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	@Test
	public void test_3() throws ParseException, JsonProcessingException {
		PriceQueryResponse priceQueryResponse = restTemplate.postForObject(baseUrl, setPriceParamsRequest(effectiveDateTest_3), PriceQueryResponse.class);
		LOGGER.info(setSupplierResult("Json result for test_3====================="));
		LOGGER.info(setSupplierResult(jsonMapper.writeValueAsString(priceQueryResponse)));
		LOGGER.info(setSupplierResult("test_1 finished====================="));
	}
	
	/**
	 * Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	@Test
	public void test_4() throws ParseException, JsonProcessingException {
		PriceQueryResponse priceQueryResponse = restTemplate.postForObject(baseUrl, setPriceParamsRequest(effectiveDateTest_4), PriceQueryResponse.class);
		LOGGER.info(setSupplierResult("Json result for test_4====================="));
		LOGGER.info(setSupplierResult(jsonMapper.writeValueAsString(priceQueryResponse)));
		LOGGER.info(setSupplierResult("test_1 finished====================="));
	}
	
	/**
	 * Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
	 * @throws ParseException
	 * @throws JsonProcessingException
	 */
	@Test
	public void test_5() throws ParseException, JsonProcessingException {
		PriceQueryResponse priceQueryResponse = restTemplate.postForObject(baseUrl, setPriceParamsRequest(effectiveDateTest_5), PriceQueryResponse.class);
		LOGGER.info(setSupplierResult("Json result for test_5====================="));
		LOGGER.info(setSupplierResult(jsonMapper.writeValueAsString(priceQueryResponse)));
		LOGGER.info(setSupplierResult("test_1 finished====================="));
	}
	
	//
	//=======================FIN TESTS========================================================
	//
	
	private PriceParamsRequest setPriceParamsRequest(String effectiveDate) throws ParseException {
		return PriceParamsRequest.builder()
								 .brandId(brandId)
							 	 .productId(productId)
							 	 .effectiveDate(new SimpleDateFormat(dateFormat).parse(effectiveDate))
							 	 .build();
	}
	
	private Supplier<String> setSupplierResult(String jsonString){
		return ()-> jsonString;
	}

}