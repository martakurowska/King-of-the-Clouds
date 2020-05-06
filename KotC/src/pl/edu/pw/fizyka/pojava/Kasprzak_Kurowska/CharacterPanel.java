package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CharacterPanel implements ActionListener  {

	private JButton character1, character2, character3, character4, character5, character6; 
	JPanel panelSetup; 
	Icon balloonImage;
    SettingsPanel settingsPanel;
    
    
    public void setButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
	}  
     
    public CharacterPanel(SettingsPanel settings) {
    	settingsPanel = settings;;
    	panelSetup = new JPanel(); 
    	panelSetup.setOpaque(false);
    	panelSetup.setLayout(new GridBagLayout());   
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = -35;
        c.ipady = -8;
        c.insets = new Insets(-90, 100, 50, 100);

        c.gridx = 0;
        c.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
        character1 = new JButton(balloonImage);
        setButton(character1);
        character1.addActionListener(this);
        character1.setActionCommand("yellow");
        panelSetup.add(character1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
        character2 = new JButton(balloonImage);
        setButton(character2);
        character2.addActionListener(this);
        character2.setActionCommand("happy");
        panelSetup.add(character2, c);
    	
        c.gridx = 2;
        c.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
        character3 = new JButton(balloonImage);
        setButton(character3);
        character3.addActionListener(this);
        character3.setActionCommand("orange");
        panelSetup.add(character3, c);
    	
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 100, 0, 100);
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
        character4 = new JButton(balloonImage);
        character4.addActionListener(this);
        setButton(character4);
        character4.setActionCommand("blue");
        panelSetup.add(character4, c);
        
        c.gridx = 1;
        c.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
        character5 = new JButton(balloonImage);
        setButton(character5);
        character5.addActionListener(this);
        character5.setActionCommand("moro");
        panelSetup.add(character5, c);
        
        c.gridx = 2;
        c.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
        character6 = new JButton(balloonImage);
        setButton(character6);
        character6.addActionListener(this);
        character6.setActionCommand("crazy");
        panelSetup.add(character6, c);
    }
    
    public JPanel setUpCharacter() { 
		return panelSetup;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "yellow") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
		} 
		else if (e.getActionCommand() == "happy") {	
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
		}
		else if (e.getActionCommand() == "orange") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
		}
		else if (e.getActionCommand() == "blue") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
		}
		else if (e.getActionCommand() == "moro") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
		} 
		else if (e.getActionCommand() == "crazy") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
		}	
	}
}