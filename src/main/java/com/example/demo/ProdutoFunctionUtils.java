package com.example.demo;

import java.util.List;
import java.util.function.Predicate;

import com.example.demo.entidades.Produto;

public class ProdutoFunctionUtils {
	
	public double somaProdutos(List<Produto> list, Predicate<Produto> creterio) {
		double sum = 0.0;
		
		for(Produto produto : list) {
			if(creterio.test(produto)) {
				sum += produto.getPreco();
			}
		}
		
		return sum;
	}

}
