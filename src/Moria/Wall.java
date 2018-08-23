package Moria;
public class Wall extends Block
{	
	public Wall()
	{
		this.SetSymbol("#");
	}
	
	public Wall(int x, int y)
	{		
		this.SetSymbol("#");
		this.x = x;
		this.y = y;
	}
}
