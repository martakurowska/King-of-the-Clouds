import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;
import javax.sound.sampled.Clip;
import sun.audio.*;
import javax.swing.*; 
import javax.swing.event.*; 
import javax.swing.ButtonGroup; 

public class soundPanel extends JFrame implements ActionListener {

	JPanel panel; 
	JSlider volumeSlider; 
	Font font;
	JRadioButton song1, song2, song3, song4; 
	private ButtonGroup songButtonGroup; 
	static final int SLIDER_MIN = 0;
    static final int SLIDER_MAX = 100;
    static final int SLIDER_INIT = 0;
    protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public void setButton (JRadioButton btn) {
    	btn.setOpaque(false);
    	font = new Font("Impact", Font.PLAIN, 40); 
    	btn.setFont(font); 
    	btn.setForeground(Color.BLACK); 
    	btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
    }
    
    
    public soundPanel() {
    	
    	panel = new JPanel(); 
    	panel.setOpaque(false);
    	panel.setLayout(new GridBagLayout());
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 200;
        c.ipady = 30;
        //c.insets = new Insets(0, 0, 0, 0);

        c.gridx = 1; 
        c.gridy = 0; 
        volumeSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
    	volumeSlider.setPreferredSize(new Dimension(600,80));
    	volumeSlider.setMajorTickSpacing(20); 
    	volumeSlider.setMinorTickSpacing(5); 
    	volumeSlider.setPaintTicks(true);
    	volumeSlider.setPaintLabels(true); 
    	volumeSlider.addChangeListener(new SliderChangeListener());
    	volumeSlider.setBackground(new Color(251, 212, 225));   
        panel.add(volumeSlider, c);
    	
        c.gridx = 1;
        c.gridy = 1;
        song1 = new JRadioButton ("Cat goes fishing"); 
        setButton(song1);
        song1.setActionCommand("cgf");
        panel.add(song1, c);
    	
        c.gridx = 1;
        c.gridy = 2;
        song2 = new JRadioButton ("King of the Clouds"); 
        setButton(song2);
        song2.setActionCommand("kotc");
        panel.add(song2, c);
        
        c.gridx = 1;
        c.gridy = 3;
        song3 = new JRadioButton ("Dragonstea din tei");
        setButton(song3);
        song3.setActionCommand("ddt");
        panel.add(song3, c);
        
        
        c.gridx = 1;
        c.gridy = 4;
        song4 = new JRadioButton ("Rumadai"); 
        setButton(song4);
        song4.setActionCommand("r");
        panel.add(song4, c);
        
    /*	songButtonGroup.add(song1);
    	songButtonGroup.add(song2);
    	songButtonGroup.add(song3);              //cos sie tu sypie ale nwm co jeszcze 
    	songButtonGroup.add(song4); */

    	this.add(panel, BorderLayout.CENTER); 
    }
	
    public JPanel setUpSounds() {
    	return panel; 
    }
    
    @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "cgf") {
			try {
			    URL url = getClass().getResource("others/cgf.wav");
			    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			    Clip music = AudioSystem.getClip();
			    music.open(audio);
			    music.loop(-1);
			} 
			catch(Exception f) {}
						
        } 
        else if (e.getActionCommand() == "kotc") {	
        	try {
			    URL url = getClass().getResource("others/KOTC.wav");
			    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			    Clip music = AudioSystem.getClip();
			    music.open(audio);
			    music.loop(-1);
			}
        	catch(Exception f) {}
        }
        else if (e.getActionCommand() == "ddt") {  
        	try {
			    URL url = getClass().getResource("others/DDT.wav");
			    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			    Clip music = AudioSystem.getClip();
			    music.open(audio);
			    music.loop(-1);
			}
        	catch(Exception f) {}
        }
        else if (e.getActionCommand() == "r") {  
        	try {
			    URL url = getClass().getResource("others/Rumadai.wav");
			    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
			    Clip music = AudioSystem.getClip();
			    music.open(audio);
			    music.loop(-1);
			} 
        	catch(Exception f) {}
        }
        
	}
    
    public class SliderChangeListener implements ChangeListener  //klasa implementacyjna do suwaka
    {
        @Override
        public void stateChanged(ChangeEvent ce){
            int value = volumeSlider.getValue();
            
         }

    }
	
}
