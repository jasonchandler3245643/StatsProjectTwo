package com.example.pokemongame2.GAME;

/**
 * Represents a Charizard Pokemon card.
 * 
 * 
 * @author Jason Chandler
 *
 */
public class Charizard extends Charmeleon {


	/**
	 * Constructs a new Charizard with its stats
	 * 
	 */
	public Charizard() {
		
		setHp(80);
		setDamage(60);
		setType(Type.Fire);
		setName("Charizard");
		setStage(3);
		
	}
	
}
