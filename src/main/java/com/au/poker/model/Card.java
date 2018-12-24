package com.au.poker.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Card {
	
	private static String[] suits = { "h", "s", "d", "c" };
	private static Map<String, Integer> ranks = new HashMap<>();
		
	//List<String> ranks  = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");
	
	private char suit;
	private int rank;

	public Card(String card) {
		buildRanks();
		cardBuild(card);
	}

	public char getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}

	public void setSuit(char suit) {
		this.suit = suit;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	private static void buildRanks() {
		ranks.put("2", 1); 
		ranks.put("3", 2); 
		ranks.put("4", 3); 
		ranks.put("5", 4); 
		ranks.put("6", 5); 
		ranks.put("7", 6); 
		ranks.put("8", 7); 
		ranks.put("9", 8); 
		ranks.put("T", 9);
		ranks.put("J", 10); 
		ranks.put("Q", 11); 
		ranks.put("K", 12); 
		ranks.put("A", 13);
	}

	private void cardBuild(String card) {

		try {
			this.rank = ranks.get(card.substring(0, 1));
			this.suit = card.charAt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rank;
		result = prime * result + suit;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	
	

}
