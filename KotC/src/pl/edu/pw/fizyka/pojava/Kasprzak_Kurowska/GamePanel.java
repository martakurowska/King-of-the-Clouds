package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel {
	
	JPanel gamePanel;
	GridBagConstraints c;
	JLabel label;
	JButton yesButton, noButton;
	ImageIcon backgroundImage, balloonImage; 
	GuiFrame guiFrame;
	CharacterPanel characterPanel;
	
	public GamePanel(GuiFrame gui) {
		guiFrame = gui;
		gamePanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        backgroundImage = new ImageIcon(getClass().getResource("others/tlo.png"));
		        G.drawImage(backgroundImage.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, backgroundImage.getIconHeight()-guiFrame.getHeight(), backgroundImage.getIconWidth(), backgroundImage.getIconHeight(), null);
		        balloonImage = guiFrame.balloonImage;
		        G.drawImage(balloonImage.getImage(), (guiFrame.getWidth()/2-balloonImage.getIconWidth()/2), (guiFrame.getHeight()-(guiFrame.getHeight()/3)), null);
		    }
		}; 
	}
	
	public JPanel setUpGamePanel() {
		return gamePanel;
	}
	
}