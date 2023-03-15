package com.leonardo.prova.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.leonardo.prova.model.ContaModel;
import com.leonardo.prova.repository.ContaRepo;
import com.leonardo.prova.response.ViaCepResponse;
import com.leonardo.prova.services.ViaCepService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ContaController {
	
	@Autowired
	ViaCepService viacepService;

	@Autowired
	ContaRepo contaRepo;
	
	@PostMapping("/new-conta")
	public ResponseEntity<?> newConta(@RequestBody ContaModel conta){
		contaRepo.save(conta);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/contas")
	public List<ContaModel> getContas(){
		return contaRepo.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@PostMapping("/conta/{id}")
	public ContaModel newConta(@RequestBody ContaModel conta, @PathVariable long id){
		if(contaRepo.existsById(id)) {
			Optional<ContaModel> contaOpt = contaRepo.findById(id);
			ContaModel contaAux = contaOpt.get();
			contaAux.setName(conta.getName());
			contaAux.setDescription(conta.getDescription());
			contaRepo.save(contaAux);
			return contaAux;
		}
		return null;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@DeleteMapping("/conta/{id}")
	public ResponseEntity<?> deleteConta(@PathVariable long id){
		if(contaRepo.existsById(id)) {
			Optional<ContaModel> contaOpt = contaRepo.findById(id);
			ContaModel contaAux = contaOpt.get();
			contaRepo.delete(contaAux);
			return ResponseEntity.ok("Conta deletada");
		}
		return null;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/cep/{cep}")
	public ViaCepResponse findCep(@PathVariable String cep) {
		return viacepService.getCep(cep);
	}
	
}
