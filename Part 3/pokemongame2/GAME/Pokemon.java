package com.example.pokemongame2.GAME;

import java.util.ArrayList;
/**
 * Represents a Pokemon card
 * 
 * Each Pokemon has hp, damage, a type, a stage, 
 * and up to (stage) energies attached.
 * 
 * Pokemon can also evolve, but each type (subclass)
 * must implement it differently.
 * 
 * @author Jason Chandler
 *
 */
public class Pokemon extends Card{

	// Pokemon have hp, damage, a type, and a stage
	private int hp;
	private int damage;
	private Type type;
	private int stage;
	
	// Pokemon have energies attached to them
	// to check if they can attack
	
	private ArrayList<Energy> energies;
	
	
	public Pokemon() {

		energies = new ArrayList<Energy>();
		
	}
	
	
	/**
	 * To be implemented by each subclass
	 * 
	 * 
	 */
	public Pokemon evolve() {
		
		return new Pokemon();
		
	}

	public int getStage() {
		
		return stage;
		
	}
	
	public void setStage(int newStage) {
		
		stage = newStage;
		
	}
	
	
	
	public ArrayList<Energy> getEnergies() {
		
		return energies;
		
	}
	
	public void addEnergy(Energy newEnergy) {
		
		energies.add(newEnergy);
		
	}
	
	public int getHp() {
		
		return hp;
		
	}
	
	public void setHp(int health) {
		
		hp = health;
		
	}
	
	public int getDamage() {
		
		return damage;
		
	}
	
	public void setDamage(int strength) {
		
		damage = strength;
		
		
	}
	
	public void setType(Type t) {
		
		type = t;
		
	}
	
	public Type getType() {
		
		return type;
		
		
	}
	
	/**
	 * Damages an enemy Pokemon
	 * 
	 * @param enemy The Pokemon to damage
	 */
	public void damage(Pokemon enemy) {
		
		int newHp = (enemy.getHp() - this.getDamage());
		
		enemy.setHp(newHp);
		
	}
	
	/**
	 * Heals the Pokemon
	 * 
	 * @param health The health to add
	 */
	public void heal(int health) {
		
		int newHp = (getHp() + health);
		
		setHp(newHp);
		
	}
	
	
	
	
}
