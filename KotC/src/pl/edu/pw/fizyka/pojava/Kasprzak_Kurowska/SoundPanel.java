package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener; 

//Wiktoria Kasprzak: layout panelu, Marta Kurowska: ustawienia dzwiekowe
public class SoundPanel extends JPanel implements ActionListener {

	JPanel panelSetup; 
	Font defaultFont;
	JRadioButton song1, song2, song3, song4, song5, song6, song7, song8, song9, song10;
	JButton onButton, offButton;
	Icon imageVolume;
	ButtonGroup songButtonGroup; 
	SettingsPanel settingsPanel;
	GridBagConstraints c;
	private JSlider volumeSlider; 
	FloatControl gain; 
     
    public void setJRadioButton (JRadioButton btn) {
    	btn.setOpaque(false);
    	defaultFont = new Font("Impact", Font.PLAIN, 40); 
    	btn.setFont(defaultFont); 
    	btn.setForeground(Color.BLACK); 
    	btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		songButtonGroup.add(btn);
		panelSetup.add(btn, c);
    }
    
    public void setUpJButton(JButton btn) {
    	btn.setBackground(new Color(225,108,164)); 
    	btn.setFocusPainted(false);
    	btn.addActionListener(this);
    	panelSetup.add(btn, c);
    }
    
    public SoundPanel(SettingsPanel settings) {
    	
    	settingsPanel = settings;;
    	panelSetup = new JPanel(); 
    	panelSetup.setOpaque(false);
    	panelSetup.setLayout(new GridBagLayout());
    	songButtonGroup = new ButtonGroup();
    	
    	c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(-50, 30, 80, 30);
        c.gridx = 0; 
        c.gridy = 0; 
        c.gridwidth = 2;
        gain = (FloatControl)settingsPanel.guiFrame.music.getControl(FloatControl.Type.MASTER_GAIN);
        volumeSlider = new JSlider(JSlider.HORIZONTAL, -40, 6, 0);
        volumeSlider.setPreferredSize(new Dimension(300,50));
        volumeSlider.setOpaque(false);
    	volumeSlider.addChangeListener(new ChangeListener() { 		
			@Override
			public void stateChanged(ChangeEvent e) {
				gain.setValue(volumeSlider.getValue());
			}
    	}); 
    	panelSetup.add(volumeSlider, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1; 
        imageVolume = new ImageIcon(getClass().getResource("others/music/vlm_off.png"));
        offButton = new JButton(imageVolume);
        setUpJButton(offButton);
        offButton.setActionCommand("off");
      		
        c.insets = new Insets(0, 20, 20, 20);
        c.gridx = 0; 
        c.gridy = 2; 
        song1 = new JRadioButton ("Cat goes fishing"); 
        setJRadioButton(song1);
        song1.setActionCommand("cgf");
    	
        c.gridx = 0;
        c.gridy = 3;
        song2 = new JRadioButton("King of the Clouds"); 
        setJRadioButton(song2);
        song2.setSelected(true);
        song2.setActionCommand("kotc");
    	
        c.gridx = 0;
        c.gridy = 4;
        song3 = new JRadioButton("Bohema");
        setJRadioButton(song3);
        song3.setActionCommand("Boh");
        
        c.gridx = 0;
        c.gridy = 5;
        song4 = new JRadioButton("Rumadai"); 
        setJRadioButton(song4);
        song4.setActionCommand("r");
        
        c.gridx = 0;
        c.gridy = 6;
        song5 = new JRadioButton("A Sky Full of Stars");
        setJRadioButton(song5);
        song5.setActionCommand("ASFoS");
        
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(-50, 30, 80, 30);
        imageVolume = new ImageIcon(getClass().getResource("others/music/vlm_on.png"));
        onButton = new JButton(imageVolume);
        setUpJButton(onButton);
        onButton.setActionCommand("on");
        
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(0, 20, 20, 20);
        song6 = new JRadioButton("Counting Stars");
        setJRadioButton(song6);
        song6.setActionCommand("CS");
        
        c.gridx = 1;
        c.gridy = 3;
        song7 = new JRadioButton("Górą ty");
        setJRadioButton(song7);
        song7.setActionCommand("GT");
        
        c.gridx = 1;
        c.gridy = 4;
        song8 = new JRadioButton("Dragonstea din tei");
        setJRadioButton(song8);
        song8.setActionCommand("ddt");
        
        c.gridx = 1;
        c.gridy = 5;
        song9 = new JRadioButton("Pumped up Kicks");
        setJRadioButton(song9);
        song9.setActionCommand("PuK");
        
        c.gridx = 1;
        c.gridy = 6;
        song10 = new JRadioButton("Up In The Air");
        setJRadioButton(song10);
        song10.setActionCommand("UITA");

    	this.add(panelSetup, BorderLayout.CENTER); 
    }
	
    public JPanel setUpSounds() {
    	return panelSetup; 
    }
    
    public void setUpButtonsAction() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
    	settingsPanel.guiFrame.audio = AudioSystem.getAudioInputStream(settingsPanel.guiFrame.audioUrl);
    	settingsPanel.guiFrame.music = AudioSystem.getClip();
    	settingsPanel.guiFrame.music.open(settingsPanel.guiFrame.audio);
        gain = (FloatControl)settingsPanel.guiFrame.music.getControl(FloatControl.Type.MASTER_GAIN);
		gain.setValue(volumeSlider.getValue());
		settingsPanel.guiFrame.music.loop(-1);
		settingsPanel.guiFrame.revalidate();
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand() == "on") {  
        	try {
        		settingsPanel.guiFrame.music.start();
			} 
        	catch(Exception f) {}
        }
        else if (e.getActionCommand() == "off") {  
        	try {
        		settingsPanel.guiFrame.music.stop(); 
			} 
        	catch(Exception f) {}
        } 
        else {
        	settingsPanel.guiFrame.music.stop();
        	switch(e.getActionCommand()) {
        		case "cgf":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/cgf.wav");
        				this.setUpButtonsAction();
        			}
        			catch(Exception f) {}	
        			break;
        		case "kotc":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/KOTC.wav");
        				this.setUpButtonsAction();
        			}
        			catch(Exception f) {}	
        			break;
        		case "ddt":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/DDT.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "r":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/Rumadai.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "ASFoS":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/ASFoS.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "CS":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/CS.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "GT":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/GTGJ.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "Boh":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/lece.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "PuK":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/PuK.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        		case "UITA":
        			try {
        				settingsPanel.guiFrame.audioUrl = getClass().getResource("others/music/UiTA.wav");
        				this.setUpButtonsAction();
        			}
            		catch(Exception f) {}	
            		break;
        	}
        }
	} 
} 
