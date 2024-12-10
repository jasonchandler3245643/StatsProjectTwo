package com.example.myfirsthelloworld;

/**
 * Represents a Rare Candy Trainer Card
 * Evolves the Player's active Pokemon
 * 
 * 
 * @author Jason Chandler
 *
 */
public class RareCandy extends Trainer { 
	
	/**
	 * Constructs a Rare Candy
	 * 
	 */
	public RareCandy() {
		
		setName("Rare Candy");
		setTrainerType(Trainer.TrainerType.item);
		
	}
	
	/**
	 * Overrides to perform its own action
	 * 
	 */
	public void perform(Player p) {
		
		
		
		Pokemon newPoke = p.getActivePokemon().evolve();
		p.setActivePokemon(newPoke);
		p.removeFromHand(newPoke);
	}
	
}
