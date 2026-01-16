package logic;

public class UnitCard {
	public void setName(String name)
	{
		if (name.isBlank())
		{
			this.name = "Creature";
		}
		else{
    		this.name = name;
		}
	}
	public void setBloodCost(int bloodCost)
	{
		if (bloodCost <0)
		{
			this.bloodCost = 0;
		}
		else{
    		this.bloodCost = bloodCost;
		}
	}
	public void setPower(int power)
	{

		if (power <0)
		{
			this.power = 0;
		}
		else{
			this.power = power;
		}
	}
	public void setHealth(int health)
	{
		if (health <1)
		{
			this.health = 1;
		}
		else{
			this.health = health;
		}
	}
public void setFlavorText(String flavorText)
{
    this.flavorText = flavorText;

}private String name;
	public String getName() {
		if (name.isBlank())
		{
			return "Creature";
		}
		else{
			return name;
		}
}public int getBloodCost() {
    return bloodCost;
}public int getPower() {
    return power;
}public int getHealth() {
    return health;
}public String getFlavorText() {
    return flavorText;
}

	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;


	public UnitCard(String name, int bloodCost, int power, int health, String flavorText)
	{
		if (bloodCost <0)
		{
			this.bloodCost = 0;
		}
		else{
			this.bloodCost = bloodCost;
		}
		if (health <1)
		{
			this.health = 1;
		}
		else{
			this.health = health;
		}
		if (name.isBlank())
		{
			this.name = "Creature";
		}
		else{
			this.name = name;
		}
		if (power <0)
		{
			this.power = 0;
		}
		else{
			this.power = power;
		}
		this.flavorText = flavorText;
	}


	public boolean equals(UnitCard other)
	{
		if (name == other.name)
		{
			return true;
		}
		return false;
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}


}
