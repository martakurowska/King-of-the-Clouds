package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//Wiktoria Kasprzak: cala klasa z wyj¹tkiem paintComponent(), Marta Kurowska: metoda paintComponent()
public class DifficultyPanel extends JPanel implements ActionListener {

	SettingsPanel settingsPanel; 
	Planes plane; 
	int speed, speedPlane; 
	JButton hardButton, normalButton, easyButton, points500, points1000; 
	GridBagConstraints constraints;
	String normalString = "500p", hardString = "1000p";
	Font defaultButtonFont = new Font("Impact", Font.PLAIN, 60);  
	Font defaultLabelFont = new Font("Impact", Font.PLAIN, 30);  
	
	//metoda ustawiaj¹ca wygl¹d przycisków
    public void setButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setForeground(Color.BLACK);
		btn.setFont(defaultButtonFont);
		btn.addActionListener(this);
		this.add(btn, constraints);
	}  
    
    public void setPointsButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		btn.setForeground(Color.BLACK);
		btn.setFont(defaultButtonFont);
		this.add(btn, constraints);
	}  
    
	public DifficultyPanel(SettingsPanel settings) {
		
		settingsPanel = settings;  

		this.setOpaque(false);
		this.setLayout(new GridBagLayout());   
    	constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = 90; 
        constraints.ipady = 30;
        constraints.insets = new Insets(35, 0, 70, 0);

        constraints.gridx = 0;
        constraints.gridy = 0; 
        easyButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("easy")); 
        setButton(easyButton); 
        
        constraints.gridx = 0; 
        constraints.gridy = 1; 
        constraints.insets = new Insets(0, 0, 0, 0);
        normalButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("normal")); 
        setButton(normalButton); 
        
        constraints.gridx = 0;
        constraints.gridy = 3;
        hardButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("hard")); 
        setButton(hardButton); 

        constraints.gridx = 0; 
        constraints.gridy = 2; 
        points500 = new JButton("500p");
        setPointsButton(points500);
        points500.setFont(defaultLabelFont);
        
        constraints.gridx = 0; 
        constraints.gridy = 4; 
        points1000 = new JButton("1000p");
        setPointsButton(points1000);
        points1000.setFont(defaultLabelFont);
        
        speed = 12; 
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		//Przycisk easy jest zawsze dostepny
		if(settingsPanel.guiFrame.menuPanel.score >= 0) {
			easyButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
			easyButton.setActionCommand("easy");
		}
		
		//Przyciski normal i hard sa dostêpne po uzyskaniu 500/100 punktow, jesli gracz straci wszystkie zycia, a zatem tez punkty, to przyciski znowu staja sie niedostepne
		if(settingsPanel.guiFrame.menuPanel.score >= 500) {
			normalButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
			normalButton.setBorderPainted(true);
			normalButton.setActionCommand("normal");
		}
		else {
			normalButton.setBackground(new Color(193, 193, 193));
			normalButton.setBorderPainted(false);
			normalButton.setActionCommand("");
		}
		
		if(settingsPanel.guiFrame.menuPanel.score >= 1000) {
			hardButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
			hardButton.setBorderPainted(true);
			hardButton.setActionCommand("hard");
		}
		else {
			hardButton.setBackground(new Color(193, 193, 193));
			hardButton.setBorderPainted(false);
			hardButton.setActionCommand("");
		}
	}
	
	//okreslanie predkosci balonika
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "easy") {
			speed = 12;	

		} else if(e.getActionCommand() == "normal") {
			speed = 8;
	
		} else if(e.getActionCommand() == "hard") {
			speed = 5;
		}
	}
}
