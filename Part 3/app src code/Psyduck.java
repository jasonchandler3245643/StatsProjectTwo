package com.example.myfirsthelloworld;

/**
 * Represents a Psyduck Pokemon Card
 * 
 * @author Jason Chandler
 *
 */
public class Psyduck extends Pokemon {

	/**
	 * Constructs a Psyduck with its stats
	 * 
	 */
	public Psyduck() {
		
		setHp(30);
		setDamage(20);
		setType(Type.Water);
		setName("Psyduck");
		setStage(1);
		
	}
	
	/**
	 * Psyduck evolves into Golduck
	 * 
	 */
	public Golduck evolve() {
		
		return new Golduck();
		
		
	}
}
