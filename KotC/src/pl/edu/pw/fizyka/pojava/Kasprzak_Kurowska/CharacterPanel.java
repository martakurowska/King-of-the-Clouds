package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
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
public class CharacterPanel extends JPanel implements ActionListener  {

	JButton character1, character2, character3, character4, character5, character6, points400, points800, points1200;
	Icon balloonImage;
	String blueBalloon = "400p", moroBalloon = "800p", crazyBalloon = "1200p"; 
	Font defaultLabelFont = new Font("Impact", Font.PLAIN, 30);
	Color colorOfButton = new Color(225,108,164, 127);	
    SettingsPanel settingsPanel;
    GridBagConstraints constraints;
    
    public void setButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		btn.setFont(defaultLabelFont);
		this.add(btn, constraints);
	}  
     
    public void characterButton(JButton btn) {
    	character1.setContentAreaFilled(false);
    	character2.setContentAreaFilled(false);
    	character3.setContentAreaFilled(false);
    	character4.setContentAreaFilled(false);
    	character5.setContentAreaFilled(false);
    	character6.setContentAreaFilled(false);
    	btn.setContentAreaFilled(true);
		btn.setBackground(colorOfButton);
    }
    public CharacterPanel(SettingsPanel settings) {
    	settingsPanel = settings;;
    	this.setOpaque(false);
    	this.setLayout(new GridBagLayout());   
		constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = -15;
        constraints.ipady = 0;
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
        character4 = new JButton();
        setButton(character4);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        character5 = new JButton();
        setButton(character5);

        constraints.gridx = 2;
        constraints.gridy = 1;
        character6 = new JButton();
        setButton(character6);
        
        constraints.gridx = 0;
        constraints.gridy = 2;
        points400 = new JButton("400p");
        setButton(points400);
        
        constraints.gridx = 1;
        constraints.gridy = 2;
        points800 = new JButton("800p");
        setButton(points800);
        
        constraints.gridx = 2;
        constraints.gridy = 2;
        points1200 = new JButton("1200p");
        setButton(points1200);
        
    }
    
    @Override
	public void paintComponent(Graphics g) {
    	if(settingsPanel.guiFrame.menuPanel.score >= 400) {
    		balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
    		character4.setIcon(balloonImage);
		    character4.setActionCommand("blue"); 
    	} else {
			balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4bw.png"));
			character4.setIcon(balloonImage);
		    character4.setActionCommand(""); 
		}
    	
    	if(settingsPanel.guiFrame.menuPanel.score >= 800) {
    		balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
    		character5.setIcon(balloonImage);
		    character5.setActionCommand("moro"); 
    	} else {
			balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5bw.png"));
			character5.setIcon(balloonImage);
		    character5.setActionCommand(""); 
		}
    	
    	if(settingsPanel.guiFrame.menuPanel.score >= 1200) {
    		balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
    		character6.setIcon(balloonImage);
		    character6.setActionCommand("crazy"); 
    	} else {
			balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6bw.png"));
			character6.setIcon(balloonImage);
		    character6.setActionCommand(""); 
		}
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "yellow") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
			characterButton(character1); 
		} 
		else if(e.getActionCommand() == "happy") {	
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
			characterButton(character2); 
		}
		else if(e.getActionCommand() == "orange") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
			characterButton(character3); 
		}
		else if(e.getActionCommand() == "blue") {  
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
			characterButton(character4); 
		}
		else if(e.getActionCommand() == "moro") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
			characterButton(character5); 
		} 
		else if(e.getActionCommand() == "crazy") {
			settingsPanel.guiFrame.balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
			characterButton(character6);  
		}	
	}
}