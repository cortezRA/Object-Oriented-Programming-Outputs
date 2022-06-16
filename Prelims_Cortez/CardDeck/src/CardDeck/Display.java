package CardDeck;

import java.util.*;

public class Display {
	public static void main(String[] args) {
		Deck deck = new Deck();
		for (int suit = Card.DIAMONDS; suit <= Card.SPADES; suit++) {
			for (int rank = Card.ACE; rank <= Card.KING; rank++) {
					Card card = deck.getCard(suit, rank);
					System.out.format("%s of %s%n",
						card.rankToString(card.getRank()),
						card.suitToString(card.getSuit()));
			}
		}
		
		System.out.println();
		
		Deck3 deck3 = new Deck3();
		deck3.printCard();
	}
}