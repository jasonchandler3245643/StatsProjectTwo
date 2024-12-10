package com.example.myfirsthelloworld;

import java.util.Random;
/**
 * Represents a Pokemon TCG Trainer Card
 * 
 * Each Trainer has a type, either supporter or item.
 * Each Trainer can also perform an action, 
 * but each Trainer card does something different
 * and must implement the method differently
 *
 */
public class Trainer extends Card{

	Random gen = new Random();
	
	TrainerType trainerType;
	
	public Trainer() {
		
		setName("Trainer");
		
	}
	
	// trainer cards perform an action
	public void perform(Player p) {
		
		
		
	}
	
	public TrainerType getTrainerType() {
		
		return trainerType;
		
	}
	
	public void setTrainerType(TrainerType type) {
		
		trainerType = type;
		
	}
	
	
	/**
	 * Enumeration to hold the Trainer's type
	 *
	 */
	public enum TrainerType {
		
		item, supporter
		
		
	}
	
	
}
