package com.au.poker.processor;

import java.util.Comparator;
import java.util.List;

import com.au.poker.model.Card;

public class HandSorter {

	
	public boolean isRoyalFlush(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		if (cards.get(0).getRank() == 9 && cards.get(1).getRank() == 10 && cards.get(2).getRank() == 11 
				&&	cards.get(3).getRank() == 12 && cards.get(4).getRank() == 13) {
			
			Card card = cards.get(0);
			for (int i = 1; i < cards.size(); i++) {
				if (card.getSuit() != cards.get(i).getSuit()) {
					return false;
				} 
			}
			
		}else {
			return false;
		}
		return true;
	}
	
	
	public boolean isStraightFlush(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));

		for (int i = 1; i < 5; i++) {
			if (cards.get(0).getSuit() != cards.get(i).getSuit())	{
				return false;
			}
		}

		if (!isStraght(cards)) {
			return false;
		}
		return true;
	}


	public boolean isStraght(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		for (int j = 0; j < cards.size() -1; j++) {
			if ( (cards.get(j).getRank() +1) != cards.get(j + 1).getRank()) {
				return false;
			}
		}
		
		return true;
	}
	
	
	/**
	 * Four cards of the same value 
	 * @param cards
	 * @return boolean
	 */
	
	public boolean isFourOfaKind(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		 
		int count = 0;
		for (int j = 1; j < cards.size(); j++) {
			if (cards.get(0).getRank() != cards.get(j).getRank()) {
				count++;
			}
		}
		
		if (count > 1) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean isThreeOfAkind(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		int count = 1;
		for (int i = 1; i < 5; i++) {
			if (cards.get(i -1).getRank() ==  cards.get(i).getRank()) {
				count++;
			}
		}
		
		if (count == 3) {
			return true;
		}
		
		return false;
	}
	
	public boolean isPair(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		int count = 1;
		for (int i = 1; i < 5; i++) {
			if (cards.get(i -1).getRank() ==  cards.get(i).getRank()) {
				count++;
			}
		}
		
		if (count == 2) {
			return true;
		}
		
		return false;
	}
	
	
	public boolean isFullHouse(List<Card> cards) {
		return isThreeOfAkind(cards) && isPair(cards);
	}

	
	public boolean isFlush(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		int count = 0;
		for (int j = 1; j < cards.size(); j++) {
			if (cards.get(0).getSuit() != cards.get(j).getSuit()) {
				count++;
			}
		}
		
		if (count > 0) {
			return false;
		}
		
		return true;
	}
	
	
	public boolean isTwoPairs(List<Card> cards) {
		cards.sort(Comparator.comparing(Card::getRank));
		
		int count = 0;
		
		if (cards.get(0).getRank() ==  cards.get(1).getRank()) {
			count++;
		}
		
		for (int i = 3; i < 5; i++) {
			if (cards.get(i -1).getRank() ==  cards.get(i).getRank()) {
				count++;
			}
		}
		
		if (count == 2) {
			return true;
		}
		
		return false;
	}
	
	
	public int hight(List<Card> cards) {

		int highCard = 0;
		for (int i = 0; i < 5; i++)
		{
			if (cards.get(i).getRank() > highCard)
			{
				highCard = cards.get(i).getRank();
			}
		}
		return highCard;
	}


}
