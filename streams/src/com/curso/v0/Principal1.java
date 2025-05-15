package com.curso.v0;

import java.util.function.Predicate;

public class Principal1 {

	public static void main(String[] args) {

		Predicate<String> empty = String::isEmpty;
		Predicate<String> notEmpty = empty.negate();
		
		boolean r = notEmpty.test("");
		System.out.println(r);
		
	}

}
