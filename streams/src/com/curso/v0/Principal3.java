package com.curso.v0;

import java.util.stream.Stream;

public class Principal3 {

	public static void main(String[] args) {

		Stream<String> stream = Stream.generate(() -> ".")
								.limit(10);
		
		stream.forEach(x -> System.out.println(x));
		
	}

}
