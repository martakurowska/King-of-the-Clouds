package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Image;

public abstract class Sprite {

	private Image image;
	private boolean dead;
	protected int x; 
	protected int y, bcgrndYTop, bcgrndYBottom;
	protected double dx, dy; 
	
	public abstract void move(); 
	
	public Sprite () {
		dead = false; 
	}
	
	public void die() {
		this.dead = true; 
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
	
	public void setDead(boolean dead) {
		this.dead = dead; 
	}	
	
	public boolean isDead() {
		return this.dead; 
	}

}
