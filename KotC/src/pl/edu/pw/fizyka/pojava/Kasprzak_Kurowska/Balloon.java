package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Balloon extends Sprite {

	GuiFrame guiFrame; 
	int balloonStartX, balloonStartY, points, lives;
	ImageIcon imageIcon;
	
	public Balloon(GuiFrame gui) {
		guiFrame = gui;
		points = 0; 
		initialize();
	}
	
	private void initialize() {
		imageIcon = guiFrame.balloonImage; 
		setImage(imageIcon.getImage()); 
		
		balloonStartX = (guiFrame.getWidth()/2 - imageIcon.getIconWidth()/2); 
		setX(balloonStartX); 
		
		lives = 3; 
	}
	
	@Override
	public void move() {
		x += dx;
		
		if(x < 0) {
			x = 0;
		}
		if(x > guiFrame.getWidth() - imageIcon.getIconWidth() -15) {
			x = guiFrame.getWidth() - imageIcon.getIconWidth() -15;
		}
		
		balloonStartY = (guiFrame.getHeight() - imageIcon.getIconHeight() - 50);
		setY(balloonStartY);
	}
	
	public String getPoints() {
		return String.valueOf(points); 
	}
}
