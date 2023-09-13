package com.example.demo.controlles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Produto;
import com.example.demo.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public List<Produto> findAllProduto(){
		return service.findAllProduto();
	}
	
	@GetMapping("/predicate")
	public List<Produto> findAllPredicate(){
		return service.findAllPredicate();
	}
	
	@GetMapping("/consumer")
	public List<Produto> findAllConsumer(){
		return service.findAllConsumer();
	}
	
	@GetMapping("/function")
	public List<Produto> findAllFunction(){
		return service.findAllFunction();
	}
	
	@GetMapping("/functionTotal")
	public double findFunctionTotal(){
		return service.somaTodos();
	}
	
	@GetMapping("/stream")
	public List<Produto> findStream(){
		return service.funcaoStream();
	}
	
}
