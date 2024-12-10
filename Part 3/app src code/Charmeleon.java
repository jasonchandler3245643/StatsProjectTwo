package com.example.myfirsthelloworld;

/**
 * Represents a Charmeleon Pokemon card
 * 
 * @author Jason Chandler
 *
 */
public class Charmeleon extends Charmander {

	/**
	 * Constructs a Charmeleon with its stats
	 * 
	 * 
	 */
	public Charmeleon() {
		
		setHp(60);
		setDamage(50);
		setType(Type.Fire);
		setName("Charmeleon");
		setStage(2);
		
	}

	/**
	 * Charmeleon evolves into Charizard
	 * 
	 */
	public Charizard evolve() {
		
		return new Charizard();
		
	}
}
