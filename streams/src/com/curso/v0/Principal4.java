package com.curso.v0;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class Principal4 {

	public static void main(String[] args) {
		
		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();

		Stream<String> stream = Stream.generate(() -> "")
								.limit(10)
								.filter(notEmpty);
		
		stream.forEach(x -> System.out.println(x));
		//System.out.println("StreamCount: "+stream.count()); //0
		
	}

}
