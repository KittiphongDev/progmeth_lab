package logic;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class UnitDeck {

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardInDeck;
    }

    public void setCardInDeck(ArrayList<CardCounter> cardInDeck) {
        this.cardInDeck = cardInDeck;
    }

    private ArrayList<CardCounter> cardInDeck;

    public String getDeckName() {
        if (deckName.isBlank())
        {
            return "Untitled Deck";
        }
        else{
            return deckName;
        }
    }

    public void setDeckName(String deckName) {
        if (deckName.isBlank())
        {
            this.deckName = "Untitled Deck";
        }
        else{
            this.deckName = deckName;
        }
    }

    private String deckName;

    public UnitDeck(String deckName)
    {
        if (deckName.isBlank())
        {
            this.deckName = "Untitled Deck";
        }
        else{
            this.deckName = deckName;
        }
        cardInDeck = new ArrayList<CardCounter>();
    }

    public void addCard(UnitCard newCard,int count)
    {
        if (count<=0)
        {
        }
        else if (existsInDeck(newCard))
        {
            for (CardCounter cd:cardInDeck)
            {
                if (cd.getCard().equals(newCard))
                {
                    cd.setCount(cd.getCount()+count);
                }
            }
        }
        else if (!existsInDeck(newCard))
        {
            CardCounter cc = new CardCounter(newCard,count);
            cardInDeck.add(cc);
        }
    }

    public void removeCard(UnitCard toRemove, int count) {
        if (count <= 0 || !existsInDeck(toRemove)) {
            return;
        }

        for (int i = 0; i < cardInDeck.size(); i++) {
            CardCounter cd = cardInDeck.get(i);

            if (cd.getCard().equals(toRemove)) {
                cd.setCount(cd.getCount() - count);

                if (cd.getCount() <= 0) {
                    cardInDeck.remove(i);
                }
            }
        }
    }

    public int cardCount()
    {
        int cardAmount =0;
        for (CardCounter cd : cardInDeck)
        {
            cardAmount += cd.getCount();
        }
        return cardAmount;
    }

    public boolean existsInDeck(UnitCard card)
    {
        for (CardCounter cd : cardInDeck)
        {
            if (cd.getCard().equals(card))
            {
                if (cd.getCount() >= 1)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(UnitDeck other)
    {
        if(deckName == other.getDeckName())
        {
            return true;
        }
        return false;
    }

}
