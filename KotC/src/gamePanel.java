import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gamePanel {
	
	JPanel gamePanel;
	GridBagConstraints c;
	JLabel label;
	JButton yes, no;
	ImageIcon img, balloon;
	guiFrame guiFrame;
	characterPanel character;
	
	public gamePanel(guiFrame gui) {
		guiFrame = gui;
		gamePanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        img = new ImageIcon(getClass().getResource("others/tlo.png"));
		        G.drawImage(img.getImage(), 0, 0, guiFrame.getWidth(), guiFrame.getHeight(), 0, img.getIconHeight()-guiFrame.getHeight(), img.getIconWidth(), img.getIconHeight(), null);
		        balloon = guiFrame.balloon;
		        G.drawImage(balloon.getImage(), guiFrame.getHeight()/2, (guiFrame.getHeight()-(guiFrame.getHeight()/3)), null);
		    }
		}; 
	}
	
	public JPanel setUpGamePanel() {
		return gamePanel;
	}
	
}
