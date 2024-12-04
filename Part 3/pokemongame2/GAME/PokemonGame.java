package com.example.pokemongame2.GAME;

import android.content.Context;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

/**
 * A Pokemon Card Game
 * 
 * A game has two Players, a boolean representing the 
 * game status, and a winner when the game is over
 * 
 * 
 * @author Jason Chandler
 *
 */
public class PokemonGame {

	Scanner scan = new Scanner (System.in);
	Random gen = new Random();

	private Player user;
	private Player opponent;
	
	private boolean gamePlaying;
	
	private Player winner;
	private boolean supportCardUsed;
	private Context context;

	/**
	 * Constructs a new Pokemon Game
	 * 
	 */
	public PokemonGame() {
		
		user = new Player();
		opponent = new Player();
		gamePlaying = true;
		
	}
	
	/**
	 * Ensures that each player has a Pokemon in opening hand
	 * 
	 */
	public void checkHands() {
		
		int count = 0;
		
		while (!user.checkHandForPokemon() || !opponent.checkHandForPokemon()) {
			
			if (!user.checkHandForPokemon()) {
				
					user.redrawHand();
					count++;
					
					if (count > 0) {
						
						opponent.draw();
						
					}
			}
			
			if (!opponent.checkHandForPokemon()) {
				
				
				
					opponent.redrawHand();
					
					if (count > 0) {
						
						user.draw();
						
					}
				
			}
			
		}
		
	}
	


	/**
	 * Runs the game 
	 * 
	 */
	public void runGame() {
		
		
		checkHands();

		makePokemonActive();
		
		// let the user go first
		
	
		// while the game is active,
		// alternate between user and computer rounds
		while (gamePlaying) {
			
			Toast.makeText(context, "Your turn! ", Toast.LENGTH_SHORT).show();
			user.draw();
			presentTurnOptions();
			gamePlaying = checkGameStatus();
			
			System.out.println("Computer's turn!");
			opponent.draw();
			
			playComputerTurn();
			gamePlaying = checkGameStatus();
			
			//swapActivePlayer();
			
		}
		
		if (winner == user) {
			
			System.out.println("Congratulations! You won!");
			
		}
		
		else 
			System.out.println("The computer won.");
		

	}
	
	
	/**
	 * Loops through and displays the user's options each turn
	 * 
	 * Entering initially allows the user to select 1-6 corresponding actions
	 * Entering anything else ends the current turn
	 * 
	 */
	private void presentTurnOptions() {
			
		int input;
		
		while (true) {
			
			if (user.getActivePokemon() != null)
				user.displayActive();
			
			user.displayHand();
			user.displayBench();
			System.out.println("");
			
			System.out.println("Swap active, add to bench, evolve a pokemon, attach an energy, attack, or use a trainer card?" );
			System.out.print("Enter 1, 2, 3, 4, 5, or 6. Anything else to end turn.");
			
			input = scan.nextInt();
		
			System.out.println("");
			
			switch (input) {
					
				case 1: {
					
					letSwapActive();
					break;
				}
					
				case 2: {
							
					letAddToBench();
					break;
				}
				
				case 3: {
					
					letEvolvePokemon();
					break;
				}
				
				
				case 4: {
					
					letAddEnergyToPokemon();
					break;
				}
				
				case 5: {
					
					letAttack();
					break;
				}
				
				case 6: {
					
					letUseTrainer();
					break;
				}
				
				default: {
					
					return;
					
				}
				
			}
			
			
					
			}
				
				
		}

	
	
	/**
	 * Allows the player to evolve one of their Pokemon
	 * 
	 */
	private void letEvolvePokemon() {
		
		user.displayActive();
		
			if (user.hasEvolutionInHand(user.getActivePokemon())) {
				
				user.displayPokemon();
				System.out.print("Evolve to which stage two Pokemon? Enter the number: ");
				int input = scan.nextInt();
				
				Pokemon newActive = user.getPokemonInHand().get(input - 1);
				
				user.setActivePokemon(newActive);
				
		
				
				user.getHand().remove(newActive);
				
			
			
			
		}
		
		
		
		System.out.println("");
		
	}
	
	/**
	 * Allows the user to use a trainer card
	 * 
	 */
	private void letUseTrainer() {
		
		user.displayTrainer();
		  
		System.out.print("Pick a number corresponding to Trainer card: ");
		int input = scan.nextInt();
		
		Trainer selectedTrainer = user.getTrainerInHand().get(input - 1);
		
		if (supportCardUsed && selectedTrainer.getTrainerType() == Trainer.TrainerType.supporter) { 
			
			System.out.println("You already used a supporter\n");
			return;
			
		}
		
		selectedTrainer.perform(user);
		user.removeFromHand(selectedTrainer);
		
		if (selectedTrainer.getTrainerType().equals(Trainer.TrainerType.supporter))
			supportCardUsed = true;
		
		System.out.println("");
		
	}
	
	/**
	 * Allows the user's active Pokemon to attack the opponent's active
	 * 
	 */
	private void letAttack() {
		
		if (checkToAttack(user.getActivePokemon()) == false) {
			
			System.out.println("Add an energy first.\n");
			return;
			
		}
		
		System.out.println("Your Pokemon did " + user.getActivePokemon().getDamage() + " damage.");
		
		user.getActivePokemon().damage(opponent.getActivePokemon());
		user.getActivePokemon().getEnergies().remove(0);
		
		int opponentHp = opponent.getActivePokemon().getHp();
		
		System.out.println("The opponent's Pokemon now has " + opponentHp + " health");
		
		if (opponentHp <= 0) {
			
			System.out.println("The opponnent's active has died");
			opponent.removeActive();
			user.addPrizeCardToHand();
		}
		
		System.out.println("");
		
	}
	
	/**
	 *  Allows the user to add an energy to their active Pokemon
	 * 
	 */
	private void letAddEnergyToPokemon() {
		
		user.displayActive();
		user.displayEnergy();
		System.out.print("Pick a number corresponding to Energy: ");
		
		int input = scan.nextInt();
		
		if (user.getEnergyInHand().get(input - 1).getType() == user.getActivePokemon().getType()) {
			
			user.getActivePokemon().getEnergies().add(user.getEnergyInHand().get(input - 1));
			user.getHand().remove(user.getEnergyInHand().get(input - 1));
			
			System.out.println(user.getActivePokemon().getName() + " has " + user.getActivePokemon().getEnergies().size() + " energies\n");
			return;
			
		}

		System.out.print("");

	}
	
	/**
	 * Allows the user to add a Pokemon from their hand to their bench
	 * 
	 */
	private void letAddToBench() {
		
		user.displayPokemon();
		System.out.print("Pick a number corresponding to Pokemon: ");
		
		int input = scan.nextInt();
		
		user.getBench().add(user.getPokemonInHand().get(input - 1));
		user.getHand().remove(user.getPokemonInHand().get(input - 1));
		user.displayBench();
		
		System.out.println("");
	}
	
	/**
	 * Allows the user to swap their active Pokemon
	 * 
	 */
	private void letSwapActive() {
		
		Pokemon oldActive = user.getActivePokemon();
		
		System.out.print("Swap from bench or hand? Enter 1 or 2: ");
		int input = scan.nextInt();
		
		if (input == 1) {
			
			user.displayBench();
			System.out.print("Select a Pokemon by entering its number: ");
			input = scan.nextInt();
			
			user.setActivePokemon(user.getBench().get(input - 1));
			user.getBench().remove(input - 1);
		}
		
		else {
			
			user.displayPokemon();
			System.out.print("Select a Pokemon by entering its number: ");
			input = scan.nextInt();
			
			
			
			user.setActivePokemon(user.getPokemonInHand().get(input - 1));
			user.getHand().remove(user.getPokemonInHand().get(input - 1));
			
			
		}
		
		user.getHand().add(oldActive);
	
		
	}
			

	
	/**
	 * Checks to see if a Pokemon can attack
	 * A Pokemon can attack if its number of energies = its stage number
	 * 
	 * @param p the Pokemon to be checked
	 * @return true if the Pokemon can attack, false otherwise
	 */
	private boolean checkToAttack(Pokemon p) {
		
		boolean canAttack = false;
		
		if (p.getStage() == p.getEnergies().size() && p.getEnergies().size() != 0) {
			
			canAttack = true;
			
		}
		
		
		return canAttack;
		
	}
		
	
	/**
	 * Gives each player an active Pokemon
	 * This makes beginning the game simpler
	 * 
	 */
	private void makePokemonActive() {
		
		for (int i = 0; i < user.getHand().size(); i++) {
			
			Card singleCard = user.getHand().get(i);
			
			if (singleCard instanceof Pokemon) {
				
				user.setActivePokemon((Pokemon) singleCard);
				user.removeFromHand((Pokemon) singleCard);
				break;
			}
			
			
		} 
		
		
		for (int i = 0; i < opponent.getHand().size(); i++) {
			
			Card oppCard = opponent.getHand().get(i);
			
			if (oppCard instanceof Pokemon) {
				
				opponent.setActivePokemon((Pokemon) oppCard);
				opponent.removeFromHand((Pokemon) oppCard);
				break;
				
			}
			
			
		}
		
	}
	
	/**
	 * 	Runs the computer opponent's turn.
	 * 	It makes one of each option if possible.
	 * 
	 */
	private void playComputerTurn() {
		 
		if(checkGameStatus() == false) { return; }
		
		Pokemon tempPoke = new Pokemon();
		
		// SWAP ACTIVE
		if (opponent.getPokemonInHand().size() != 0) {
			
			tempPoke = opponent.getPokemonInHand().get(0);
			opponent.getHand().add(opponent.getActivePokemon());
			opponent.setActivePokemon(tempPoke);
			
		}
		
		// ADD A POKEMON TO BENCH
		tempPoke = opponent.getPokemonInHand().get(0);
		opponent.addToBench(tempPoke);
		opponent.removeFromHand(tempPoke);
		
		
		// ATTACH AN ENERGY
		
		// If active does not have enough energy, give it one
		if (checkToAttack(opponent.getActivePokemon()) == false) {
			
			
			for (Card singleCard : opponent.getHand()) {
				
				if (singleCard instanceof Energy) {
					
					if (((Energy) singleCard).getType() == opponent.getActivePokemon().getType()) {
						
						opponent.getActivePokemon().addEnergy((Energy) singleCard);
						opponent.getHand().remove(singleCard);
						break;
					}
					
				}
				
			}
			
			
			
		}
		
		// else, energize a benched Pokemon if possible
		else {
			
			if (opponent.getBench().size() != 0) {
				
				for (Pokemon singleCard : opponent.getBench()) {
					
					for (Energy nestedCard : opponent.getEnergyInHand()) {
						
						if (nestedCard.getType() == singleCard.getType()) {
							
							singleCard.addEnergy(nestedCard);
							opponent.removeFromHand(nestedCard);
							
						}
						
					}
					
				}
				
			}
			
			
		}
		
		
		// ATTACK
		if (opponent.getActivePokemon().getEnergies().size() == opponent.getActivePokemon().getStage()) {
			
			System.out.println("The opponent's Pokemon did " + opponent.getActivePokemon().getDamage() + " damage.");
			opponent.getActivePokemon().damage(user.getActivePokemon());
			int userHp = user.getActivePokemon().getHp();
			
			System.out.println("Your active " + user.getActivePokemon().getName() + " now has " + userHp + " health");
			
			if (userHp <= 0) {
				
				System.out.println("Your active has died");
				user.removeActive();
				opponent.addPrizeCardToHand();
			}
			
		}
		
		
		
		System.out.println("");
		
		
		// USE A TRAINER
		if (opponent.getTrainerInHand().size() != 0) {
			
			
			Trainer usedTrainer = opponent.getTrainerInHand().get(0);
			
			System.out.println("Computer Used " + usedTrainer.getName() + "\n");
			usedTrainer.perform(opponent);
			opponent.getHand().remove(usedTrainer);
			
		}
		
		
	}

	/**
	 * Checks to see if the game is over and declares a winner
	 * 
	 * There is a winner when:
	 * 	1. someone has 0 prize cards
	 * 	2. someone has 0 cards in their deck
	 * 	3. someone has no active or benched Pokemon

	 * 
	 * @return true if the game is active; false otherwise
	 */
	private boolean checkGameStatus() {
		
		boolean gameStatus = true;
		
		if (user.getPrizes().size() == 0) {
			
			gameStatus = false;
			winner = opponent;
			
		}
		
		if (opponent.getPrizes().size() == 0) {
			
			gameStatus = false;
			winner = user;
		}
		
		if (user.getDeck().size() == 0 && user.getHand().size() == 0) {
			
			gameStatus = false;
			winner = opponent;
		}
		
		if (opponent.getDeck().size() == 0 && opponent.getHand().size() == 0) {
			
			gameStatus = false;
			winner = user;
		}
		
		
		if (user.getActivePokemon() == null && user.getDeck().get(0) == null) {
			
			gameStatus = false;
			winner = opponent;
		}
		
		if (opponent.getActivePokemon() == null  && user.getDeck().get(0) == null) {
			
			gameStatus = false;
			winner = user;
		}
		
		return gameStatus;
		
	}
	
	
	
}