package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel {
	
	JPanel gamePanel;
	GridBagConstraints c;
	JLabel label;
	JButton yesButton, noButton;
	ImageIcon backgroundImage, balloonImage; 
	GuiFrame guiFrame;
	CharacterPanel characterPanel;
	Balloon balloon; 
	Planes plane; 
	Background background;
	String balloonPath;
	Treasures treasure; 
	boolean isGameRunning = true;
	boolean[] keys; 
	int yPos, dx, xPos; 
	Timer timer; 
	private List<Planes> planes;
	private List<Treasures> treasures; 
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		timer = new Timer(10, new GameLoop(this));
		timer.start();
		balloon = new Balloon(guiFrame);
		background = new Background(guiFrame);
		plane = new Planes(guiFrame); 
		treasure = new Treasures(guiFrame); 
		Random rand = new Random();
		
   		 planes = new ArrayList<>();
	        for (int i = 0; i < 4; i++) {
	        	Planes singlePlane = new Planes(gui);
	            int xPos = rand.nextInt(guiFrame.getWidth()); 
	            singlePlane.setX(xPos);
	            planes.add(singlePlane); 	}
	        
	                 
		 treasures = new ArrayList<>();
        	for (int i = 0; i < 6; i++) {
        	Treasures singleTreasure = new Treasures(gui); 
            	int xPos = rand.nextInt(guiFrame.getWidth());
            	int yPos = rand.nextInt(guiFrame.getHeight() - singleTreasure.imageIcon.getIconHeight());
            	singleTreasure.setX(xPos);
            	singleTreasure.setY(yPos);
            	treasures.add(singleTreasure); 	
           }
            
} 	 
		
	public void doOneLoop() {
		this.balloon.move();
		this.background.move();
		for (int i = 0; i < 4; i++) {this.planes.get(i).move();}
		for (int j = 0; j < 6; j++) {this.treasures.get(j).move();}
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		yPos = guiFrame.getHeight() - balloon.imageIcon.getIconHeight() - 50;
		xPos = guiFrame.getWidth() - plane.imageIcon.getIconWidth() - 430; 
	    g.drawImage(background.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0,
	    		background.getBcgrndYTop(), background.imageIcon.getIconWidth(), background.getBcgrndYBottom(), null);
	    if(isGameRunning) {
			g.drawImage(balloon.getImage(), balloon.getX(), yPos, this); 
			 for (int i = 0; i < 4; i++) {
			g.drawImage(planes.get(i).getImage(), planes.get(i).getX(), 
					planes.get(i).getPlaneYTop(), this); 
			 }
			 for (int j = 0; j < 6; j++) {
			g.drawImage(treasures.get(j).getImage(), treasures.get(j).getX(), 
					treasures.get(j).getY(), this); }
		} 
			 else {
			timer.stop();
		}
	}
}