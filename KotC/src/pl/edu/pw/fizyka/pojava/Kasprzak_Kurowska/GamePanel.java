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
		backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		balloon = new Balloon(guiFrame);
	    
	}
		
	public void doOneLoop() {
		this.balloon.move();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		yPos = guiFrame.getHeight() - balloon.imageIcon.getIconHeight() - 50;
	    g.drawImage(backgroundImage.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, backgroundImage.getIconHeight()-guiFrame.getHeight(), backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), null);
	    if(isGameRunning) {
			g.drawImage(balloon.getImage(), balloon.getX(), yPos, this); 
		} else {
			timer.stop();
		}
	}
}