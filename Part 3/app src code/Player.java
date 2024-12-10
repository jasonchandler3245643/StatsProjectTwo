package com.example.myfirsthelloworld;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;

/**
 * Represents a Player in a Pokemon Trading Card Game
 * 
 * @author Jason Chandler
 *
 */
public class Player {

	// players have a deck, playing hand, and prize hand 
	private ArrayList<Card> deck;
	private ArrayList<Card> hand;
	private ArrayList<Card> prizes;
	private ArrayList<Pokemon> bench;

	// players are either playing or not
	private Pokemon activePokemon;
	private String name;
	
	/**
	 * Constructs a Player, fills their deck, 
	 * and draws their hand and prizes
	 * 
	 */
	public Player() {
		
		// construct the ArrayLists
		deck = new ArrayList<Card>();
		hand = new ArrayList<Card>();
		prizes = new ArrayList<Card>();
		bench = new ArrayList<Pokemon>();

		// fill the deck
		fillDeck();
		
		// draw hand & prizes
		drawHand();
		drawPrizes();
		
	}
	
	public Pokemon getActivePokemon() {
		
		return activePokemon;
		
	}

	public void setActivePokemon(Pokemon p) {
		
		activePokemon = p;
		
	}
	
	public void setName(String word) {
		
		name = word;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
	
	public ArrayList<Card> getHand() {
		
		return hand;
		
	}
	
	public ArrayList<Card> getDeck() {
		
		return deck;
		
	}
	
	public ArrayList<Pokemon> getBench() {
		
		return bench;
		
	}

	public ArrayList<Card> getPrizes() {
		
		return prizes;
		
	}
	
	/**
	 * Fills the player's deck
	 * 
	 * @param numEachCard The number of each type of card in the deck
	 * 
	 */
	private void fillDeck() {
		
		
		for (int i = 0; i < 2; i++) {
			
			deck.add(new Charmander());
			deck.add(new Charmander());
			deck.add(new Charmander());
			deck.add(new Charmeleon());
			deck.add(new Charmeleon());
		}
		
		
		for (int i = 0; i < 2; i++) {
			
			deck.add(new Energy(Type.Fire));
			deck.add(new Energy(Type.Fire));
			deck.add(new Energy(Type.Fire));
			deck.add(new Energy(Type.Fire));
			deck.add(new Energy(Type.Ice));
			
		}
		
		for (int i = 0; i < 1; i++) {
			
			deck.add(new RareCandy());
			deck.add(new Youngster());
			deck.add(new ProfessorsResearch());
			deck.add(new Potion());
			deck.add(new Nemona());
			deck.add(new UltraBall());
		}
		
		
	}
	
	/**
	 * Draws the 7 cards from the player's deck to their hand
	 * 
	 */
	public void drawHand() {
		
		
		Random gen = new Random();
		
		for (int i = 0; i < 7; i++) {
			
			int n = gen.nextInt(deck.size());
			Card newCard = deck.get(n);
			
			hand.add(newCard);
			deck.remove(newCard);
			
		}
		
	}
	
	/**
	 * Draws 6 prize cards and removes them from the deck
	 * 
	 */
	private void drawPrizes() {
		
	
		
		Random gen = new Random();
		
		for (int i = 0; i < 6; i++) {
			
			Card newCard = deck.get(gen.nextInt(deck.size()));
			prizes.add(newCard);
			deck.remove(newCard);
		}
		
		
	}
	

	
	/**
	 * Checks if the Player has a Pokemon in their hand
	 * 
	 * @return true if the player has a Pokemon in their hand; false otherwise
	 */
	public boolean checkHandForPokemon() {
		
		boolean present = false;
		
		for (Card card : hand) {
			
			if (card instanceof Pokemon) {
				present = true;
				break;
			}
			
		}
		
		
		return present;
		
	}
	
	/**
	 * Adds a random Card from the deck, removes it,
	 * and adds it to the hand
	 * 
	 */
	public void draw() {
		
		Random gen = new Random();
		Card newCard = deck.get(gen.nextInt(deck.size()));
		
		hand.add(newCard);
		deck.remove(newCard);
		
	}
	
	/**
	 * Adds a prize card to the hand, 
	 * removes it from the prizes
	 * 
	 */
	public void addPrizeCardToHand() {
		
		Random gen = new Random();
		Card newPrize = prizes.get(gen.nextInt(prizes.size()));
		
		hand.add(newPrize);
		prizes.remove(newPrize);
		
	}
	
	/**
	 * Prints out the names of the Pokemon in the hand
	 * 
	 */
	public void displayPokemon() {
		
		System.out.print("Pokemon in your hand: ");
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Pokemon) 
				System.out.print(singleCard.getName() + ", ");
			
		}
		
		System.out.println("");
		
		
	}
	
	/**
	 * Prints out the names of the Energy Cards in the hand
	 * 
	 */
	public void displayEnergy() {
		
		System.out.print("Energy in your hand: ");
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Energy)
				System.out.print(singleCard.getName() + ", ");
			
		}
		
		System.out.println("");
		
	}

	
	/**
	 * Prints out the names of the Trainers in the hand
	 * 
	 */
	public void displayTrainer() {
	
		System.out.print("Trainer in your hand: ");
		
		for (Card singleCard : hand) {
		
			if (singleCard instanceof Trainer)
				System.out.print(singleCard.getName() + ", ");
		
		}
		
		System.out.println("");
	
	}
	
	/**
	 * Prints out the names of the Pokemon on the bench
	 * 
	 */
	public void displayBench() {
		
		System.out.print("Your bench: ");
		
		for (Card singleCard : bench) {
			
			System.out.print(singleCard.getName() + ", ");
			
		}
		
		System.out.println("");
	}
	
	
	/**
	 * Prints out the names of the Cards in the hand
	 * 
	 */
	public void displayHand() {
		
		System.out.print("Your hand: ");
		
		for (Card singleCard : hand) {
			
			if (singleCard != null)
				System.out.print(singleCard.getName() + ", ");
		
		}
		
		System.out.println("");
	}
	
	/**
	 * Prints out the player's active Pokemon
	 * 
	 */
	public void displayActive() {
		System.out.println("Your active Pokemon: " + activePokemon.getName());
		
	}

	/**
	 * Counts the number of Pokemon in hand
	 * 
	 * @return The number of Pokemon in the player's hand
	 */
	public int pokemonInHand() {
		
		int pokemonInHand = 0;
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Pokemon) 
				pokemonInHand++;

		}
		
		return pokemonInHand;
		
	}
	
	/**
	 * Adds the Energy Cards in the hand to an ArrayList and returns it
	 * 	 
	 * @return The Energy cards in the Player's hand
	 */
	public ArrayList<Energy> getEnergyInHand() {
		
		ArrayList<Energy> energies = new ArrayList<Energy>();
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Energy)
				energies.add((Energy) singleCard);
			
		}
		
		return energies;
		
	}
	
	/**
	 * Adds the Trainer Cards in the hand to an ArrayList and returns it
	 * 	 
	 * @return The Trainer cards in the Player's hand
	 */
	public ArrayList<Trainer> getTrainerInHand() {
		
		ArrayList<Trainer> trainers = new ArrayList<Trainer>();
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Trainer)
				trainers.add((Trainer) singleCard);
			
		}
		
		return trainers;
		
	}
	
	/**
	 * Adds the Pokemon Cards in the hand to an ArrayList and returns it
	 * 	 
	 * @return The Pokemon cards in the Player's hand
	 */
	public ArrayList<Pokemon> getPokemonInHand() {
		
		ArrayList<Pokemon> pokemonInHand = new ArrayList<Pokemon>();
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Pokemon) {
				
				pokemonInHand.add((Pokemon) singleCard);
				
			}
			
		}
		
		return pokemonInHand;
		
	}
	
	/**
	 * Removes a Card from the player's hand using an iterator
	 * Sometimes, using .getHand().remove() causes an error
	 * 
	 */
	public void removeFromHand(Card toRemove) {
		
		Iterator<Card> iterator = hand.iterator();
		
		while (iterator.hasNext()) {
			
			Card singleCard = iterator.next();
			
			
			if (singleCard != null)
				if (singleCard.equals(toRemove)) {
					
					iterator.remove();
				
				
				}
			
		}

	}
	
	
	/**
	 * Adds a Pokemon to the player's bench
	 * 
	 * @param benched The Pokemon to add to the bench
	 */
	public void addToBench(Pokemon benched) {
		
		if (bench.size() == 6) {
			return;
		}	
		
		else
			bench.add(benched);
	}
	
	/**
	 * Redraws the player's hand
	 * 
	 */
	public void redrawHand() {
		
		for (Card singleCard : hand) {
			
			deck.add(singleCard);
			
		}
		
		hand.clear();
		
		drawHand();
		
	}
	
	/**
	 * Removes the player's active Pokemon
	 * 
	 */
	public void removeActive() {
		
		activePokemon = null;
		
		
	}
	
	/**
	 * Checks if the Pokemon's evolution is in the player's hand
	 * 
	 * @param p The Pokemon to be evolved
	 * @return true if the Pokemon's evolution is in the player's hand
	 */
	public boolean hasEvolutionInHand(Pokemon p) {
		
		boolean evolutionPresent = false;
		
		for (Card singleCard : hand) {
			
			if (singleCard instanceof Pokemon) {

				if (((Pokemon) singleCard).getType() == p.getType() 
						&& ((Pokemon) singleCard).getStage() - 1 == p.getStage()) {
					
					evolutionPresent = true;
					
				}
				
			}
			
		}
		
		return evolutionPresent;
		
	}
	
	/**
	 * Checks if the Pokemon's evolution is in the player's BENCH
	 * 
	 * @param p The Pokemon to be evolved
	 * @return true if the Pokemon's evolution is in the player's bench
	 */
	public boolean hasEvolutionInBench(Pokemon p) {
		
		boolean evolutionPresent = false;
		
		for (Card singleCard : bench) {
			
			if (singleCard instanceof Pokemon) {

				if (((Pokemon) singleCard).getType() == p.getType() 
						&& ((Pokemon) singleCard).getStage() - 1 == p.getStage()) {
					
					evolutionPresent = true;
					
				}
				
			}
			
		}
		
		return evolutionPresent;
		
	}
}