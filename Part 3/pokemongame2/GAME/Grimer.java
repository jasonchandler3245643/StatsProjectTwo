package com.example.pokemongame2.GAME;

/**
 * Represents a Grimer Pokemon card.
 * 
 * @author Jason Chandler
 *
 */
public class Grimer extends Pokemon {
	
	/**
	 * Constructs a Grimer with its stats
	 * 
	 */
	public Grimer() {
		
		setHp(70);
		setDamage(50);
		setType(Type.Dark);
		setName("Grimer");
		setStage(1);
		
	}
	
	/**
	 * Grimer evolves into Muk
	 * 
	 */
	public Muk evolve() {
		
		return new Muk();
		
	}
	
}
