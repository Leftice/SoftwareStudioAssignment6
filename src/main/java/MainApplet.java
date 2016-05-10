package main.java;

import java.util.ArrayList;
import controlP5.*;
import processing.core.PApplet;
import processing.core.PFont;
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
	private ControlP5 cp5;
	
	private final static int width = 1200, height = 650;
	
	public void setup() 
	{
		size(width, height);
		smooth();
		characters = new ArrayList<Character>();
		networks = new ArrayList<Network>();
		cp5 = new ControlP5(this);
		PFont p = createFont("Georgia", 20); 
		cp5.setFont(p);
		cp5.addButton("add all").setLabel("ADD ALL").setPosition(950, 70).setSize(200, 50).setColorBackground(color(173, 204, 180)).setColorForeground(color(185, 228, 199));
		cp5.addButton("clear").setLabel("CLEAR").setPosition(950, 170).setSize(200, 50).setColorBackground(color(173, 204, 180)).setColorForeground(color(185, 228, 199));
		loadData();
	}

	public void draw() 
	{
		fill(120, 94, 84);
		background(255);
		textSize(26); 
		text("Star Wars " + file.substring(17, 18), 530, 30);
		fill(255);
		stroke(213, 220, 185);
		strokeWeight(4);
		ellipse(600, 320, 500, 500);
		for(Character character : characters) character.display();
		for(Character character : characters) character.displayName();
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
