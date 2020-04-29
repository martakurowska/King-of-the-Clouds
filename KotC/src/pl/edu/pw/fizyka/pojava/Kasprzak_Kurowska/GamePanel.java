package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
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
	String balloonPath;
	boolean[] keys; 
	int dx; 
	TimerTask timerTask; 
	Timer timer; 
	int balloonSpeed;
	//ArrayList<Planes> planes; 
	//ArrayList<Gold> gold;
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		balloon = new Balloon(guiFrame);
	    keys = new boolean[] {false, false}; //[0] - czy porusza siê lewo  [1]- czy porusza siê w prawo
	    balloonSpeed = 10; 
	      
		gamePanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		        g.drawImage(backgroundImage.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, backgroundImage.getIconHeight()-guiFrame.getHeight(), backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), null);
		        doDrawing(g);
		    }

		}; 
			 
	     addKeyListener(new GameEventListener(this));
	     setFocusable(true);
	     
	}; 
			
		private void drawBalloon(Graphics g) {
			g.drawImage(balloon.getImage(), balloon.getX(), balloon.getY(), this); 
					
		}
		
		private void doDrawing(Graphics g) {
			drawBalloon(g); 
		}
		
		private void moveBalloon() {
			dx += 2; 
		}
		
		@Override 
		public void keyReleased (KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				keys[0] = false; 
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				keys[1] = false; 
			}
		}
		
		@Override
		public void keyPressed (KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
				keys[0] = true; 
				//balloon.x -= balloon.dx;
			} 
			if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
				keys[1] = true; 
			}	
		}  
		
		@Override
		public void keyTyped(KeyEvent e) {
		}
		
		public JPanel setUpGamePanel() {
			return gamePanel;
		}
		
	}