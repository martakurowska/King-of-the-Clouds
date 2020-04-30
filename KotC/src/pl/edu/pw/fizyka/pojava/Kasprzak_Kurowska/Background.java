package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import javax.swing.ImageIcon;

public class Background extends Sprite {
	
	GuiFrame guiFrame; 
	ImageIcon imageIcon;
	int startYTop, startYBottom;
	
	public Background(GuiFrame gui) {
		guiFrame = gui;
		initialize();
	}

	private void initialize() {
		imageIcon = new ImageIcon(getClass().getResource("others/tlo.png"));
		setImage(imageIcon.getImage());
		
		startYTop = imageIcon.getIconHeight()-guiFrame.getHeight();
		setBcgrndYTop(startYTop);
		startYBottom = imageIcon.getIconHeight();
		setBcgrndYBottom(startYBottom);
		
		dy = 3;
	}
	
	@Override
	public void move() {
		
		if (bcgrndYTop <= 10) {
			bcgrndYTop = 10;
			bcgrndYBottom = guiFrame.getHeight();
		}
		
		bcgrndYTop -= dy;
		bcgrndYBottom -= dy;
		
	}
}
