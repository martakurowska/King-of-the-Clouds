package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Image;

public abstract class Sprite {

	private Image image;
	private boolean deadBalloon;
	protected int x; 
	protected int y, bcgrndYTop, bcgrndYBottom, planeYTop, planeYBottom; 
	protected int dx, dy; 
	
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
	
	public void setBcgrndYTop(int y) {
		this.bcgrndYTop = y; 
	}
	
	public void setBcgrndYBottom(int y) {
		this.bcgrndYBottom = y; 
	}
	
	public void setPlaneYTop(int y) {
		this.planeYTop = y; 
	}
	
	public void setPlaneYBottom(int y) {
		this.planeYBottom = y; 
	}
	
	public int getX() {
		return this.x; 
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getBcgrndYTop() {
		return this.bcgrndYTop;
	}
	
	public int getBcgrndYBottom() {
		return this.bcgrndYBottom;
	}
	
	public int getPlaneYTop() {
		return this.planeYTop;
	}
	
	public int getPlaneYBottom() {
		return this.planeYBottom;
	}
	
	public void setDeadBalloon(boolean deadBalloon) {
		this.deadBalloon = deadBalloon; 
	}	
	
	public boolean isDeadBalloon(boolean deadBalloon) {
		return this.deadBalloon; 
	}

}
