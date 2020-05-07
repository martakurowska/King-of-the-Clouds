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
	JButton hardButton, normalButton, easyButton; 
	String normalString = "500p", hardString = "1000p";
	Font defaultButtonFont = new Font("Impact", Font.PLAIN, 60);  
	Font defaultLabelFont = new Font("Impact", Font.PLAIN, 30);  
	
    public void setButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setForeground(Color.BLACK);
		btn.setFont(defaultButtonFont);
		btn.addActionListener(this);
	}  
    
	public DifficultyPanel(SettingsPanel settings) {
		
		settingsPanel = settings;  

		this.setOpaque(false);
		this.setLayout(new GridBagLayout());   
    	GridBagConstraints costraints = new GridBagConstraints();
        costraints.fill = GridBagConstraints.HORIZONTAL;
        costraints.ipadx = 90; 
        costraints.ipady = 30;
        costraints.insets = new Insets(35, 0, 35, 0);

        costraints.gridx = 0;
        costraints.gridy = 0; 
        easyButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("easy")); 
        setButton(easyButton); 
        this.add(easyButton, costraints);
        
        costraints.gridx = 0; 
        costraints.gridy = 1; 
        normalButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("normal")); 
        setButton(normalButton); 
        this.add(normalButton, costraints); 
        
        costraints.gridx = 0; 
        costraints.gridy = 3; 
        hardButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("hard")); 
        setButton(hardButton); 
        hardButton.setBackground(new Color(193, 193, 193));
        this.add(hardButton, costraints);
        
        speed = 12; 
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setFont(defaultLabelFont);
		g.setColor(Color.BLACK);
		FontMetrics fontMetrics = this.getFontMetrics(defaultLabelFont);
		g.drawString(normalString, settingsPanel.guiFrame.getWidth()/2-fontMetrics.stringWidth(normalString)/2 - 10, 500);
		g.drawString(hardString, settingsPanel.guiFrame.getWidth()/2-fontMetrics.stringWidth(normalString)/2 - 15, 680);
		
		//Przycisk easy jest zawsze dostepny
		if(settingsPanel.guiFrame.menuPanel.score >= 0) {
			easyButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
			easyButton.setActionCommand("easy");
		}
		
		//Przyciski normal i hard sa dostêpne po uzyskaniu 500/100 punktow, jesli gracz straci wszystkie zycia, a zatem tez punkty, to przyciski znowu staja sie niedostepne
		if(settingsPanel.guiFrame.menuPanel.score >= 500) {
			normalButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
			normalButton.setActionCommand("normal");
		}
		else {
			normalButton.setBackground(new Color(193, 193, 193));
			normalButton.setBorderPainted(false);
			normalButton.setActionCommand("");
		}
		
		if(settingsPanel.guiFrame.menuPanel.score >= 1000) {
			hardButton.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
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
