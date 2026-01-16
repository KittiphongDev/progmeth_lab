package logic;

public class CardCounter {

	public UnitCard getCard() {
		return card;
	}

	public void setCard(UnitCard card) {
		this.card = card;
	}

	public int getCount() {
		if (count <0)
		{
			return 0;
		}
		else {
			return count;
		}
	}

	public void setCount(int count) {
		if (count <0)
		{
			this.count = 0;
		}
		else {
			this.count = count;
		}
	}

	private UnitCard card;
	private int count;
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}

	public CardCounter(UnitCard card, int count)
	{
		this.card = card;
		this.count = count;
	}

}
