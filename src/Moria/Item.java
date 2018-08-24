package Moria;

public abstract class Item extends GameObject 
{
	public String name;
	public int dSides;
	public int dRolls;
	
	public Item()
	{		
		// UNLESS SPECIFIED ASSUME A FOUR SIDED DIE WITH ONE ROLL
		dSides = 4;
		dRolls = 1;
	}
}
