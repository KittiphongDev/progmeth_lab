package logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import static java.lang.Integer.parseInt;

public class CardUtil {
	
	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		
		//TODO: Fill Code

		if (list.contains(card))
		{
			return true;
		}

		return false;

	}
	
	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		
		//TODO: Fill Code

		if (list.contains(deck))
		{
			return  true;
		}

		return false;

	}
	
	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {
		
		//TODO: Fill Code

		for (UnitDeck ud: deckList )
		{
			for (CardCounter cd : ud.getCardsInDeck())
			{
				if (cd.getCard() == cardToTest)
				{
					return true;
				}
			}
		}

		return false;
	}
	
	public static ArrayList<UnitCard> getCardsFromFile(String filename){
		
		ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();
		InputStream inputStream = CardUtil.class.getClassLoader().getResourceAsStream(filename);
          	if (inputStream == null) {
                	System.out.println("Cannot find file!");
                	return null;
            	}

            	Scanner myReader = new Scanner(inputStream);


		//TODO: Fill Code below

		String getFromMyreader;

		while (myReader.hasNext())
		{
			getFromMyreader = myReader.nextLine().toString();
			String[] input = getFromMyreader.split(",");
			UnitCard un = new UnitCard(input[0],parseInt(input[1]),parseInt(input[2]),parseInt(input[3]),input[4]);
			cardsFromFile.add(un);
		}
		myReader.close();
		
		return cardsFromFile;
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {
		
		for(int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if(verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if(i < cardList.size()-1) System.out.println("-----");
			}
		}
	}
	
	public static void printDeck(UnitDeck ud) {
		
		if(ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		}else {
			for(CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}
		
		System.out.println("Total Cards: " + ud.cardCount());
	}
	
	public static void printDeckList(ArrayList<UnitDeck> deckList) {
		
		
		for(int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if(i < deckList.size()-1) System.out.println("-----");
		}
	}

}
