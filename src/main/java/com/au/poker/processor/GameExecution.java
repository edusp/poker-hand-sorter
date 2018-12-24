package com.au.poker.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.au.poker.model.Card;
import com.au.poker.model.Player;

public class GameExecution {

	private static List<Player> players = new ArrayList<>();
	private static Player player1;
	private static  Player player2;
	
	
	public GameExecution() {
		player1 = new Player();
		player2 = new Player();
	}
	
	public void exec() {

		System.out.println("PLease, provide hands for two players or a valid File URL: ");
		Scanner scanner = new Scanner(System.in);
		String hands = scanner.nextLine();

		System.out.println("\n Working...");

		if (new File(hands).isFile()) {
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader(new File(hands)));

				String st;

				while ((st = br.readLine()) != null) {
					checkHands(st);
				}

				br.close();
			} catch (Exception  e) {
				e.printStackTrace();
			}
		}else {
			checkHands(hands);
		}

		System.out.println("Player 1: "+players.get(0).getHands());
		System.out.println("Player 2: "+players.get(1).getHands());

		scanner.close();
	}


	private static void checkHands(String st) {

		HandSorter hand = new HandSorter();

		int handsP1 = player1.getHands();
		int handsP2 = player1.getHands();


		String[] cards = st.split(" ");

		for (int i = 0; i <= 4; i++) {
			player1.addCard(new Card(cards[i]));
		}
		for (int i = 5; i <= 9; i++) {
			player2.addCard(new Card(cards[i]));
		}


		//Verify the hasnds for two players

		if(hand.isRoyalFlush(player1.getCards())) {
			handsP1 += 10;					
		}
		if(hand.isRoyalFlush(player2.getCards())) {
			handsP2 += 10;
		}


		if(hand.isStraightFlush(player1.getCards())) {
			handsP1 += 9;
		}
		if(hand.isRoyalFlush(player2.getCards())) {
			handsP2 += 9;
		}



		if(hand.isFourOfaKind(player1.getCards())) {
			handsP1 += 8;
		}
		if(hand.isFourOfaKind(player2.getCards())) {
			handsP2 += 8;
		}


		if(hand.isFullHouse(player1.getCards())) {
			handsP1 += 7;
		}
		if(hand.isFullHouse(player2.getCards())) {
			handsP2 += 7;
		}



		if(hand.isFlush(player1.getCards())) {
			handsP1 += 6;
		}
		if(hand.isFlush(player2.getCards())) {
			handsP2 += 6;
		}



		if(hand.isStraght(player1.getCards())) {
			handsP1 += 5;
		}
		if(hand.isStraght(player2.getCards())) {
			handsP2 += 5;
		}



		if(hand.isThreeOfAkind(player1.getCards())) {
			handsP1 += 4;
		}
		if(hand.isThreeOfAkind(player2.getCards())) {
			handsP2 += 4;
		}



		if(hand.isTwoPairs(player1.getCards())) {
			handsP1 += 3;
		}
		if(hand.isTwoPairs(player2.getCards())) {
			handsP2 += 3;
		}



		if(hand.isPair(player1.getCards())) {
			handsP1 += 2;
		}
		if(hand.isPair(player2.getCards())) {
			handsP2 += 2;
		}


		if (handsP1 == handsP2) {

			int hightP1 = hand.hight(player1.getCards());
			int hightP2 = hand.hight(player2.getCards());


			if (hightP1 > hightP2) {
				handsP1 += 1;
			}else {
				handsP2 += 1;
			}

		}

		player1.setHands(handsP1);
		player2.setHands(handsP2);

		players.add(player1);
		players.add(player2);
	}

}
