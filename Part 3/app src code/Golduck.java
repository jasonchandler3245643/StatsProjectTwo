package com.example.myfirsthelloworld;

/**
 * Represents a Golduck Pokemon card.
 * 
 * @author Jason Chandler
 *
 */
public class Golduck extends Psyduck {

	/**
	 * Constructs a Golduck with its stats
	 * 
	 */
	public Golduck() {
		
		setHp(60);
		setDamage(40);
		setType(Type.Water);
		setName("Golduck");
		setStage(2);
		
	}
	
}
