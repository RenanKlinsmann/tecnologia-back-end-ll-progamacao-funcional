package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		Predicate<Produto> pred = new Predicate<Produto>() {
			
			@Override
			public boolean test(Produto t) {
				return t.getPreco() <= 200;
			}
		};
		
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
				.map(p -> {p.setNome(p.getNome().toUpperCase()); return p; })
				.collect(Collectors.toList());
		
		
		
		return listUpper;
	}
	
	public double somaTodos() {
		List<Produto> list = repositorio.findAllProduto();
		
		ProdutoFunctionUtils prod = new ProdutoFunctionUtils();
		double total = prod.somaProdutos(list, p -> p.getPreco() > 0);
		
		return total;
	}
	
	public List<Produto> funcaoStream() {
		List<Produto> list = repositorio.findAllProduto();
		List<Produto> listteste = repositorio.findAllProdutoNovo();
		Integer um = 1;
		
		List<List<Produto>> dupla = new ArrayList<>();
		dupla.add(listteste);
		dupla.add(list);


		List<Produto> teste = dupla.stream().flatMap(Collection::stream)
											.filter(distinctByKey(p -> p.getId()))
											.map((p) -> {p.setNome(p.getNome() + " teste"); return p;})
											.peek(p -> p.setPreco(p.getPreco() +100))
											.sorted(Comparator.comparing(Produto::getPreco))
											.distinct()
											//.skip(3)
											.limit(2)
										    .collect(Collectors.toList());
		
		return teste;
	}
	
	public static <T> Predicate<T> distinctByKey(
		    Function<? super T, ?> keyExtractor) {
		  
		    Map<Object, Boolean> seen = new ConcurrentHashMap<>(); 
		    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null; 
		}
	
	public List<Produto> operacoesTerminaisStream(){
		List<Produto> list = repositorio.findAllProduto();
		
		list.stream().forEachOrdered((p) -> p.setPreco(p.getPreco() + 100));
		
		/*Stream.of("AAA", "BBB", "CCC").parallel().forEach(s -> System.out.println("Saida: " + s));
		Stream.of("AAA", "BBB", "CCC").parallel().forEachOrdered(s -> System.out.println("Saida: " + s));*/
		
		Long count = list.stream().count();
		System.out.println(count);
		
		Optional<Produto> findFirst = list.stream().findFirst();
		System.out.println(findFirst.toString());
		
		//boolean teste =  list.stream().allMatch((p) -> p.getPreco() < 300);
		//System.out.println(teste);
		
		Optional<Produto> testeMin = list.stream().min((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));
		Optional<Produto> testeMax = list.stream().max((p1, p2) -> p1.getPreco().compareTo(p2.getPreco()));
		System.out.println(testeMin);
		System.out.println(testeMax);
		
		return list;
	}
}
