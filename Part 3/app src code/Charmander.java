package com.example.myfirsthelloworld;

/**
 * Represents a Charmander Pokemon card,
 * 
 * 
 * @author Jason Chandler
 *
 */
public class Charmander extends Pokemon {

	/**
	 * Constructs a Charmander with its stats
	 * 
	 */
	public Charmander() {
		
		setHp(40);
		setDamage(40);
		setType(Type.Fire);
		setName("Charmander");
		setStage(1);
	}
	
	/**
	 * Charmander evolves into Charmeleon
	 * 
	 */
	public Charmeleon evolve() {
		
		return new Charmeleon();
		
	}
}
