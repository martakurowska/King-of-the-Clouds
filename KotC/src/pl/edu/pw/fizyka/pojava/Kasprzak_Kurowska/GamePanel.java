package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
	
	GridBagConstraints c;
	GuiFrame guiFrame;
	Balloon balloon;  
	Background background;
	boolean isGameRunning = true;
	JButton goOut; 
	int yPos;
	Timer timer; 
	private ArrayList<Planes> planes;
	private ArrayList<Points> points; 
	Score point; 
	Lives life; 
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
		point = new Score(this);
		life = new Lives(this); 
	
		goOut = new JButton("OK");
		goOut.setFont(guiFrame.menuPanel.defaultFont);
        goOut.setBackground(new Color(237,28,36)); 
        goOut.setForeground(Color.BLACK);
        goOut.setFocusPainted(false);
        goOut.addActionListener(this);
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 0, 0, 0);
        this.add(goOut, c); 
        goOut.setVisible(false);
	} 	 
		
	public void doOneLoop() {
		
		
		if(this.isGameRunning) {
			
			this.balloon.move();
			this.background.move();
			this.life.move();
			
			for(Planes p : planes) {
				if(p.isDead()) 
					continue;
				if(!p.isDead()) {
					if(p.getX() + p.imageIcon.getIconWidth() >= balloon.getX() && p.getX() <= balloon.getX() + balloon.imageIcon.getIconWidth() && p.getY() + p.imageIcon.getIconHeight() >= balloon.getY() && p.getY() <= balloon.getY() + balloon.imageIcon.getIconHeight()) {
						p.setVisible(false);
						p.die();
						balloon.lives -= 1;			 
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
						balloon.points += 20; 
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
		
	    g.drawImage(background.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0,
	    		background.getBcgrndYTop(), background.imageIcon.getIconWidth(), background.getBcgrndYBottom(), null);
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
		g.drawImage(point.getImage(), point.getX(), point.getY(), this);	
		g.setColor(new Color(253,191,0));
		g.setFont(guiFrame.menuPanel.defaultFont);
		g.drawString(balloon.getPoints(), 64, 45);
		g.drawImage(life.getImage(), life.getX(), life.getY(), this);	
		if(balloon.lives==0) {
			g.setColor(new Color(237,28,36));
			Font defaultFont = new Font("Impact", Font.PLAIN, 120);  
			g.setFont(defaultFont); 
			FontMetrics fontMetrics = this.getFontMetrics(defaultFont);
			String gameOver = "GAME OVER"; 
			g.drawString(gameOver, guiFrame.getWidth()/2-fontMetrics.stringWidth(gameOver)/2 - 6,
					guiFrame.getHeight()/2 - 60); 
			goOut.setVisible(true);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		GamePanel.this.setVisible(false);
		guiFrame.container.remove(guiFrame.menuPanel); 
    	guiFrame.container.add(guiFrame.menuPanel);
    	guiFrame.menuPanel.setVisible(true);
    	guiFrame.container.remove(guiFrame.gamePanel);
		this.timer.stop();
	}
}