package com.au.poker.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private List<Card> cards = new ArrayList<>();
	private int hands;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHands() {
		return hands;
	}

	public void setHands(int hand) {
		this.hands = hand;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void addCard(Card card) {
		this.cards.add(card);
	}

}
