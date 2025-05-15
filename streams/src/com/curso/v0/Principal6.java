package com.curso.v0;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal6 {

	public static void main(String[] args) {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();

		Map<String,List<String>> map = Stream.generate(() -> "") //CREAR //Stream<String>
						.limit(10) //INTERMEDIA //Stream<String>
						.filter(notEmpty) //INTERMEDIA //Stream<String>
						.collect(Collectors.groupingBy(k -> k)); //TERMINA //Map<String,List<String>> map
		
		//System.out.println("Map<String,List<String>>: "+map);

		Set<Map.Entry<String,List<String>>> entrySet = map.entrySet();
		
		//System.out.println("Set<Map.Entry<String,List<String>>>: "+entrySet);
		
//		ejecuta1();
		ejecuta2();
//		ejecuta3();
//		ejecuta4();
				
	}
	
	static void ejecuta1() {
		List<String> listaNombres = List.of("Tercio","Patrobas","Tercio","Epeneto","Tercio","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		Map<String,List<String>> map = 
									streamNombres
									.collect(Collectors.groupingBy(k -> k));
		
		System.out.println(map);
		
	}
	
	static void ejecuta2() {
		List<String> listaNombres = List.of("Tercio","Patrobas","Tercio","Epenet","Tercio","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		Map<Integer,List<String>> map = 
									streamNombres
									.collect(Collectors.groupingBy(k -> k.length()));
				
		System.out.println("Map<String,List<String>>: "+map);

		Set<Map.Entry<Integer,List<String>>> entrySet = map.entrySet();
		
		System.out.println("Set<Map.Entry<String,List<String>>>: "+entrySet);
		
		System.out.println("*************");
		
		entrySet.forEach(x -> System.out.println(x.getKey()+" : "+x.getValue()));
		
	}
	
	static void ejecuta3() {
		List<String> listaNombres = List.of("Tercios","Patrobas","Tercio","Epenet","Tercios","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		Map<Boolean,List<String>> map = 
									streamNombres
									.collect(Collectors.groupingBy(k -> k.endsWith("s")));
		
		System.out.println(map);
		
	}
	
	static void ejecuta4() {
		List<String> listaNombres = List.of("Tercios","Patrobas","Ercio","Epenet","Ercios","Andronic");
		Stream<String> streamNombres = listaNombres.stream();
		Map<Character,List<String>> map = 
									streamNombres
									.collect(Collectors.groupingBy(k -> k.charAt(0)));
		
		System.out.println(map);
		
	}

}
