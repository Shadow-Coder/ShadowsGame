package Moria;

public abstract class Entity extends GameObject 
{
	public int MaxHp;
	public int Hp;
	public String Name;	
	
	public Entity()
	{
		
	}
	
	public void takeDamage (int dmg)
	{
		this.Hp = this.Hp - dmg;
		
		if(this.Hp < 0)
		{
			this.Hp = 0;
		}
	}
}
