package ShadowGaming;

public class Shadowsgame {
	
	public static void main(String[] args)
	{
		// CREATE OUR GAME ENGINE OBJECT WITH A MAP SIZE OF 20 X 20.
		Engine e = new Engine(20,20);
		
		// LOAD OUR MAP IN THE GAME ENGINE
		e.loadMap(0);		
		
		Goblin g = new Goblin();
		
		Wall w = new Wall();
		w.Breakable = false;
		
		System.out.print(g.Hp);
		
		g.takeDamage();

	}

}
