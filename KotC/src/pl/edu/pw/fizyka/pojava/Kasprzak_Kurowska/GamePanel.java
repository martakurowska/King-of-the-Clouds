package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	
	JPanel gamePanel;
	GridBagConstraints c;
	JLabel label;
	ImageIcon backgroundImage, balloonImage; 
	GuiFrame guiFrame;
	CharacterPanel characterPanel;
	Balloon balloon;  
	Background background;
	boolean isGameRunning = true;
	int yPos;
	Timer timer; 
	private List<Planes> planes;
	private List<Points> points; 
	Random rand = new Random();
	
	public GamePanel(GuiFrame gui) {
	
		guiFrame = gui;

		timer = new Timer(10, new GameLoop(this));
		timer.start();
		balloon = new Balloon(guiFrame);
		background = new Background(guiFrame);

   		planes = new ArrayList<>();
	    for (int i = 0; i < 70; i++) {
	    	Planes singlePlane = new Planes(this);
            planes.add(singlePlane); 	
	    }
	                 
		points = new ArrayList<>();
		for (int i = 0; i < 35; i++) {
			Points singlePoint = new Points(this); 
        	points.add(singlePoint); 	
		}
            
	} 	 
		
	public void doOneLoop() {
		
		if(this.isGameRunning) {
			
			this.balloon.move();
			this.background.move();
			
			for(Planes p : planes) {
				if(p.isDead()) 
					continue;
				if(!p.isDead()) {
					if(p.getX() + p.imageIcon.getIconWidth() >= balloon.getX() && p.getX() <= balloon.getX() + balloon.imageIcon.getIconWidth() && p.getY() + p.imageIcon.getIconHeight() >= balloon.getY() && p.getY() <= balloon.getY() + balloon.imageIcon.getIconHeight()) {
						p.setVisible(false);
						p.die();
					}	
					p.move();
				}
			}
			
			for(Points p : points) {
				if(p.isDead()) 
					continue;
				if(!p.isDead()) {
					if(p.getX() + p.imageIcon.getIconWidth() >= balloon.getX() && p.getX() <= balloon.getX() + balloon.imageIcon.getIconWidth() && p.getY() + p.imageIcon.getIconHeight() >= balloon.getY() && p.getY() <= balloon.getY() + balloon.imageIcon.getIconHeight()) {
						p.setVisible(false);
						p.die();
					}	
					p.move();
				}
			}
			
			repaint();
		}
		else {
			this.timer.stop();
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		yPos = guiFrame.getHeight() - balloon.imageIcon.getIconHeight() - 50;
		
	    g.drawImage(background.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, background.getBcgrndYTop(), background.imageIcon.getIconWidth(), background.getBcgrndYBottom(), null);
	   
	    for (Points p : points) {
	    	if(p.isVisible()) {
	    		g.drawImage(p.getImage(), p.getX(), p.getY(), this); 
	    	}
		}
	    
		g.drawImage(balloon.getImage(), balloon.getX(), yPos, this); 
	    
		for (Planes p : planes) {
			if(p.isVisible()) {
				g.drawImage(p.getImage(), p.getX(), p.getY(), this); 
			}
			
		}		
	}
}