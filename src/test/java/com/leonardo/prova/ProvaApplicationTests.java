package com.leonardo.prova;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import com.leonardo.prova.response.ViaCepResponse;
import com.leonardo.prova.services.ViaCepService;

@SpringBootTest
@AutoConfigureMockMvc
class ProvaApplicationTests {

	@Autowired
	ViaCepService viacepService;
	
	 @Autowired
	 MockMvc mockMvc;
	 
	
	@Test
	void contextLoads() throws Exception {
		this.mockMvc.perform(get("/cep/99711082")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Erechim")));
	}

}
