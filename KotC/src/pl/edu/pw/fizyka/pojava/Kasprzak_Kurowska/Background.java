package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

//Marta Kurowska
public class Background extends Sprite {
	
	GuiFrame guiFrame; 
	ImageIcon imageIcon;
	int startYTop, startYBottom;
	boolean end = false;
	
	public Background(GuiFrame gui) {
		guiFrame = gui;
		initialize();
	}

	private void initialize() {
		//ustawianie przewijajacego sie t³a gry 
		imageIcon = new ImageIcon(getClass().getResource("others/tlo.png"));
		setImage(imageIcon.getImage());
		
		//yTop i yBottom okreslaja jak¹ czesc tla gry widzimy, odpowiadaja one wysokosciom: lewego gornego rogu widzianej czesci tla oraz prawego dolnego rogu
		
		startYTop = imageIcon.getIconHeight() - guiFrame.getHeight(); 
		setBcgrndYTop(startYTop);
		startYBottom = imageIcon.getIconHeight();
		setBcgrndYBottom(startYBottom);
		
		//predkosc przewijania sie tla
		dy = 1.5;
	}
	
	@Override
	public void move() {
		
		//Jesli lewy gorny rog osiagnie wysokosc 10, to tlo przestaje sie poruszac i zostaje na wysokosci 10
		//boolean end jest uzywany do konczenia gry, zatem jesli end == true to nastepuje koniec gry
		//jesli koniec nie zostal osiagniety tlo przesuwa sie 
		if(bcgrndYTop <= 10) {
			bcgrndYTop = 10;
			bcgrndYBottom = guiFrame.getHeight();
			end = true;
		} else {
			bcgrndYTop -= dy;
			bcgrndYBottom -= dy;
		}
	}
}
