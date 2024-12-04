package com.example.pokemongame2.GAME;

/**
 * Represents a Professor's Research Trainer Card.
 * 
 * Description: Discard your hand and draw 7 cards.
 * 
 * @author Jason Chandler
 *
 */
public class ProfessorsResearch extends Trainer {  
	
	
	/**
	 * Constructs a Professor's Research
	 * 
	 */
	public ProfessorsResearch() {
		
		setName("Professor's Research");
		setTrainerType(Trainer.TrainerType.supporter);
	}
	
	/**
	 * Overrides to perform its own action
	 * 
	 */
	public void perform(Player p) {
		
		p.getHand().clear();
		
		int n;
		// draw 7 cards
		
		for (int i = 0; i < 7; i++){
			
			
		
			if (p.getDeck().size()>0){	
				n = gen.nextInt(p.getDeck().size());
				p.getHand().add(p.getDeck().get(n));
				p.getDeck().remove(n);				
			}
			
		}
		
		
	}

}
