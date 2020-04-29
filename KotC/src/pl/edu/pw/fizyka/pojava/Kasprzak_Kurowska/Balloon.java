package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Balloon extends Sprite {

	GuiFrame guiFrame; 
	int balloonStartX, balloonStartY;
	
	public Balloon(GuiFrame gui) {
		guiFrame = gui;
		initialize();
		
		dx = guiFrame.difficultyFrame.speed;
		System.out.println(dx);
	}
	
	private void initialize() {
		ImageIcon imageIcon = guiFrame.balloonImage; 
		setImage(imageIcon.getImage()); 
		
		balloonStartX = (guiFrame.getWidth()/2 - imageIcon.getIconWidth()/2); 
		balloonStartY = (guiFrame.getHeight() - imageIcon.getIconHeight() - 30);
		
		setX(balloonStartX); 
		setY(balloonStartY);
	}
	
	@Override
	public void move() {
		
	}

}
