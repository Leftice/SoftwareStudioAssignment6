package main.java;

import java.util.ArrayList;
import processing.core.PApplet;
import processing.data.JSONArray;
import processing.data.JSONObject;

/**
* This class is for sketching outcome using Processing
* You can do major UI control and some visualization in this class.  
*/
@SuppressWarnings("serial")
public class MainApplet extends PApplet
{
	private String path = "main/resources/";
	private String file = "starwars-episode-1-interactions.json";
	JSONObject data;
	JSONArray nodes, links;
	private ArrayList<Character> characters;
	private ArrayList<Network> networks;
	
	private final static int width = 1200, height = 650;
	
	public void setup() 
	{

		size(width, height);
		smooth();
		characters = new ArrayList<Character>();
		networks = new ArrayList<Network>();
		loadData();
		
	}

	public void draw() 
	{
		background(255);
		for(Character character : characters) character.display();
		for(Network network : networks) network.display();
	}

	private void loadData()
	{
		int i;
		data = loadJSONObject(path+file);
		nodes = data.getJSONArray("nodes");
		links = data.getJSONArray("links");
		for(i=0; i<nodes.size(); i++)
		{
			data = nodes.getJSONObject(i);
			String name = data.getString("name");
			String color = data.getString("colour").substring(1);
			characters.add(new Character(this, name, unhex(color), i%4*55, i/4*55));
		}
		for(i=0; i<links.size(); i++)
		{
			data = links.getJSONObject(i);
			int source = data.getInt("source");
			int target = data.getInt("target");
		}
	}

}
