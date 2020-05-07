package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.util.Random;

import javax.swing.ImageIcon;

//Wiktoria Kasprzak
public class Points extends Sprite {

	GamePanel gamePanel;
	public ImageIcon imageIcon; 
	private boolean visible = true; 
	Random rand = new Random();
	
	public Points(GamePanel game) { 
		gamePanel = game;
		initialize();
	}
	
	private void initialize() {
		imageIcon = new ImageIcon(getClass().getResource("others/point.png")); 
		setImage(imageIcon.getImage()); 
		
		x = rand.nextInt((int) (gamePanel.guiFrame.getWidth() - imageIcon.getIconWidth()) * 2);
		setX(x);
		
		y = rand.nextInt(gamePanel.background.imageIcon.getIconHeight() - gamePanel.guiFrame.getHeight() * 2) * (-1);
		setY(y);
		
		dy = 2;
	}

	@Override
	public void move() { 
		if(visible)
			y += dy;
	}

	public boolean isVisible() {
		return visible; 
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible; 
	}
}
