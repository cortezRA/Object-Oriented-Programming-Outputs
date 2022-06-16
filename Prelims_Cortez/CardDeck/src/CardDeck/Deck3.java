package CardDeck;

import java.util.*;

public class Deck3 {
	private static Card3[] cards = new Card3[52];
	
	public Deck3() {
		int i = 0;
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards[i++] = new Card3(rank, suit);
			}
		}
	}
	
	public void printCard() {
		for(Card3 fullDeck: cards) {
			System.out.println(fullDeck.toString());
		}
	}
}
