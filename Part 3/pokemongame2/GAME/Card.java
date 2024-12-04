package com.example.pokemongame2.GAME;

/**
 * Represents a general Pokemon TCG Card 
 * Every Card (Pokemon, Energy, and Trainer) have a name
 * 
 * @author Jason Chandler
 *
 */
public class Card {

	// name of card
	private String name;
	
	/**
	 * Sets the Card's name
	 * 
	 * @param nombre The new name 
	 */
	public void setName(String nombre) {
		
		name = nombre;
		
	}
	
	/**
	 * Gets the Card's name
	 * 
	 * @return The Card's name
	 */
	public String getName() {
		
		return name;
		
	}
	
}
