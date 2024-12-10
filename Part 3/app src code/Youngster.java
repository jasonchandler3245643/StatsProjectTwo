package com.example.myfirsthelloworld;

/**
 * Represents a Youngster Trainer Card
 * 
 * @author Jason Chandler
 *
 */
public class Youngster extends Trainer {
	
	/**
	 * Constructs a Youngster Trainer Card
	 * 
	 */
	public Youngster() {
		
		setName("Youngster");
		setTrainerType(Trainer.TrainerType.supporter);
		
	}
	
	/**
	 * Overrides to perform its own action
	 * 
	 */
	public void perform(Player p) {
		
		// add all cards in hand to deck
		// then remove them from the hand
		while (!p.getHand().isEmpty()) {
			
			
			p.getDeck().add(p.getHand().get(0));
			p.removeFromHand(p.getHand().get(0));
			
			
		}
		
		// now draw 5 cards
		for (int i = 0; i < 5; i++) {
			
			int n = gen.nextInt(p.getDeck().size());
			Card newCard = p.getDeck().get(n);
			
			p.getHand().add(newCard);
			p.getDeck().remove(newCard);
			
		}
		
		
	}
	

}
