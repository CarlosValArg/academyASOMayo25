package com.curso.factory;

import com.curso.ingredientes.BlackOlives;
import com.curso.ingredientes.Eggplant;
import com.curso.ingredientes.FrozenClams;
import com.curso.ingredientes.MozzarellaCheese;
import com.curso.ingredientes.PlumTomatoSauce;
import com.curso.ingredientes.SlicedPepperoni;
import com.curso.ingredientes.Spinach;
import com.curso.ingredientes.ThickCrustDough;
import com.curso.ingredientes.abs.Cheese;
import com.curso.ingredientes.abs.Clams;
import com.curso.ingredientes.abs.Dough;
import com.curso.ingredientes.abs.Pepperoni;
import com.curso.ingredientes.abs.Sauce;
import com.curso.ingredientes.abs.Veggies;

public class ChicagoPizzaIngredientFactory 
	implements PizzaIngredientFactory 
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(), 
		                      new Spinach(), 
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
