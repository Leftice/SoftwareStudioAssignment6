package main.java;

import processing.core.PApplet;

/**
* This class is used for the visualization of the network.
* Depending on your implementation, you might not need to use this class or create a class on your own.
* I used the class to draw the circle and re-arrange nodes and links.
* You will need to declare other variables.
*/
public class Network 
{
	
	private MainApplet parent;
	public int s, d, v;
	public Network(MainApplet parent, int s, int d, int v)
	{

		this.parent = parent;
		this.s = s;
		this.d = d;
		this.v = v;
		
	}

	public void display()
	{
		if(this.parent.characters.get(s).isIn && this.parent.characters.get(d).isIn)
		{

			this.parent.fill(0,0,0);
			if(v == 1) this.parent.strokeWeight(1);
			if(v == 2) this.parent.strokeWeight(2);
			if(v == 3) this.parent.strokeWeight(3);
			if(v == 4) this.parent.strokeWeight(4);
			if(v == 5) this.parent.strokeWeight(5);
			if(v == 6) this.parent.strokeWeight(5);
			if(v == 7) this.parent.strokeWeight(6);
			if(v == 8) this.parent.strokeWeight(7);
			if(v == 9) this.parent.strokeWeight(8);
			if(v == 10) this.parent.strokeWeight(8);
			this.parent.line(this.parent.characters.get(s).x+40, this.parent.characters.get(s).y+40, this.parent.characters.get(d).x+40, this.parent.characters.get(d).y+40);
		
		}
	}
	
}
