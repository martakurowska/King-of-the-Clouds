package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

//Marta Kurowska, Wiktoria Kasprzak
public class Score extends Sprite {
	//klasa odpowiadajaca za wysietlanie ilosci punktow w lewym gornym rogu podczas gry
	GamePanel gamePanel; 
	ImageIcon imageIcon; 
	int score; 
	
	public Score(GamePanel game) {
		gamePanel = game; 
		//ustawianie wygladu ikonki punktow
		imageIcon = new ImageIcon(getClass().getResource("others/points/1.png")); 
		setImage(imageIcon.getImage());
		//pobieranie informacji o ilosci punktow
		score = gamePanel.guiFrame.menuPanel.score; 
		//ustawianie polozenia
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
