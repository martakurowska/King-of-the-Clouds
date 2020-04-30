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

public class MenuPanel extends JPanel{
	
	menuScreenHandler msHandler = new menuScreenHandler();
	GuiFrame guiFrame;
	Font defaultFont = new Font("Impact", Font.PLAIN, 34);   								
	Color colorOfButton = new Color(225,108,164);		
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, levelChangeBtn;
	ImageIcon menuImage;
	
	public void setButton(JButton btn) {
		btn.setFont(defaultFont);
        btn.setBackground(colorOfButton); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
	}
	
	public MenuPanel(GuiFrame gui) {
			
        guiFrame = gui;
		this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 150;
        c.ipady = 15;
        c.insets = new Insets(15, 0, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        JLabel lbl1 = new JLabel("");
        lbl1.setPreferredSize(new Dimension(10,140));
        this.add(lbl1, c);
        
        c.gridy = 1;
    	defaultFont = new Font("Impact", Font.PLAIN, 34);   								
		colorOfButton = new Color(225,108,164);											
        newGameBtn = new JButton(guiFrame.languageBundle.getString("newgame"));
        setButton(newGameBtn);
        newGameBtn.setActionCommand("newgame");
        newGameBtn.addActionListener(msHandler);
        this.add(newGameBtn, c);

        c.gridy = 2;
        loadGameBtn = new JButton(guiFrame.languageBundle.getString("loadgame"));
        setButton(loadGameBtn);
        loadGameBtn.setActionCommand("loadgame");
        loadGameBtn.addActionListener(msHandler);
        this.add(loadGameBtn, c);

        c.gridy = 3;
        levelChangeBtn = new JButton(guiFrame.languageBundle.getString("levelChange"));
        setButton(levelChangeBtn);
        levelChangeBtn.setActionCommand("difficulty");
        levelChangeBtn.addActionListener(msHandler);
        this.add(levelChangeBtn, c);

        c.gridy = 4;
        settingsBtn = new JButton(guiFrame.languageBundle.getString("settings"));
        setButton(settingsBtn);
        settingsBtn.setActionCommand("settings");
        settingsBtn.addActionListener(msHandler);
        this.add(settingsBtn, c);
        
        c.gridy = 5;
        exitGameBtn = new JButton(guiFrame.languageBundle.getString("exit"));
        setButton(exitGameBtn);
        exitGameBtn.setActionCommand("exitgame");
        exitGameBtn.addActionListener(msHandler);
        this.add(exitGameBtn, c);
		
	}

	@Override
	public void paintComponent(Graphics G) {
		super.paintComponent(G);
		menuImage = new ImageIcon(getClass().getResource("others/menu2.png"));
		G.drawImage(menuImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		repaint();
	}
	
	public class menuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
				guiFrame.settingsPanel.setVisible(false);
	        	MenuPanel.this.setVisible(false);
	        	guiFrame.gamePanel = new GamePanel(guiFrame);
	        	guiFrame.container.add(guiFrame.gamePanel);
	        	guiFrame.gamePanel.setVisible(true);
	        	guiFrame.isGameActive = true;   	
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	
	        } 
	        else if (e.getActionCommand() == "difficulty") {
	        	guiFrame.difficultyFrame.setVisible(true);
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