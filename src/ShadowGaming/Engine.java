package ShadowGaming;

import java.util.*;

public class Engine 
{
	private Boolean isRunning = false;
	private GameObject[][] _map;
	private int _mapWidth;
	private int _mapLength;
	
	public int targetFps = 0;
	
	public Engine(int mapWidth, int mapLength)
	{
		this._mapWidth = mapWidth;
		this._mapLength = mapLength;
		
		// IF GAME ENGINE IS LOADING FOR THE FIRST TIME
		if(this.isRunning == false)
		{
			this.loadMap(0);		
			this.isRunning = true;
		}
		
		
		
	}
	
	public void loadMap(int level)
	{
		
	}
	
	public void nextTurn()
	{
		
	}
	
	private void createMap()
	{
		
	}
}
