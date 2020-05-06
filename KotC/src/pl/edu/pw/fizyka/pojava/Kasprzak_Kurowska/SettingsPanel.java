package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SettingsPanel extends JPanel{
	
	JPanel settingsPanelTop;
	JButton levelChangeBtn, soundButton, languageButton, characterButton, backToMenuButton, difficultyButton;
	ImageIcon settingsImage;
	settingsScreenHandler sSHandler = new settingsScreenHandler();
	JPanel languagePanel,  characterPanel, soundPanel;
	GuiFrame guiFrame;
	LanguagePanel lngPanel;
	CharacterPanel charPanel; 
	SoundPanel sound;
	DifficultyPanel difficultyPanel; 
	
	public void setButton(JButton btn) {
		btn.setFont(guiFrame.menuPanel.defaultFont);
        btn.setBackground(guiFrame.menuPanel.colorOfButton); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
	}
	
	public SettingsPanel(GuiFrame gui) {
		
		guiFrame = gui;
		this.setPreferredSize(new Dimension((int) (guiFrame.screenWidth*0.7),(int) (guiFrame.screenHeight*0.85)));
		this.setLayout(new BorderLayout());
		
		settingsPanelTop = new JPanel();
		settingsPanelTop.setOpaque(false);
		
		characterButton = new JButton(guiFrame.languageBundle.getString("character")); 
		setButton(characterButton);
		characterButton.setActionCommand("character");
		characterButton.addActionListener(sSHandler);
		settingsPanelTop.add(characterButton);

		difficultyButton = new JButton(guiFrame.languageBundle.getString("levelChange")); 
		setButton(difficultyButton); 
		difficultyButton.setActionCommand("difficulty"); 
		difficultyButton.addActionListener(sSHandler);
		settingsPanelTop.add(difficultyButton);
		
        languageButton = new JButton(guiFrame.languageBundle.getString("language"));
        setButton(languageButton);
        languageButton.setActionCommand("language");
        languageButton.addActionListener(sSHandler);
        settingsPanelTop.add(languageButton);

        soundButton = new JButton(guiFrame.languageBundle.getString("sound"));
        setButton(soundButton);
        soundButton.setActionCommand("sound");
        soundButton.addActionListener(sSHandler);
        settingsPanelTop.add(soundButton);

        backToMenuButton = new JButton(guiFrame.languageBundle.getString("backtomenu"));
        setButton(backToMenuButton);
        backToMenuButton.setActionCommand("backToMenu");
        backToMenuButton.addActionListener(sSHandler);
        settingsPanelTop.add(backToMenuButton);
        this.add(settingsPanelTop, BorderLayout.PAGE_START);

        charPanel = new CharacterPanel(this);
    	characterPanel = charPanel.setUpCharacter();
		
    	lngPanel = new LanguagePanel(guiFrame.menuPanel, this, guiFrame.difficultyFrame, guiFrame);
    	languagePanel = lngPanel.setUpLanguages();
    	    	
    	sound = new SoundPanel(this); 
    	soundPanel = sound.setUpSounds();	
    	
    	difficultyPanel = new DifficultyPanel(this); 
    	
	}
	
	public class settingsScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
	        if (e.getActionCommand() == "backToMenu") {
	        	SettingsPanel.this.setVisible(false);
	        	languagePanel.setVisible(false);
	        	soundPanel.setVisible(false);
	        	characterPanel.setVisible(false);
	        	difficultyPanel.setVisible(false);
	        	guiFrame.container.remove(guiFrame.menuPanel); 
	        	guiFrame.container.add(guiFrame.menuPanel);
	        	guiFrame.menuPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "language") {
	        	characterPanel.setVisible(false);
	        	soundPanel.setVisible(false);
	        	SettingsPanel.this.add(languagePanel, BorderLayout.CENTER);
	        	languagePanel.setVisible(true);
	        } 
	        else if (e.getActionCommand() == "sound") {
	        	languagePanel.setVisible(false);
	        	characterPanel.setVisible(false);
	        	SettingsPanel.this.add(soundPanel, BorderLayout.CENTER);
	        	soundPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "character") {
	        	soundPanel.setVisible(false);
	        	languagePanel.setVisible(false);
	        	characterPanel.setVisible(true);
	        } 
	        
	        else if (e.getActionCommand() == "difficulty") {
	        	soundPanel.setVisible(false);
	        	languagePanel.setVisible(false);
	        	characterPanel.setVisible(false);
	        	difficultyPanel.setVisible(true);
	        }
		}
	}
	
	@Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        settingsImage = new ImageIcon(getClass().getResource("others/settings.png"));
        G.drawImage(settingsImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        repaint();
    }
}