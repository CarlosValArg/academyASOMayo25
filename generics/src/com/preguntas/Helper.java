package com.preguntas;

import java.io.FileNotFoundException;

public class Helper {
	
	public static <U extends Exception> 
						void printException(U u) {
		System.out.println(u.getMessage());
	}

	public static void main(String[] args) {
		
		//printException("hola");
		printException(new Exception());
		printException(new Exception("B"));
		printException(new Exception("C"));
		printException(new FileNotFoundException("A"));
		//printException(new Throwable("E"));
		printException(new NullPointerException("D"));
		
		Helper.<Exception>printException(new Exception());
		Helper.<Exception>printException(new Exception("B"));
		//Helper.<Throwable>printException(new Exception("C"));
		Helper.<FileNotFoundException>printException(new FileNotFoundException("A"));
		Helper.<NullPointerException>printException(new NullPointerException("D"));


		
	}

}
