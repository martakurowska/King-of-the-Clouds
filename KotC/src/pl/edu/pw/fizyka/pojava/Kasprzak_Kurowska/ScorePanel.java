package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class ScorePanel extends JPanel {

	GamePanel gamePanel; 
	
	public ScorePanel(GamePanel game) {
		
		gamePanel = game; 
		this.setLayout(new GridBagLayout());
	//	this.setSize(new Dimension(gamePanel.guiFrame.getWidth(), 60));
	//	this.setOpaque(false);
	}
}