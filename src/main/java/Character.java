package main.java;

import de.looksgood.ani.Ani;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character
{
	
	private MainApplet parent;
	public String name;
	private int color;
	public float x, y, r, sx, sy;
	private boolean isMove = false;
	
	public Character(MainApplet parent, String name, int color, int x, int y)
	{
		this.parent = parent;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.r = 30;
		this.sx = x;
		this.sy = y;
		Ani.init(this.parent);
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
			if(this.parent.mousePressed)
			{
				isMove = true;
				for(Character character : this.parent.characters) if(character.isMove && !character.equals(this)) isMove = false;
			}
			r=35;
		}
		else r=30;
		if(isMove) move();
	}
	
	public void move()
	{
		if(this.parent.mousePressed)
		{
			Ani.to(this, (float)0, "x", this.parent.mouseX-40);
			Ani.to(this, (float)0, "y", this.parent.mouseY-40);
			this.parent.fill(171, 202, 176);
			this.parent.stroke(171, 202, 176);
			this.parent.rect(x+40, y+25, name.length()*15, 30, 10);
			this.parent.fill(255);
			this.parent.textSize(18);
			this.parent.text(name, x+45, y+47);
		}
		else
		{
			Ani.to(this, (float)0.7, "x", sx);
			Ani.to(this, (float)0.7, "y", sy);
			isMove = false;
		}
	}
}
