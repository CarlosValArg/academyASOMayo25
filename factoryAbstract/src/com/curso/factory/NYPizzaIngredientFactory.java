package com.curso.factory;

import com.curso.ingredientes.FreshClams;
import com.curso.ingredientes.Garlic;
import com.curso.ingredientes.MarinaraSauce;
import com.curso.ingredientes.Mushroom;
import com.curso.ingredientes.Onion;
import com.curso.ingredientes.RedPepper;
import com.curso.ingredientes.ReggianoCheese;
import com.curso.ingredientes.SlicedPepperoni;
import com.curso.ingredientes.ThinCrustDough;
import com.curso.ingredientes.abs.Cheese;
import com.curso.ingredientes.abs.Clams;
import com.curso.ingredientes.abs.Dough;
import com.curso.ingredientes.abs.Pepperoni;
import com.curso.ingredientes.abs.Sauce;
import com.curso.ingredientes.abs.Veggies;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
