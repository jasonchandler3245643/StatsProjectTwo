package com.example.pokemongame2.GAME;

/**
 * Represents a Nemona Trainer Card
 * 
 * Description: Draw 3 cards
 * 
 * @author Jason Chandler
 *
 */
public class Nemona extends Trainer{

	/**
	 * Constructs a Nemona Card
	 * 
	 */
	public Nemona() {
		
		setName("Nemona");
		setTrainerType(Trainer.TrainerType.supporter);
	}
	
	/**
	 * Overrides to perform its own action
	 *
	 */
	public void perform(Player p) {
		
		for (int i = 0; i < 3; i++) {
			
			if (p.getDeck().size() > 0) {
				
				p.draw();
				
			}
			
		}
		
		
	}
}
