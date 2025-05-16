package com.curso.factory;

import com.curso.ingredientes.abs.Cheese;
import com.curso.ingredientes.abs.Clams;
import com.curso.ingredientes.abs.Dough;
import com.curso.ingredientes.abs.Pepperoni;
import com.curso.ingredientes.abs.Sauce;
import com.curso.ingredientes.abs.Veggies;

public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
