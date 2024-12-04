package com.example.pokemongame2.GAME;

/**
 * Represents a Clefairy Pokemon Card.
 * 
 * @author Jason Chandler
 *
 */
public class Clefairy extends Pokemon{

	/**
	 * Constructs a Clefairy with its stats
	 * 
	 */
	public Clefairy() {
		
		setHp(65);
		setDamage(20);
		setType(Type.Fairy);
		setName("Clefairy");
		setStage(1);
		
		
	}
	
	/**
	 * Clefairy evolves into Clefable
	 * 
	 */
	public Clefable evolve() {
		
		return new Clefable();
		
	}
	
	
}
