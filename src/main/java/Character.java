package main.java;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character
{
	
	private MainApplet parent;
	public String name;
	private int color;
	public float x, y, r;
	
	public Character(MainApplet parent, String name, int color, int x, int y)
	{
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.r = 30;
	}

	public void display()
	{
		this.parent.fill(color);
		this.parent.stroke(color);
		this.parent.ellipse(x+40, y+40, r, r);
	}
	
	public void displayName()
	{
		if(this.parent.mouseX > x+25 && this.parent.mouseX < x+55 && this.parent.mouseY > y+25 && this.parent.mouseY < y+55)
		{
			this.parent.fill(171, 202, 176);
			this.parent.stroke(171, 202, 176);
			this.parent.rect(x+40, y+25, name.length()*15, 30, 10);
			this.parent.fill(255);
			this.parent.textSize(18);
			this.parent.text(name, x+45, y+47);
			r=35;
		}
		else r=30;
	}
	
}
