package Moria;

public abstract class Entity extends GameObject 
{
	public int MaxHp;
	public int Hp;
	public Boolean IsMonster = false;
	
	public Entity()
	{
		
	}
	
	public void takeDamage (int dmg)
	{
		this.Hp = this.Hp - dmg;
	}
}
