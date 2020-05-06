package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DifficultyPanel extends JPanel implements ActionListener {

	GuiFrame guiFrame; 
	SettingsPanel settingsPanel; 
	private JButton hardButton, normalButton, easyButton; 
	
    public void setButton(JButton btn) {
		btn.addActionListener(this);
		btn.setForeground(Color.BLACK);
		btn.setFont(settingsPanel.guiFrame.menuPanel.defaultFont);
		btn.setBackground(settingsPanel.guiFrame.menuPanel.colorOfButton);
	}  
    
	public DifficultyPanel(SettingsPanel settings) {
		
		settingsPanel = settings;  
		this.setOpaque(false);
		this.setLayout(new GridBagLayout());   
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
    //    c.insets = new Insets(0, 0, 0, 0);

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
        
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
