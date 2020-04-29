package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Balloon extends Sprite {

	GuiFrame guiFrame; 
	
	public Balloon() {
		initialize();
	}
	
	private void initialize() {
		ImageIcon imageIcon = guiFrame.balloonImage; 
		setImage(imageIcon.getImage()); 
		
		int balloonStartX = (guiFrame.getWidth()/2 - imageIcon.getIconWidth()/2); 
		int balloonStartY = (guiFrame.getHeight()/2 - imageIcon.getIconHeight()/2);
		
		setX(balloonStartX); 
		setY(balloonStartY);
	}
	
	@Override
	public void move() {
		
	}

}
