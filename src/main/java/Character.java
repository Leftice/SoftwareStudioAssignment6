package main.java;

import java.util.ArrayList;

import de.looksgood.ani.Ani;

/**
* This class is used to store states of the characters in the program.
* You will need to declare other variables depending on your implementation.
*/
public class Character
{
	
	private MainApplet parent;
	public String name;
	public int color;
	public float x, y, r, sx, sy;
	public boolean isMove = false, isIn = false;
	private ArrayList<Character> targets;
	
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
		targets = new ArrayList<Character>();
		Ani.init(this.parent);
	}

	public void display()
	{
		this.parent.fill(color);
		this.parent.stroke(color);
		this.parent.ellipse(x+40, y+40, r, r);		
	}
	
	public void mouseEvent()
	{
		int i=0;
		for(Character character : this.parent.characters)
		{
			if(character.isMove && !character.equals(this)) break;
			i++;
		}
		if(i==this.parent.characters.size())
		{
			if(this.parent.mouseX > x+25 && this.parent.mouseX < x+55 && this.parent.mouseY > y+25 && this.parent.mouseY < y+55)
			{
				if(this.parent.mousePressed) isMove = true;
				if(!isMove) showName();
				r=35;
			}
			else r=30;
		}
		if(isMove) move();
	}
	
	public void move()
	{
		display();
		if(this.parent.mousePressed)
		{
			x = this.parent.mouseX-40;
			y = this.parent.mouseY-40;
			showName();
		}
		else
		{
			if(Math.pow(x-560, 2)+ Math.pow(y-280, 2) < Math.pow(250, 2))
			{
				isIn = true;
				adjustCircle();
			}
			else
			{
				isIn = false;
				adjustCircle();
				moveBack();
			}
			isMove = false;
		}
	}
	
	public void moveBack()
	{
		Ani.to(this, (float)0.7, "x", sx);
		Ani.to(this, (float)0.7, "y", sy);
	}
	
	public void showName()
	{
		this.parent.fill(171, 202, 176);
		this.parent.stroke(171, 202, 176);
		this.parent.rect(x+40, y+25, name.length()*15, 30, 10);
		this.parent.fill(255);
		this.parent.textSize(18);
		this.parent.text(name, x+45, y+47);
	}
	
	public void adjustCircle()
	{
		double num = 0, i = 0, angle;
		for(Character character : this.parent.characters) if(character.isIn) num++;
		for(Character character : this.parent.characters)
		{
			if(character.isIn)
			{
				angle = 360/num * i;
				angle = Math.toRadians(angle);
				i++;
				character.x = (float) (560 + 250 * Math.cos(angle));
				character.y = (float) (280 - 250 * Math.sin(angle));
				
			}
		}
	}

	public void addTarget(Character target){
		targets.add(target);
	}
}
