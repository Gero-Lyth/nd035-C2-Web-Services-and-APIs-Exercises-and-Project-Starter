package com.udacity.pricing;

import com.udacity.pricing.entity.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.net.URI;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@SpringBootTest
public class PricingServiceApplicationTests {
	@Autowired
	private MockMvc mvc;

	@Autowired
	private JacksonTester<Price> json;

	@Test
	public void contextLoads() {
	}

	@Test
	public void getPrice() throws  Exception{
		Price price = new Price(1L,"eur", BigDecimal.TEN,1L);
		mvc.perform(
						post(new URI("/prices"))
								.content(json.write(price).getJson())
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());
		mvc.perform(
						get(new URI("/prices/1")))
				.andExpect(status().isOk());
	}
	@Test
	public void createPrice() throws Exception{
		Price price = new Price(1L,"eur", BigDecimal.TEN,1L);
		mvc.perform(
						post(new URI("/prices"))
								.content(json.write(price).getJson())
								.contentType(MediaType.APPLICATION_JSON_UTF8)
								.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isCreated());
	}

}
