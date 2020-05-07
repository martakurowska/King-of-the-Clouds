package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Marta Kurowska
public class MenuPanel extends JPanel{
	
	MenuScreenHandler msHandler = new MenuScreenHandler();
	GuiFrame guiFrame;
	Font defaultFont = new Font("Impact", Font.PLAIN, 34);   								
	Color colorOfButton = new Color(225,108,164);		
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, saveBtn;
	ImageIcon menuImage, points, livesIcon;
	GridBagConstraints constraints;
	//domyslnie gracz ma 0 pkt i 3 zycia
	int score = 0, lives = 3;
	
	public void setButton(JButton btn) {
		btn.setFont(defaultFont);
        btn.setBackground(colorOfButton); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.addActionListener(msHandler);
        this.add(btn, constraints);
	}
	
	public MenuPanel(GuiFrame gui) {
			
        guiFrame = gui;
		this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = 150;
        constraints.ipady = 15;
        constraints.insets = new Insets(160, 0, 0, 0);

        constraints.gridx = 0;    
        constraints.gridy = 0;
    	defaultFont = new Font("Impact", Font.PLAIN, 34);   								
		colorOfButton = new Color(225,108,164);											
        newGameBtn = new JButton(guiFrame.languageBundle.getString("newgame"));
        setButton(newGameBtn);
        newGameBtn.setActionCommand("newgame");

        constraints.gridy = 1;
        constraints.insets = new Insets(15, 0, 0, 0);
        loadGameBtn = new JButton(guiFrame.languageBundle.getString("loadgame"));
        setButton(loadGameBtn);
        loadGameBtn.setActionCommand("loadgame");

        constraints.gridy = 2;
        saveBtn = new JButton(guiFrame.languageBundle.getString("savegame"));
        setButton(saveBtn);
        saveBtn.setActionCommand("savegame");

        constraints.gridy = 3;
        settingsBtn = new JButton(guiFrame.languageBundle.getString("settings"));
        setButton(settingsBtn);
        settingsBtn.setActionCommand("settings");
        
        constraints.gridy = 4;
        exitGameBtn = new JButton(guiFrame.languageBundle.getString("exit"));
        setButton(exitGameBtn);
        exitGameBtn.setActionCommand("exitgame");
		
	}

	@Override
	public void paintComponent(Graphics g) {
		//drukowanie tla, ilosci punktow i zyc
		super.paintComponent(g);
		menuImage = new ImageIcon(getClass().getResource("others/menu2.png"));
		g.drawImage(menuImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		
		points = new ImageIcon(getClass().getResource("others/point.png"));
		g.drawImage(points.getImage(), 5, 5, this);	
		g.setColor(new Color(253,191,0));
		g.setFont(guiFrame.menuPanel.defaultFont);
		g.drawString(String.valueOf(score) , 64, 45);
		
		if(lives == 3) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		}
		else if(lives == 2) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/2lives.png")); 
		}
		else if(lives == 1) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/1lives.png")); 
		}
		g.drawImage(livesIcon.getImage(), guiFrame.getWidth() - 197, 5, this);
		
		//jesli gracz jest nowy lub stracil wszystkie punkty to ustawiany jest poziom easy
		if(score == 0) {
			guiFrame.settingsPanel.difficultyPanel.speed = 12;
			
		}
		
		repaint();
	}
	
	public class MenuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
	        	MenuPanel.this.setVisible(false);
	        	guiFrame.gamePanel = new GamePanel(guiFrame);
	        	guiFrame.container.add(guiFrame.gamePanel);
	        	guiFrame.gamePanel.setVisible(true);
	        	guiFrame.isGameActive = true;   	
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	
	        } 
	        else if (e.getActionCommand() == "savegame") {
	        		
	        } 
	        else if (e.getActionCommand() == "settings") {
	        	MenuPanel.this.setVisible(false);
	        	guiFrame.container.add(guiFrame.settingsPanel);
	        	guiFrame.settingsPanel.setVisible(true);
	        	guiFrame.settingsPanel.add(guiFrame.settingsPanel.characterPanel, BorderLayout.CENTER);
	        	guiFrame.settingsPanel.characterPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "exitgame") {
	            System.exit(0);
	        } 
		}
	}
}