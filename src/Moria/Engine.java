package Moria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import Moria.*;

public class Engine 
{
	private Boolean isRunning = false;
	private Map _blockMap;
	private Map _entityMap;
	private Map _itemMap;
	private float _turnCount = 0;	
	private int _mapWidth;
	private int _mapLength;
	private Character C;
	
	public int targetFps = 0;
	
	public Engine(int mapWidth, int mapLength)
	{
		this._mapWidth = mapWidth;
		this._mapLength = mapLength;
		
		// INITIALIZE THE BLOCK MAP
		_blockMap = new Map(_mapWidth, _mapLength);
		
		// INITIALIZE THE ENTITY MAP
		_entityMap = new Map(_mapWidth, _mapLength);
		
		// INITIALIZE THE ITEM MAP
		_itemMap = new Map(_mapWidth, _mapLength);
		
		// IF GAME ENGINE IS LOADING FOR THE FIRST TIME
		if(this.isRunning == false)
		{
			this.isRunning = true;
			
			this.loadBlockMap(0);
			
			// PLACE MAIN CHARACTER IN THE ENTITY MAP
			C = new Character();
			C.x = 5;
			C.y = 5;				
			this._entityMap.addGameObject(C);
		}
	}
	
	private void loadBlockMap (int level)
	{
		try 
		{
			FileReader fr;			
			String l = "src\\Moria\\mapLevel0";
			fr = new FileReader(l);
			Scanner in = new Scanner(fr);
			
			int _currentRow = 0;
			
			while(in.hasNext())
			{
				int _currentCol = 0;
				char[] chars = in.nextLine().toCharArray();
				
				for(char c : chars)
				{
					if(c == '#')
					{
						this._blockMap.addGameObject(new Wall(_currentRow, _currentCol));
					}
					if(c == '0')
					{
						this._blockMap.addGameObject(new Air(_currentRow, _currentCol));
					}
					_currentCol++;
				}
				_currentRow++;
			}
				
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String NextTurn(String Turn)
	{
		String _result = "";
		
		int x = 0;
		int y = 0;
		
		if(Turn == "w")
		{
			x = C.x-1;
			y = C.y;			
		}
		if(Turn == "s") 
		{
			x = C.x+1;
			y = C.y;
		}
		if(Turn == "d")
		{
			y = C.y+1;
			x = C.x;
		}
		if(Turn == "a")
		{
			y = C.y-1;
			x = C.x;
		}
		
		// GET GAME OBJECT AT POSITION WHERE CHARACTER IS TRYING TO MOVE
		//
		GameObject o = this.GetGameObjectAt(x, y);
		
		// DETERMINE IF REQUESTED MOVE IS A MELEE ATTACK
		//
		Class c = o.getClass();
		
		if(o.Symbol == "M")
		{
			// DETERMINE IF WE CAN DAMAGE THIS ENTITY
			
		}
		
		// IF NOT A MELEE ATTACK DETERMINE IF CHARACTER CAN MOVE TO THE REQUESTED LOCATION
		//
		if(o.getClass().getName() == "Moria.Wall")
		{
			return "You cannot move through walls.";
		}
		if(o.getClass().getName()  == "Moria.Air") 
		{
			_result = MoveCharacter(x, y);
		}
		
		// TURN COMPLETED -- INCREMENT TURN COUNTER AND RETURN STRING MESSAGE
		//
		this._turnCount++;
		return _result;
	}
	
	private String MoveCharacter(int x, int y)
	{
		String _result = "";
		
		// RETURN PREVIOUS OBJECT TO CHARACTER CURRENT LOCATION BEFORE MOVING
		GameObject o = this.GetGameObjectAt(x, y);
		
		// MOVE CHARACTER TO THE SPECIFIED SPOT IF NOT A WALL OR OTHER ENTITY
		if((o.getClass().getName() == "Moria.Entity" || o.getClass().getName() == "Moria.Wall"))
		{
			return "You cannot move to this location.";
		}
		

		
		this._entityMap.removeGameObjectAt(C.x, C.y);
		C.x = x;
		C.y = y;		
		this._entityMap.addGameObject(C);
		
		//C.x = x;
		//C.y = y;
		
		// RETURN OUR RESULT MESSAGE
		return _result;
	}
	
	private GameObject GetGameObjectAt(int x, int y)
	{
		// IF A MONSTER EXISTS AT A LOCATION, RETURN THAT MONSTER
		// IF NO MONSTER THEN RETURN A GAME ITEM
		// IF NO GAME ITEM EXISTS, RETURN THE BLOCK
		GameObject o = this._entityMap.getGameObjectAt(x, y);
		
		if(o != null)
		{
			return o;
		}
		
		o = this._itemMap.getGameObjectAt(x, y);
		if(o != null)
		{
			return o;
		}
		
		o = this._blockMap.getGameObjectAt(x, y);
		if(o != null)
		{
			return o;
		}
		
		return null;
	}
	
	public String getStringMap()
	{
		String result = "";
		
		GameObject[][] map = new GameObject[this._mapLength][this._mapWidth];
		
		for(int x=0; x < _mapLength; x++)
		{
			for(int y=0; y < _mapWidth; y++)
			{
				// PLACE ALL BLOCKS
				GameObject block = this._blockMap.getGameObjectAt(x, y);
				map[x][y] = block;
				
				// GET ALL ITEMS AND PLACE IN MAP
				GameObject item = this._itemMap.getGameObjectAt(x, y);
				if(item != null)
				{
					map[x][y] = item;
				}

				// GET ALL ENTITIES AND PLACE IN MAP
				GameObject entity = this._entityMap.getGameObjectAt(x, y);
				if(entity != null)
				{
					map[x][y] = entity;
				}				
			}
		}
		
		for(int x=0; x < _mapLength; x++)
		{
			for(int y=0; y < _mapWidth; y++)
			{
				GameObject o = map[x][y];
				result = result + o.Symbol;				
			}
			result = result + "\n";
		}
		
		return result;
	}
	
	public void addEntity(Entity e)
	{
		this._entityMap.addGameObject(e);
	}
	
	public void addItem(Item i)
	{
		this._itemMap.addGameObject(i);
	}
	
	
	public void setCharacterPrimaryWeapon(Weapon w)
	{
		C.PrimaryWeapon = w;
		
	}
	
	//public void setCharacterSecondaryWeapon(Weapon w)
	//{
	//	C.SecondaryWeapon = w;
	//}
}
