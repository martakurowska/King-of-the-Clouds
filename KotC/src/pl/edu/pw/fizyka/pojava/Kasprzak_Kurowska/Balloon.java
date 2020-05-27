package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

//Wiktoria Kasprzak: konstruktor klasy, metoda initialize(), Marta Kurowska: metoda move()
public class Balloon extends Sprite {

	GuiFrame guiFrame; 
	int balloonStartX, balloonStartY, lives;
	ImageIcon imageIcon;
	
	public Balloon(GuiFrame gui) {
		guiFrame = gui;
		initialize();
	}
	
	private void initialize() {
		//ustawianie wygladu balonika
		imageIcon = guiFrame.balloonImage; 
		setImage(imageIcon.getImage()); 
		
		//ustawianie pozycji poczatkowej balonika
		balloonStartX = (guiFrame.getWidth() / 2 - imageIcon.getIconWidth() / 2); 
		setX(balloonStartX); 
		
		//ustawianie zyc balonika
		lives = guiFrame.menuPanel.lives;
	}
	
	@Override
	public void move() {
		x += dx;
		
		//ograniczenia poruszania sie balonika, aby nie mogl wyjsc poza okienko
		if(x < 0) {
			x = 0;
		}
		if(x > guiFrame.getWidth() - imageIcon.getIconWidth() - 15) {
			x = guiFrame.getWidth() - imageIcon.getIconWidth() - 15;
		}
		
		//niezaleznie od wielkosci okna, balonik zawsze bedzie drukowany na dole
		balloonStartY = (guiFrame.getHeight() - imageIcon.getIconHeight() - 50);
		setY(balloonStartY);
	}
}
