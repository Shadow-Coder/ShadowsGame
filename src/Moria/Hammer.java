package Moria;

public class Hammer extends Weapon {
	
	public Hammer()
	{
		this.setupItem();
	}
	
	public Hammer(String Name)
	{
		this.setupItem();
		this.name = Name;
	}
	
	public void setupItem()
	{
		this.name = "Apprentice Hammer of Ineptitude";
		this.Symbol = "|";
		this.dRolls = 1;
		this.dSides = 8;	
	}
}
