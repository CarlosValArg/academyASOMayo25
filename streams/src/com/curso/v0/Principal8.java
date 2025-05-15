package com.curso.v0;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal8 {

	public static void main(String[] args) {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();

		Stream<Map.Entry<String,List<String>>> stream = 
				  Stream.generate(() -> "") //CREAR STREAM //Stream<String>
						.limit(10) //INTERMEDIA //Stream<String>
						.filter(notEmpty) //INTERMEDIA //Stream<String>
						.collect(Collectors.groupingBy(k -> k)) //TERMINA STREAM //Map<String,List<String>> map
						.entrySet() //Set<Map.Entry<String,List<String>>>
						.stream(); //Stream<Map.Entry<String,List<String>>>
		
		stream.forEach(System.out::println); //NADA
		
		ejecuta2();
		
				
	}
	
	static void ejecuta2() {
		List<String> listaNombres = List.of("Tercio","Patrobas","Tercio","Epenet","Tercio","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		Stream<Map.Entry<Integer,List<String>>> stream = 
									streamNombres
									.collect(Collectors.groupingBy(k -> k.length()))
									.entrySet()
									.stream();
				
		stream.forEach(System.out::println);
	}
	
	

}
