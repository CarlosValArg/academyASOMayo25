package com.curso.v0;

import java.util.stream.Stream;

public class Principal2 {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.generate(() -> ".");
		
		//INFINITO
		stream.forEach(x -> System.out.println(x));
		
	}

}
