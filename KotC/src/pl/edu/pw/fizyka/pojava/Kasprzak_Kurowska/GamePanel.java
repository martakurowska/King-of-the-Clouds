package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener {
	
	JPanel gamePanel;
	GridBagConstraints c;
	JLabel label;
	JButton yesButton, noButton;
	ImageIcon backgroundImage, balloonImage; 
	GuiFrame guiFrame;
	CharacterPanel characterPanel;
	Balloon balloon; 
	DifficultyFrame difficultyFrame; 
	GameLoop gameLoop; 
	Timer timer; 
	//ArrayList<Planes> planes; 
	//ArrayList<Gold> gold;
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		balloon = new Balloon(guiFrame);
	    addKeyListener(new GameEventListener(this));
	    setFocusable(true);
	   /* this.timer = new Timer(difficultyFrame.gameSpeed, new GameLoop(this));
	    timer.start(); */
		gamePanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		        g.drawImage(backgroundImage.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, backgroundImage.getIconHeight()-guiFrame.getHeight(), backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), null);
		        doDrawing(g);	        
		    }
		}; 
	}; 
		
	
		private void drawBalloon(Graphics g) {
			g.drawImage(balloon.getImage(), balloon.getX(), balloon.getY(), this); 
					
		}
		
		private void doDrawing(Graphics g) {
			drawBalloon(g); 
		}
		
		public void doOneLoop() {
			update();
			repaint();
		}
		
		private void update() {
			this.balloon.move();
		}
		
		@Override 
		public void keyReleased (KeyEvent e) {
			this.balloon.keyReleased(e);
		}
		
		@Override
		public void keyPressed (KeyEvent e) {
			this.balloon.keyPressed(e);
		}  
		
		public JPanel setUpGamePanel() {
			return gamePanel;
		}

		@Override
		public void keyTyped(KeyEvent e) {
		
			
		}
		
	}