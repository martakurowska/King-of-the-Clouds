package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Lives extends Sprite {

	GamePanel gamePanel; 
	GuiFrame guiFrame;
	ImageIcon imageIcon; 
	
	public Lives(GamePanel game) {
		gamePanel = game; 	
		imageIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		setImage(imageIcon.getImage());
		y = 5; 
		setY(y); 
	}
	
	@Override
	public void move() {
		x = gamePanel.guiFrame.getWidth() - 187;
		setX(x); 
		if (gamePanel.balloon.lives == 3) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		}
		else if (gamePanel.balloon.lives == 2) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/2lives.png")); 
		}
		else if (gamePanel.balloon.lives == 1) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/1lives.png")); 
		}
		else if (gamePanel.balloon.lives == 0) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/0lives.png")); 
			gamePanel.timer.stop();
		}
		setImage(imageIcon.getImage()); 

	}

}
