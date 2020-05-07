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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//Marta Kurowska
public class CharacterPanel extends JPanel implements ActionListener  {

	private JButton character1, character2, character3, character4, character5, character6, char4BW, char5BW, char6BW; 
	Icon balloonImage;
	String blueBalloon = "400p", moroBalloon = "800p", crazyBalloon = "1200p"; 
	Font defaultLabelFont = new Font("Impact", Font.PLAIN, 30);
    SettingsPanel settingsPanel;
    GridBagConstraints constraints;
    
    public void setButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		this.add(btn, constraints);
	}  
     
    public CharacterPanel(SettingsPanel settings) {
    	settingsPanel = settings;;
    	this.setOpaque(false);
    	this.setLayout(new GridBagLayout());   
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
        character4.setVisible(false);
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly4bw.png"));
        char4BW = new JButton(balloonImage);
        setButton(char4BW);
        char4BW.setVisible(false);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
        character5 = new JButton(balloonImage);
        setButton(character5);
        character5.setVisible(false);
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly5bw.png"));
        char5BW = new JButton(balloonImage);
        setButton(char5BW);
        char5BW.setVisible(false);

        
        constraints.gridx = 2;
        constraints.gridy = 1;
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
        character6 = new JButton(balloonImage);
        setButton(character6);
        character6.setVisible(false);
        balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly6bw.png"));
        char6BW = new JButton(balloonImage);
        setButton(char6BW);
        char6BW.setVisible(false);
    }
    
    @Override
	public void paintComponent(Graphics g) {
    	g.setFont(defaultLabelFont);
		g.setColor(Color.BLACK);
		FontMetrics fontMetrics = this.getFontMetrics(defaultLabelFont);
		g.drawString(blueBalloon, settingsPanel.guiFrame.getWidth()/5-fontMetrics.stringWidth(blueBalloon)/2, 550);
		g.drawString(moroBalloon, settingsPanel.guiFrame.getWidth()/2-fontMetrics.stringWidth(moroBalloon)/2, 550);
		g.drawString(crazyBalloon, (settingsPanel.guiFrame.getWidth()/5)*4-fontMetrics.stringWidth(crazyBalloon)/2 - 15, 550);
    	
		 if(settingsPanel.guiFrame.menuPanel.score >= 400) {
			 char4BW.setVisible(false);
			 character4.setVisible(true);
		     character4.setActionCommand("blue"); 
		  }
		 else {
			 character4.setVisible(false);
			 char4BW.setVisible(true);
		     char4BW.setActionCommand(""); 
		 }
		 if(settingsPanel.guiFrame.menuPanel.score >= 800) {
			 char5BW.setVisible(false);
			 character5.setVisible(true);
		     character5.setActionCommand("moro"); 
	   	  }
		 else {
			 character5.setVisible(false);
			 char5BW.setVisible(true);
		     char5BW.setActionCommand(""); 
			 }
		 
		 if(settingsPanel.guiFrame.menuPanel.score >= 1200) {
			 character6.setVisible(false);
			 char6BW.setVisible(true);
		     char6BW.setActionCommand("crazy"); 
		  }
		 else {
			 character6.setVisible(false);
			 char6BW.setVisible(true);
		     char6BW.setActionCommand(""); 
			 }
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