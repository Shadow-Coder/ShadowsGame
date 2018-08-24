package Moria;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Map 
{
	private GameObject[][] _map;
	private int _mapWidth;
	private int _mapLength;
	
	public Map(int Width, int Length)
	{
		this._mapWidth = Width;
		this._mapLength = Length;
		this._map = new GameObject[_mapLength][_mapWidth];
	}	

	public void addGameObject (GameObject o)
	{
		_map[o.x][o.y] = o;
	}
	
	public void removeGameObjectAt (int x, int y)
	{
		_map[x][y] = null;
	}
	
	public void replaceGameObjectAt (int x, int y, GameObject o)
	{
		_map[x][y] = o;
	}
	
	public GameObject getGameObjectAt(int x, int y)
	{
		return this._map[x][y];
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
}
