package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

//Wiktoria Kasprzak, Marta Kurowska
public class Lives extends Sprite {

	GamePanel gamePanel; 
	GuiFrame guiFrame;
	ImageIcon imageIcon; 
	
	public Lives(GamePanel game) {
		gamePanel = game; 	
		imageIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		setImage(imageIcon.getImage());
		x = gamePanel.guiFrame.getWidth() - 197;
		setX(x);
		y = 5; 
		setY(y); 
	}
	
	@Override
	public void move() {
		//umieszczamy w prawym gornym rogu
		x = gamePanel.guiFrame.getWidth() - 197;
		setX(x); 
		
		//dostosowywanie obrazka do ilosci zyc gracza
		if(gamePanel.balloon.lives == 3) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		}
		else if(gamePanel.balloon.lives == 2) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/2lives.png")); 
		}
		else if(gamePanel.balloon.lives == 1) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/1lives.png")); 
		}
		else if(gamePanel.balloon.lives == 0) {
			imageIcon = new ImageIcon(getClass().getResource("others/hearts/0lives.png")); 
			gamePanel.timer.stop();
		}
		setImage(imageIcon.getImage()); 

	}

}
