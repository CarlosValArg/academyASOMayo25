package com.curso.pizzas;

import com.curso.factory.PizzaIngredientFactory;

public class CheesePizza extends Pizza {
	
	PizzaIngredientFactory ingredientFactory;
	static int counter;
 
	public CheesePizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
		++counter;
	}
 
	@Override
	public void prepare() {
		System.out.println("Preparing " + name + ", Counter: "+counter);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
	}
}
