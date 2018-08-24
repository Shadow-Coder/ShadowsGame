package Moria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Engine 
{
	private Boolean isRunning = false;
	private GameObject[][] _map;
	private int _mapWidth;
	private int _mapLength;
	private Character C;
	private GameObject _pObject;
	
	public int targetFps = 0;
	
	public Engine(int mapWidth, int mapLength)
	{
		this._mapWidth = mapWidth;
		this._mapLength = mapLength;
		
		// IF GAME ENGINE IS LOADING FOR THE FIRST TIME
		if(this.isRunning == false)
		{
			_map = new GameObject[_mapLength][_mapWidth];
			this.loadMap(0);		
			this.isRunning = true;
			
			// PLACE MAIN CHARACTER IN MAP
			C = new Character();
			C.x = 5;
			C.y = 5;
			
			// TRACK PREVIOUS GAME OBJECT AT OUR CHARACTER LOCATION SO WE CAN PLACE IT BACK WHEN WE MOVE
			_pObject = this._map[C.x][C.y];
			
			this._map[C.x][C.y] = C;
		}
	}
	
	private void loadMap(int level)
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
						this._map[_currentRow][_currentCol] = new Wall(_currentRow, _currentCol);
					}
					if(c == '0')
					{
						this._map[_currentRow][_currentCol] = new Air(_currentRow, _currentCol);
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
	
	public String GetStringMap()
	{
		String s = "";
		for(int l=0; l < this._mapLength; l++)
		{
			for(int w=0; w < this._mapWidth; w++)
			{
				s = s + this._map[l][w].Symbol;
			}	
			//ADD NEW LINE
			s = s + "\n";
		}
		
		return s;
	}

	public String NextTurn(String Turn)
	{
		String _result = "";
		
		int newx = 0;
		int newy = 0;
		
		if(Turn == "w")
		{
		
			newx = C.x-1;
			newy = C.y;
			//_result = MoveCharacter(C.x-1, C.y, 0);
			
		}
		if(Turn == "s") 
		{
			newx = C.x+1;
			newy = C.y;
			//_result = MoveCharacter(C.x+1, C.y, 0);
		}
		if(Turn == "d")
		{
			newy = C.y+1;
			newx = C.x;
			//_result = MoveCharacter(C.x,C.y+1, 0);
		}
		if(Turn == "a")
		{
			newy = C.y-1;
			newx = C.x;
			
			//_result = MoveCharacter(C.x,C.y-1, 0);
		}
		
		GameObject o = this.GetGameObjectAt(newx, newy, 0);
		if(o.Symbol == "#")
		{
			return "";
		}
		if(o.Symbol == ".") 
		{
			MoveCharacter(newx,newy, 0);
		}
		
		return _result;
		
	}
	
	private String MoveCharacter(int x, int y, int z)
	{
		String _result = "";
		
		// RETURN PREVIOUS OBJECT TO CHARACTER CURRENT LOCATION BEFORE MOVING
		this._map[this._pObject.x][this._pObject.y] = _pObject;			
		//C.x = C.x-1;
		
		// TRACK OBJECT IN SPOT WHERE THE CHARACTER WILL BE MOVING
		_pObject = _map[x][y];
		
		// MOVE CHARACTER TO THE SPECIFIED SPOT
		this._map[x][y] = C;	
		C.x = x;
		C.y = y;
		
		// RETURN OUR RESULT MESSAGE
		return _result;
	}
	
	private GameObject GetGameObjectAt(int x, int y, int z)
	{
		return this._map[x][y];
	}
}
