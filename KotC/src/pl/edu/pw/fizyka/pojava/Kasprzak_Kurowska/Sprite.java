package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Image;

public abstract class Sprite {

	private Image image;
	private boolean deadBalloon;
	protected int x; 
	protected int y; 
	protected int dx; 
	
	public abstract void move(); 
	
	public Sprite () {
		deadBalloon = false; 
	}
	
	public void deadBalloon() {
		this.deadBalloon = true; 
	}
	
	public void setImage(Image image) {
		this.image = image; 
	}
	
	public Image getImage() {
		return this.image;
	}
	
	public void setX(int x) {
		this.x = x; 
	}
	
	public void setY(int y) {
		this.y = y; 
	}
	
	public int getX(int x) {
		return this.x; 
	}
	
	public int getY(int y) {
		return this.y;
	}
	
	public void setDeadBalloon(boolean deadBalloon) {
		this.deadBalloon = deadBalloon; 
	}	
	
	public boolean isDeadBalloon(boolean deadBalloon) {
		return this.deadBalloon; 
	}
}
