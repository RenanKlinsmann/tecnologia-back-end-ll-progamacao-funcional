package com.example.demo.services;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Produto;
import com.example.demo.repositorios.ProdutoRepositorio;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> findAllProduto(){
		List<Produto> list = repositorio.findAllProduto();
		/*Comparator<Produto> comp = new Comparator<Produto>() {
			
			@Override
			public int compare(Produto p1, Produto p2) {
				return p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());
			}
		};*/
		
		/*Comparator<Produto> comp = (p1, p2) -> 
			 p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase());*/
		
		list.sort((p1, p2) -> p1.getNome().toUpperCase().compareTo(p2.getNome().toUpperCase()));
		return list;
	}
	
	public List<Produto> findAllPredicate (){
		List<Produto> list = repositorio.findAllProduto();
		/*Predicate<Produto> pred = new Predicate<Produto>() {
			
			@Override
			public boolean test(Produto t) {
				return t.getPreco() <= 200;
			}
		};*/
		
		/*Predicate<Produto> pred = (p) -> p.getPreco() <= 200;*/
		
		
		
		list.removeIf((p) -> p.getPreco() <= 200);
		
		return list;
	}
	
	public List<Produto> findAllConsumer (){
		List<Produto> list = repositorio.findAllProduto();
		

		
		list.forEach(new Produto());
		
		return list;
	}
}
