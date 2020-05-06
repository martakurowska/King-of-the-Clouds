package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Score extends Sprite {

	GamePanel gamePanel; 
	ImageIcon imageIcon; 
	int score; 
	
	public Score(GamePanel game) {
		gamePanel = game; 
		imageIcon = new ImageIcon(getClass().getResource("others/point.png")); 
		setImage(imageIcon.getImage());
		score = gamePanel.guiFrame.menuPanel.score; 
		x = 5;
		setX(x); 
		y = 5; 
		setY(y);
	}	
	
	public String getPoints() {
		return String.valueOf(score); 
	}
	
	@Override
	public void move() {	
	}
	
}
