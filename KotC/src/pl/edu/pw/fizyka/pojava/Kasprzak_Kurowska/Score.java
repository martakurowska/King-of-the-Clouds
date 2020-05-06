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
		score = 0; 
		x = 5;
		setX(x); 
		y = 5; 
		setY(y);
	}	
	
	@Override
	public void move() {	
	}

}
