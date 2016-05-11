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
	public ArrayList<Character> characters;
	public ArrayList<Network> networks;
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
		cp5.addButton("add").setLabel("ADD ALL").setPosition(950, 70).setSize(200, 50).setColorBackground(color(173, 204, 180)).setColorForeground(color(185, 228, 199));
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
		for(Character character : characters) character.mouseEvent();
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
			JSONObject json1;
			json1 = links.getJSONObject(i);
			int s = json1.getInt("source");
			int d = json1.getInt("target");
			int v = json1.getInt("value");
			this.networks.add(new Network(this, s, d, v));
		}
	}
	
	public void keyPressed()
	{
		if(keyCode==0x31) file = "starwars-episode-1-interactions.json";
		else if(keyCode==0x32) file = "starwars-episode-2-interactions.json";
		else if(keyCode==0x33) file = "starwars-episode-3-interactions.json";
		else if(keyCode==0x34) file = "starwars-episode-4-interactions.json";
		else if(keyCode==0x35) file = "starwars-episode-5-interactions.json";
		else if(keyCode==0x36) file = "starwars-episode-6-interactions.json";
		else if(keyCode==0x37) file = "starwars-episode-7-interactions.json";
		else return;
		characters.clear();
		networks.clear();
		loadData();
	}
	
	public void add()
	{
		for(Character character : characters) character.isIn = true;
		characters.get(0).adjustCircle();
	}
	
	public void clear()
	{
		for(Character character : characters)
		{
			character.isIn = false;
			character.moveBack();
		}
	}
}
