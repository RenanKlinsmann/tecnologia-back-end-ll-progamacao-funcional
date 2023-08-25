package com.example.demo.services;

import java.util.Comparator;
import java.util.List;

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
		list.removeIf(new Produto());
		return list;
	}
}
