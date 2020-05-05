package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;


import java.util.Random;
import javax.swing.ImageIcon;

public class Planes extends Sprite {
	
	GamePanel gamePanel;
	public ImageIcon imageIcon;
	int number;
	Random rand = new Random();
	private boolean visible = true; 	 
	
	public Planes(GamePanel game) {
		gamePanel = game; 
		initialize();
	}


	public void initialize() {
		
		number = rand.nextInt(4);
		if (number==0) 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane1.png"));
		else if (number==1) 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane2.png")); 
		else if (number==2) 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane3.png")); 
		else if (number==3) 
				imageIcon = new ImageIcon(getClass().getResource("others/plane/plane4.png")); 
		
		setImage(imageIcon.getImage()); 
		
		x = rand.nextInt((int) (1.5 * gamePanel.guiFrame.getWidth() - imageIcon.getIconWidth())); 
		setX(x); 
	    
		y = rand.nextInt((int) (2.2 * gamePanel.background.imageIcon.getIconHeight())) * (-1);
		setY(y);
		
		dy = 5;
	
	}
		
	@Override
	public void move() {		
		if(visible) 
			y += dy; 
	}
	
	public boolean isVisible() {
		return visible; 
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible; 
	}

	
}
