package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
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
	Background background;
	String balloonPath;
	boolean isGameRunning = true;
	boolean[] keys; 
	int yPos, dx; 
	//TimerTask timerTask; 
	Timer timer; 
	int balloonSpeed;
	//ArrayList<Planes> planes; 
	//ArrayList<Gold> gold;
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		timer = new Timer(10, new GameLoop(this));
		timer.start();
		//backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		balloon = new Balloon(guiFrame);
		background = new Background(guiFrame);
	    
	}
		
	public void doOneLoop() {
		this.balloon.move();
		this.background.move();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		yPos = guiFrame.getHeight() - balloon.imageIcon.getIconHeight() - 50;
	    g.drawImage(background.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, background.getBcgrndYTop(), background.imageIcon.getIconWidth(), background.getBcgrndYBottom(), null);
	    if(isGameRunning) {
			g.drawImage(balloon.getImage(), balloon.getX(), yPos, this); 
		} else {
			timer.stop();
		}
	}
}