package com.curso.v0;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal7 {

	public static void main(String[] args) {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();

		Set<Map.Entry<String,List<String>>> entrySet = 
				  Stream.generate(() -> "") //CREAR STREAM //Stream<String>
						.limit(10) //INTERMEDIA //Stream<String>
						.filter(notEmpty) //INTERMEDIA //Stream<String>
						.collect(Collectors.groupingBy(k -> k)) //TERMINA STREAM //Map<String,List<String>> map
						.entrySet(); //Set<Map.Entry<String,List<String>>>
		
		System.out.println(entrySet);
		
				
	}
	
	

}
