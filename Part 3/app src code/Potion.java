package com.example.myfirsthelloworld;

/**
 * Represents a Potion Trainer card
 * 
 * Description: Heal 30 damage
 * 
 * @author Jason Chandler
 *
 */
public class Potion extends Trainer {
	
	/**
	 * Constructs a Potion Trainer card
	 * 
	 */
	public Potion() {
		
		setName("Potion");
		setTrainerType(Trainer.TrainerType.item);
		
	}
	
	/**
	 * Overrides to perform its own action
	 * 
	 */
	public void perform(Player p) {
		
		p.getActivePokemon().setHp(p.getActivePokemon().getHp() + 30);
		System.out.println(p.getActivePokemon().getName() + " healed for " + p.getActivePokemon().getHp());
		
	}
	
	

}
