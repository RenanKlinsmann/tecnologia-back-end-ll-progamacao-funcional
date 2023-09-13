package com.example.demo.repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Produto;

@Repository
public class ProdutoRepositorio {
	public List<Produto> findAllProduto(){
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "Notebook", 5000.0));
		list.add(new Produto(1, "Notebook", 5000.0));
		list.add(new Produto(2, "Celular", 1900.0));
		list.add(new Produto(3, "Mouse", 50.0));
		list.add(new Produto(4, "Teclado", 200.0));
		list.add(new Produto(5, "Monitor", 2000.0));
		
		return list;
	}
	
	public List<Produto> findAllProdutoNovo(){
		List<Produto> list = new ArrayList<>();
		list.add(new Produto(1, "Feijao", 8.0));
		list.add(new Produto(1, "Feijao", 8.0));
		list.add(new Produto(2, "Arroz", 5.0));
		list.add(new Produto(3, "Macarrao", 3.0));
		list.add(new Produto(4, "Carne", 40.0));
		list.add(new Produto(5, "Peixe", 25.0));
		
		return list;
	}
}
