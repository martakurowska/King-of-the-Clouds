package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer; 

public class GamePanel extends JPanel implements KeyListener {
	
	JPanel gamePanel;
	JLabel label;
	JButton yesButton, noButton;
	ImageIcon backgroundImage, balloonImage; 
	GuiFrame guiFrame;
	CharacterPanel characterPanel;
	Balloon balloon; 
	DifficultyFrame difficultyFrame; 
	GameLoop gameLoop; 
	Timer timer; 
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		balloon = new Balloon(guiFrame);
		this.timer = new Timer(DifficultyFrame.gameSpeed, new GameLoop(this));
		this.timer.start(); 
		
		gamePanel = new JPanel() {
			//@Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		        g.drawImage(backgroundImage.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, backgroundImage.getIconHeight()-guiFrame.getHeight(),
		              backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), null); 	
		        doDrawing(g);
		    	System.out.println("repaint");
		    }
		}; 
			gamePanel.addKeyListener(new GameEventListener(this));
			gamePanel.setFocusable(true);
	}; 
		
		private void drawBalloon(Graphics g) {
			g.drawImage(balloon.getImage(), balloon.getX(), balloon.getY(), this); 		
		}
		
		private void doDrawing(Graphics g) {
			drawBalloon(g); 	
		} 
		
		public void doOneLoop() {
			repaint();
			update();	
		}
		
		private void update() {
			System.out.println("update"); 
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