package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Image;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Treasures extends Sprite {

	GuiFrame guiFrame; 
	boolean visible; 
	public ImageIcon imageIcon;
	public int treasureX, treasureY; 
	Random rand = new Random();
	
	public Treasures(GuiFrame gui) {
		guiFrame = gui; 
		initialize();
	}
	
	private void initialize() {
		imageIcon = new ImageIcon(getClass().getResource("others/punkty_.png")); 
		setImage(imageIcon.getImage()); 
		for (int i = 0; i < 7; i++) {
			x = rand.nextInt((guiFrame.getWidth() - imageIcon.getIconWidth()));
			setX(x);
		}
		
	}

	@Override
	public void move() { 
		
	}

	public boolean isVisible() {
		return visible; 
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible; 
	}
}
