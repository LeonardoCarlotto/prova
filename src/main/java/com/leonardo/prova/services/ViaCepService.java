package com.leonardo.prova.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.leonardo.prova.response.ViaCepResponse;

@FeignClient(name = "viacepService", url="http://viacep.com.br")
public interface ViaCepService {
	
	 @RequestMapping("/ws/{cep}/json/")
	 ViaCepResponse getCep(@PathVariable("cep") String cep);
	 

}
