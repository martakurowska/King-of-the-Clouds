package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//Marta Kurowska
public class CharacterPanel implements ActionListener  {

	private JButton character1, character2, character3, character4, character5, character6; 
	JPanel panelSetup; 
	Icon balloonImage;
    SettingsPanel settingsPanel;
    GridBagConstraints constraints;
    
    public void setButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		panelSetup.add(btn, constraints);
	}  
     
    public CharacterPanel(SettingsPanel settings) {
    	settingsPanel = settings;;
    	panelSetup = new JPanel(); 
    	panelSetup.setOpaque(false);
    	panelSetup.setLayout(new GridBagLayout());   
    	constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = -35;
        constraints.ipady = -8;
        constraints.insets = new Insets(-90, 100, 50, 100);

        constraints.gridx = 0;
        constraints.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
        character1 = new JButton(balloonImage);
        setButton(character1);
        character1.setActionCommand("yellow");
        
        constraints.gridx = 1;
        constraints.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
        character2 = new JButton(balloonImage);
        setButton(character2);
        character2.setActionCommand("happy");
    	
        constraints.gridx = 2;
        constraints.gridy = 0;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
        character3 = new JButton(balloonImage);
        setButton(character3);
        character3.setActionCommand("orange");
    	
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 100, 0, 100);
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
        character4 = new JButton(balloonImage);
        setButton(character4);
        character4.setActionCommand("blue");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
        character5 = new JButton(balloonImage);
        setButton(character5);
        character5.setActionCommand("moro");
        
        constraints.gridx = 2;
        constraints.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
        character6 = new JButton(balloonImage);
        setButton(character6);
        character6.setActionCommand("crazy");
    }
    
    public JPanel setUpCharacter() { 
		return panelSetup;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "yellow") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
		} 
		else if(e.getActionCommand() == "happy") {	
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
		}
		else if(e.getActionCommand() == "orange") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
		}
		else if(e.getActionCommand() == "blue") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
		}
		else if(e.getActionCommand() == "moro") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
		} 
		else if(e.getActionCommand() == "crazy") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
		}	
	}
}