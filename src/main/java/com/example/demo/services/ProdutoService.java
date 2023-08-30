package com.example.demo.services;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ProdutoFunctionUtils;
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
		

		/*Consumer<Produto> consu = new Consumer<Produto>() {
			
			@Override
			public void accept(Produto t) {
				t.setPreco(t.getPreco() +100);
				
			}
		};*/
		
		/*Consumer<Produto> consu =  p -> p.setPreco(p.getPreco() +100);*/
		
		list.forEach(p -> p.setPreco(p.getPreco() +100));
		
		return list;
	}
	
	public List<Produto> findAllFunction (){
		/* 1 - criar um lambda declarado;*/
		/* 2 - criar um lambda inline;*/
		
		List<Produto> list = repositorio.findAllProduto();
		
		List<Produto> listUpper = list.stream()
				.map(new Produto())
				.collect(Collectors.toList());
		
		
		
		return listUpper;
	}
	
	public double somaTodos() {
		List<Produto> list = repositorio.findAllProduto();
		
		ProdutoFunctionUtils prod = new ProdutoFunctionUtils();
		double total = prod.somaProdutos(list, p -> p.getPreco() > 0);
		
		return total;
	}
}
