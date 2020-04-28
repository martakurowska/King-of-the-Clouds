package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiFrame extends JFrame implements KeyListener {
	                    
	public ResourceBundle languageBundle;
	int width, height;
	ImageIcon menuImage, settingsImage;
	Container container; 
	private Font defaultFont; 
	private Color colorOfButton; 
	URL audioUrl;
	AudioInputStream audio; 
	Clip music;
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, levelChangeBtn, soundButton, languageButton, characterButton, backToMenuButton;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	JPanel menuPanel, settingsPanel, settingsPanelTop, languagePanel,  characterPanel, soundPanel, gamePanel;
	menuScreenHandler msHandler = new menuScreenHandler();
	DifficultyFrame difficultyFrame;
	LanguagePanel lngPanel;
	CharacterPanel charPanel; 
	SoundPanel sound;
	GamePanel game;
	EscapeDialogPanel escapeDialog;
	boolean isGameActive = false;
	ImageIcon balloonImage; 
	
	public void setButton(JButton btn) {
		btn.setFont(defaultFont);
        btn.setBackground(colorOfButton); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
	}
	
	public JPanel menuFrame() {
		
		menuPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        menuImage = new ImageIcon(getClass().getResource("others/menu2.png"));
		        G.drawImage(menuImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		        repaint();
		    }
		};
        
		menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 150;
        c.ipady = 15;
        c.insets = new Insets(15, 0, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        JLabel lbl1 = new JLabel("");
        lbl1.setPreferredSize(new Dimension(10,140));
        menuPanel.add(lbl1, c);
        
        c.gridy = 1;
    	defaultFont = new Font("Impact", Font.PLAIN, 34);   								
		colorOfButton = new Color(225,108,164);											
        newGameBtn = new JButton(languageBundle.getString("newgame"));
        setButton(newGameBtn);
        newGameBtn.setActionCommand("newgame");
        newGameBtn.addActionListener(msHandler);
        menuPanel.add(newGameBtn, c);

        c.gridy = 2;
        loadGameBtn = new JButton(languageBundle.getString("loadgame"));
        setButton(loadGameBtn);
        loadGameBtn.setActionCommand("loadgame");
        loadGameBtn.addActionListener(msHandler);
        menuPanel.add(loadGameBtn, c);

        c.gridy = 3;
        levelChangeBtn = new JButton(languageBundle.getString("levelChange"));
        setButton(levelChangeBtn);
        levelChangeBtn.setActionCommand("difficulty");
        levelChangeBtn.addActionListener(msHandler);
        menuPanel.add(levelChangeBtn, c);

        c.gridy = 4;
        settingsBtn = new JButton(languageBundle.getString("settings"));
        setButton(settingsBtn);
        settingsBtn.setActionCommand("settings");
        settingsBtn.addActionListener(msHandler);
        menuPanel.add(settingsBtn, c);
        
        c.gridy = 5;
        exitGameBtn = new JButton(languageBundle.getString("exit"));
        setButton(exitGameBtn);
        exitGameBtn.setActionCommand("exitgame");
        exitGameBtn.addActionListener(msHandler);
        menuPanel.add(exitGameBtn, c);
		
        return menuPanel;
	}
	
	
	public JPanel settingsFrame() {
		settingsPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        settingsImage = new ImageIcon(getClass().getResource("others/settings.png"));
		        G.drawImage(settingsImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		        repaint();
		    }
		};
		settingsPanel.setPreferredSize(new Dimension((int) (screenWidth*0.7),(int) (screenHeight*0.85)));
		settingsPanel.setLayout(new BorderLayout());
		
		defaultFont = new Font("Impact", Font.PLAIN, 34);   								
		colorOfButton = new Color(225,108,164);	
		
		settingsPanelTop = new JPanel();
		settingsPanelTop.setOpaque(false);
		
		characterButton = new JButton(languageBundle.getString("character")); 
		setButton(characterButton);
		characterButton.setActionCommand("character");
		characterButton.addActionListener(msHandler);
		settingsPanelTop.add(characterButton);

        languageButton = new JButton(languageBundle.getString("language"));
        setButton(languageButton);
        languageButton.setActionCommand("language");
        languageButton.addActionListener(msHandler);
        settingsPanelTop.add(languageButton);

        soundButton = new JButton(languageBundle.getString("sound"));
        setButton(soundButton);
        soundButton.setActionCommand("sound");
        soundButton.addActionListener(msHandler);
        settingsPanelTop.add(soundButton);

        backToMenuButton = new JButton(languageBundle.getString("backtomenu"));
        setButton(backToMenuButton);
        backToMenuButton.setActionCommand("backToMenu");
        backToMenuButton.addActionListener(msHandler);
        settingsPanelTop.add(backToMenuButton);
        settingsPanel.add(settingsPanelTop, BorderLayout.PAGE_START);
        
        return settingsPanel;
	}
	
	
	public GuiFrame() {
		this.setMinimumSize(new Dimension((int) (screenWidth*0.7),(int) (screenHeight*0.85)));
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
	    this.addKeyListener(this);
	    width = (this.screenWidth/2)-(this.getWidth()/2);
	    height = (this.screenHeight/2)-(this.getHeight()/2);
	    this.setLocation(width, height);
		container = this.getContentPane();
		languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");

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
		
		menuPanel = new JPanel();
		menuPanel = this.menuFrame(); 
        container.add(menuPanel);
        menuPanel.setVisible(true);
        
        game = new GamePanel(this);
        gamePanel = game.setUpGamePanel();
        
        escapeDialog = new EscapeDialogPanel(this);
        
        difficultyFrame = new DifficultyFrame(this);
        difficultyFrame.setVisible(false);
        
        settingsPanel = new JPanel();
    	settingsPanel = this.settingsFrame();
    	
    	
    	charPanel = new CharacterPanel(this);
    	characterPanel = charPanel.setUpCharacter();
		
    	lngPanel = new LanguagePanel(this, difficultyFrame, escapeDialog);
    	languagePanel = lngPanel.setUpLanguages();
    	    	
    	sound = new SoundPanel(this); 
    	soundPanel = sound.setUpSounds();	
	}
	
	public class menuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
				settingsPanel.setVisible(false);
	        	menuPanel.setVisible(false);
	        	container.add(gamePanel);
	        	gamePanel.setVisible(true);
	        	isGameActive = true;
	        	
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	
	        } 
	        else if (e.getActionCommand() == "difficulty") {
	        	difficultyFrame.setVisible(true);

	        }
	        else if (e.getActionCommand() == "settings") {
	        	settingsPanel.setVisible(false);
	        	menuPanel.setVisible(false);
	        	container.add(settingsPanel);
	        	settingsPanel.setVisible(true);
	        	characterPanel.setVisible(false);
	        	settingsPanel.add(characterPanel, BorderLayout.CENTER);
	    		characterPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "exitgame") {
	            System.exit(0);
	        }
	        else if (e.getActionCommand() == "backToMenu") {
	        	settingsPanel.setVisible(false);
	        	languagePanel.setVisible(false);
	        	soundPanel.setVisible(false);
	        	characterPanel.setVisible(false);
	        	container.remove(menuPanel); 
	            container.add(menuPanel);
	            menuPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "language") {
	        	characterPanel.setVisible(false);
	        	soundPanel.setVisible(false);
	        	settingsPanel.add(languagePanel, BorderLayout.CENTER);
	        	languagePanel.setVisible(true);
	        } 
	        else if (e.getActionCommand() == "sound") {
	        	languagePanel.setVisible(false);
	        	characterPanel.setVisible(false);
	        	settingsPanel.add(soundPanel, BorderLayout.CENTER);
	        	soundPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "character") {
	        	soundPanel.setVisible(false);
				languagePanel.setVisible(false);
				characterPanel.setVisible(true);
	        } 
		}
	}
	 
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ESCAPE) {
			if (this.isGameActive==true) {
				escapeDialog.setVisible(true);
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {}
	@Override
	public void keyTyped(KeyEvent arg0) {}
}
