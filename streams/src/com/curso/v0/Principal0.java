package com.curso.v0;

import java.util.function.Predicate;

public class Principal0 {

	public static void main(String[] args) {

		Predicate<String> vacio = z -> z.isEmpty();
		Predicate<String> empty = String::isEmpty;
		
		boolean r = empty.test("javascript");
		System.out.println(r);
		
		
	}

}
