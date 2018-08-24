package Moria;

public class Air extends Block {
	
	public Air()
	{
		this.setSymbol(".");
	}
	
	public Air(int x, int y)
	{
		this.setSymbol(".");
		this.x = x;
		this.y = y;
	}
}
