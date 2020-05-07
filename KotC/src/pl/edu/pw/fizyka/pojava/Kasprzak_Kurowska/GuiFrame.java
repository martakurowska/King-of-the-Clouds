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

//Marta Kurowska
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
	EscapeDialogFrame escapeDialog;
	SettingsPanel settingsPanel;
	boolean isGameActive = false;
	String youWon, gameOver;
	ImageIcon balloonImage, planeImage; 
	
	public GuiFrame() {
		this.setMinimumSize(new Dimension(1070, 725));
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
	    this.addKeyListener(this);
	    languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
	    youWon = languageBundle.getString("youwon");
	    gameOver = languageBundle.getString("gameover");
	    width = (this.screenWidth/2)-(this.getWidth()/2);
	    height = (this.screenHeight/2)-(this.getHeight()/2);
	    this.setLocation(width, height);
		container = this.getContentPane();
		
		try {
		    audioUrl = getClass().getResource("others/music/KOTC.wav");
		    audio = AudioSystem.getAudioInputStream(audioUrl);
		    music = AudioSystem.getClip();
		    music.open(audio);
		    //(-1) oznacza automatyczne zapetlanie piosenki
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		//ustawienie domyslnego galonika jesli gracz nie wybierze go w ustawieniach
		balloonImage = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
		
		menuPanel = new MenuPanel(this);
        container.add(menuPanel);
        menuPanel.setVisible(true);
        
        settingsPanel = new SettingsPanel(this); 	
        
        escapeDialog = new EscapeDialogFrame(this);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		//jesli uzytkownik jest w grze to esc wyswielta okienko dialogowe z pytanie czy chce wrocic do mneu, przysiski prawo/D, lewo/A kontroluj¹ poruszanie balonika
		if(isGameActive) {
			if(e.getKeyChar()==KeyEvent.VK_ESCAPE) {
				gamePanel.isGameRunning = false;
				escapeDialog.setVisible(true);
			}
			if(e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
				gamePanel.balloon.dx = -settingsPanel.difficultyPanel.speed;
			}
			if(e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {		
				gamePanel.balloon.dx = settingsPanel.difficultyPanel.speed;
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
