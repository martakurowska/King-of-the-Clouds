package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;


import java.util.Random;
import javax.swing.ImageIcon;

public class Planes extends Sprite {
	
	GuiFrame guiFrame;
	public ImageIcon imageIcon;
	int number;
	int planeYTop, planeYBottom, planeX;
	Random rand = new Random();
	private boolean visible = true; 	 
	public static final int speedPlane = 10;
	public static final int planeRows = 4; 
	public static final int planeColumns = 8;
	
	
	public Planes(GuiFrame gui) {
			guiFrame = gui; 
			initialize();
	}


	public void initialize() {
		
		number = rand.nextInt(4);
		if (number==0) {
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane1.png"));
				setImage(imageIcon.getImage()); }
		else if (number==1) { 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane2.png")); 
				setImage(imageIcon.getImage()); }
		else if (number==2) {
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane3.png")); 
				setImage(imageIcon.getImage()); }
		else if (number==3) { 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane4.png")); 
				setImage(imageIcon.getImage()); 
		}
		
		planeX = rand.nextInt(guiFrame.getWidth() - imageIcon.getIconWidth()); 
		setX(planeX); 
	    planeYTop = rand.nextInt(guiFrame.getHeight() - imageIcon.getIconHeight());
		setY(planeYTop);
		dy = 5;
	
	}
		
	@Override
	public void move() {		
	
		planeYTop += dy; 
		
	}
	
	public boolean isVisible() {
		return visible; 
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible; 
	}

	
}
