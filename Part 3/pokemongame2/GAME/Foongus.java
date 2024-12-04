package com.example.pokemongame2.GAME;

/**
 * Represents a Foongus Pokemon Card
 * 
 * @author Jason Chandler
 *
 */
public class Foongus extends Pokemon{

	/**
	 * Constructs a Foongus with its stats
	 * 
	 */
	public Foongus() {
		
		setHp(50);
		setDamage(20);
		setType(Type.Grass);
		setName("Foongus");
		setStage(1);
	}
	
	/**
	 * Foongus evolves into Amoongus
	 * 
	 */
	public Amoonguss evolve() {
		
		return new Amoonguss();
		
	}
	
}
