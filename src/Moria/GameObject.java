package Moria;

public abstract class GameObject {
	
	public String Symbol;
	public int x;
	public int y;
	public Boolean IsMonster = false;	
	
	public GameObject()
	{
		
	}
		
	public void setSymbol(String s)
	{
		this.Symbol = s;
	}
}
