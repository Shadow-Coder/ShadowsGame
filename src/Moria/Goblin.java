package Moria;
public class Goblin extends Monster {

	public Goblin(int x, int y) 
	{
		this.Symbol = "G";
		this.IsMonster = true;
		this.Hp = 100;
		this.MaxHp = 100;
		this.x = x;
		this.y = y;
	}
	
}
