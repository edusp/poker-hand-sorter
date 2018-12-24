package com.au.poker;

import java.util.ArrayList;
import java.util.List;

import com.au.poker.model.Card;
import com.au.poker.model.Player;

public class BuildCardPlayes {
	
	public static List<Player> getPlayers(String cards[]) {
		
		List<Player> players = new ArrayList<>();
		
		Player player1 = new Player();
		
		for (int i = 0; i <= 4; i++) {
			Card card = new Card(cards[i]);
			player1.addCard(card);
			
		}
		players.add(player1);
		
		Player player2 = new Player();
		for (int i = 5; i <= 9; i++) {
			Card card = new Card(cards[i]);
			player2.addCard(card);
		}
		players.add(player2);
		
		return players;
	}
	

}
