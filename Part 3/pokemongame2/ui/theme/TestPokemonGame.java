package com.example.pokemongame2.ui.theme;

import android.os.Bundle;

import com.example.pokemongame2.GAME.PokemonGame;

/**
 * Runs a Pokemon Game
 * 
 * @author Jason Chandler
 *
 */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set the static context to the MainActivity context
		PokemonGame.setContext(this);  // 'this' refers to the current Activity context

		// Now you can create the PokemonGame object without passing context in the constructor
		PokemonGame game = new PokemonGame();

		// Start the game
		game.runGame();
	}
}
	
}
