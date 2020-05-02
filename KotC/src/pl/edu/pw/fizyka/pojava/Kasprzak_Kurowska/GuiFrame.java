package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GuiFrame extends JFrame implements KeyListener {
	                    
	public ResourceBundle languageBundle;
	URL audioUrl;
	AudioInputStream audio; 
	Clip music;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	int width, height;
	Container container; 
	MenuPanel menuPanel;
	GamePanel gamePanel;
	EscapeDialogPanel escapeDialog;
	DifficultyFrame difficultyFrame;
	SettingsPanel settingsPanel;
	boolean isGameActive = false;
	ImageIcon balloonImage, planeImage; 
	
	public GuiFrame() {
		this.setMinimumSize(new Dimension((int) (screenWidth*0.7),(int) (screenHeight*0.85)));
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
	    this.addKeyListener(this);
	    languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
	    width = (this.screenWidth/2)-(this.getWidth()/2);
	    height = (this.screenHeight/2)-(this.getHeight()/2);
	    this.setLocation(width, height);
		container = this.getContentPane();
		
		try {
		    audioUrl = getClass().getResource("others/music/KOTC.wav");
		    audio = AudioSystem.getAudioInputStream(audioUrl);
		    music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
		
		menuPanel = new MenuPanel(this);
        container.add(menuPanel);
        menuPanel.setVisible(true);
        
        difficultyFrame = new DifficultyFrame(this);
        escapeDialog = new EscapeDialogPanel(this);
        settingsPanel = new SettingsPanel(this); 	
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ESCAPE) {
			if (this.isGameActive==true) {
				escapeDialog.setVisible(true);
			}
		}
		if(isGameActive) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
				gamePanel.balloon.dx = -difficultyFrame.speed;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D ) {		
				gamePanel.balloon.dx = difficultyFrame.speed;
			}		
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(isGameActive) {
			if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
				gamePanel.balloon.dx = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
				gamePanel.balloon.dx = 0;
			}	
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
