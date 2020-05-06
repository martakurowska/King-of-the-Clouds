package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DifficultyPanel extends JPanel implements ActionListener {

	SettingsPanel settingsPanel; 
	int speed; 
	JButton hardButton, normalButton, easyButton; 
	Font defaultFont = new Font("Impact", Font.PLAIN, 60);  
	
    public void setButton(JButton btn) {
		btn.addActionListener(this);
		btn.setFocusPainted(false);
		btn.setForeground(Color.BLACK);
		btn.setFont(defaultFont);
		btn.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
	}  
    
	public DifficultyPanel(SettingsPanel settings) {
		
		settingsPanel = settings;  
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());   
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 90; 
        c.ipady = 30;
        c.insets = new Insets(35, 0, 35, 0);

        c.gridx = 0;
        c.gridy = 0; 
        easyButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("easy")); 
        setButton(easyButton); 
        easyButton.setActionCommand("easy");
        this.add(easyButton, c);
        
        c.gridx = 0; 
        c.gridy = 1; 
        normalButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("normal")); 
        setButton(normalButton); 
        normalButton.setActionCommand("normal");
        this.add(normalButton, c); 
        
        c.gridx = 0; 
        c.gridy = 2; 
        hardButton = new JButton(settingsPanel.guiFrame.languageBundle.getString("hard")); 
        setButton(hardButton); 
        hardButton.setActionCommand("hard");
        this.add(hardButton, c);
        
        speed = 12; 
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "easy") {
			speed = 12;		
		} else if (e.getActionCommand() == "normal") {
			speed = 8;
		} else if (e.getActionCommand() == "hard") {
			speed = 5;
		}
	}
}
