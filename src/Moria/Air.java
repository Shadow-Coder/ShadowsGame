package Moria;

public class Air extends Block
{
	public Air()
	{
		this.SetSymbol(".");
	}
	
	public Air(int x, int y)
	{
		this.SetSymbol(".");
		this.x = x;
		this.y = y;
	}
}
