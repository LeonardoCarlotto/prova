package com.leonardo.prova;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leonardo.prova.response.ViaCepResponse;
import com.leonardo.prova.services.ViaCepService;

@SpringBootTest
class ProvaApplicationTests {

	@Autowired
	ViaCepService viacepService;
	
	@Test
	void contextLoads() {
		ViaCepResponse res = viacepService.getCep("99711082");
		assertEquals(res.getBairro(), "Espírito Santo");
	}

}
