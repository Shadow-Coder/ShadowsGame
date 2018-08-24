package Moria;
public class Wall extends Block
{	
	public Wall()
	{
		this.setSymbol("#");
		this.Breakable = false;
	}
	
	public Wall(int x, int y)
	{		
		this.setSymbol("#");
		this.Breakable = false;
		this.x = x;
		this.y = y;
	}
}
