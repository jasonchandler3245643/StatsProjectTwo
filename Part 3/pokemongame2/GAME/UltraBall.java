package com.example.pokemongame2.GAME;

/**
 * Represents an Ultra Ball Trainer Card
 * 
 * Description: Discard 2 RANDOM cards from your hand.
 * If you do, search your deck for a Pokemon, 
 * reveal it, and put it into your hand
 * 
 * @author jchan
 *
 */
public class UltraBall extends Trainer { 

	
	/**
	 * Constructs an Ultra Ball
	 * 
	 */
	public UltraBall() {
		
		setName("Ultra Ball");
		setTrainerType(Trainer.TrainerType.item);
	}
	
	/**
	 * Overrides to perform its own action
	 * 
	 */
	public void perform(Player p) {
		
		// remove the first 2 in hand
		for (int i = 0; i < 2; i++) {
			
			if (p.getHand().size() > 0) {
				
				p.removeFromHand(p.getHand().get(0));
				
			}
			
			
		}
		
		
		// add the first pokemon to hand
		for (int i = 0; i < p.getDeck().size(); i++) {
			
			if (p.getDeck().isEmpty()) {
				
				break;
				
			}
			
			
			
			if (p.getDeck().get(i) instanceof Pokemon) {
					
				p.getHand().add(p.getDeck().get(i));
				p.getDeck().remove(i);
				return;
					
			}
				
		}
			
			
	}
		
	
	
	


}
