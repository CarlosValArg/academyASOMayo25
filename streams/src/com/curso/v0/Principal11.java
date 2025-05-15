package com.curso.v0;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal11 {

	public static void main(String[] args) {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();

		Map<Boolean,List<String>> map = 
				  Stream.generate(() -> "") //CREAR STREAM //Stream<String>
						.limit(10) //INTERMEDIA //Stream<String>
						.filter(notEmpty) //INTERMEDIA //Stream<String>
						.collect(Collectors.groupingBy(k -> k)) //TERMINA STREAM //Map<String,List<String>> map
						.entrySet() //Set<Map.Entry<String,List<String>>>
						.stream() //Stream<Map.Entry<String,List<String>>>
						.map(Entry::getValue) //Stream<List<String>>
						.flatMap(Collection::stream)//Stream<String>
						.collect(Collectors.partitioningBy(notEmpty)); //Map<Boolean,List<String>>
		
		System.out.println(map); //{false=[], true=[]}
				
		ejecuta2();
		
				
	}
	
	static void ejecuta2() {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();
		
		List<String> listaNombres = List.of("Tercio","Patrobas","Tercio","Epenet","Tercio","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		
		Map<Boolean,List<String>> map = streamNombres
								.collect(Collectors.groupingBy(k -> k.length()))
								.entrySet()
								.stream()
								.map(eleSet -> eleSet.getValue())
								.flatMap(x -> x.stream())
								.collect(Collectors.partitioningBy(notEmpty));
		
		System.out.println(map);
				
	}
	
	

}
