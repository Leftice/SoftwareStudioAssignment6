package main.java;


import processing.core.PApplet;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character
{
	
	private MainApplet parent;
	private String name;
	int color;
	public float x, y;
	
	public Character(MainApplet parent, String name, int color, int x, int y)
	{
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public void display()
	{
		this.parent.fill(color);
		this.parent.stroke(color);
		this.parent.ellipse(x+40, y+40, 30, 30);
	}
	
}
