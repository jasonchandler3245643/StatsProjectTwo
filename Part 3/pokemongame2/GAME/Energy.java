package com.example.pokemongame2.GAME;

/**
 * Represents an Energy Pokemon TCG card.
 * 
 * @author Jason Chandler
 *
 */
public class Energy extends Card {

	// The type of energy
	private Type type;
	
	/**
	 * Constructs an Energy Card of a specific type
	 * 
	 * @param t The type of energy
	 */
	public Energy(Type t) {
		
		type = t;
		setName(t.name());
		
		
	}
	
	/**
	 * Prints the type of Energy card
	 * 
	 */
	public void printType() {
		
		
		System.out.println(type.toString() + " " + "Energy");
		
	}
	
	/**
	 * Gets the type of Energy Card
	 * 
	 * @return The type of energy
	 */
	public Type getType() {
		
		return type;
		
	}
	
	
}
