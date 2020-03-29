import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.event.*;

public class guiFrame extends JFrame {
	                    
	public ResourceBundle bundle;
/*	public LevelSettings levelSettings;
	public ColorSettings colorSettings;					//tego jeszcze nie mamy 
	public Game newgame; */
	ImageIcon img, img2;
	Container con; 
	private Font font; 
	private Color color; 
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, levelChangeBtn, soundButton, languageButton, characterButton, backToMenuButton;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	JPanel menuPanel, settingsPanel, settingsPanelTop, languagePanel;
	menuScreenHandler msHandler = new menuScreenHandler();
	languagePanel lngPanel;
	//difficultyFrame difficultyFrame;
	public JPanel menuFrame() {
		
		menuPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        img = new ImageIcon(getClass().getResource("others/menu2.png"));
		        G.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		    }
		};
		menuPanel.setBounds(0,0,1360, 960);
        
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
    	font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);												//ustawienie koloru przycisku
        newGameBtn = new JButton("new game");
        newGameBtn.setFont(font);
        newGameBtn.setBackground(color);
        newGameBtn.setForeground(Color.BLACK);
        newGameBtn.setFocusPainted(false);
        newGameBtn.setActionCommand("newgame");
        newGameBtn.addActionListener(msHandler);
        menuPanel.add(newGameBtn, c);

        c.gridy = 2;
        loadGameBtn = new JButton("load game");
        loadGameBtn.setFont(font);
        loadGameBtn.setBackground(color); 
        loadGameBtn.setForeground(Color.BLACK);
        loadGameBtn.setFocusPainted(false);
        loadGameBtn.setActionCommand("loadgame");
        loadGameBtn.addActionListener(msHandler);
        menuPanel.add(loadGameBtn, c);

        c.gridy = 3;
        levelChangeBtn = new JButton("difficulty");
        levelChangeBtn.setFont(font);
        levelChangeBtn.setBackground(color);
        levelChangeBtn.setForeground(Color.BLACK);
        levelChangeBtn.setFocusPainted(false);
        levelChangeBtn.setActionCommand("difficulty");
        levelChangeBtn.addActionListener(msHandler);
        menuPanel.add(levelChangeBtn, c);

        c.gridy = 4;
        settingsBtn = new JButton("settings");
        settingsBtn.setFont(font);
        settingsBtn.setBackground(color); 
        settingsBtn.setForeground(Color.BLACK);
        settingsBtn.setFocusPainted(false);
        settingsBtn.setActionCommand("settings");
        settingsBtn.addActionListener(msHandler);
        menuPanel.add(settingsBtn, c);
        
        c.gridy = 5;
        exitGameBtn = new JButton("exit");
        exitGameBtn.setFont(font);
        exitGameBtn.setBackground(color); 
        exitGameBtn.setForeground(Color.BLACK);
        exitGameBtn.setFocusPainted(false);
        exitGameBtn.setActionCommand("exitgame");
        exitGameBtn.addActionListener(msHandler);
        menuPanel.add(exitGameBtn, c);
		
        return menuPanel;
	};
	
	
	public JPanel settingsFrame() {
		settingsPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        img2 = new ImageIcon(getClass().getResource("others/settings.png"));
		        G.drawImage(img2.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		    }
		};
		settingsPanel.setPreferredSize(new Dimension((int) (screenWidth*0.7),(int) (screenHeight*0.85)));
		settingsPanel.setLayout(new BorderLayout());
		
		font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);	
		
		settingsPanelTop = new JPanel();
		settingsPanelTop.setOpaque(false);
		
		characterButton = new JButton("character");
		characterButton.setFont(font);
		characterButton.setBackground(color);
		characterButton.setForeground(Color.BLACK);
		characterButton.setFocusPainted(false);
		characterButton.setActionCommand("character");
		characterButton.addActionListener(msHandler);
		settingsPanelTop.add(characterButton);

        languageButton = new JButton("language");
        languageButton.setFont(font);
        languageButton.setBackground(color); 
        languageButton.setForeground(Color.BLACK);
        languageButton.setFocusPainted(false);
        languageButton.setActionCommand("language");
        languageButton.addActionListener(msHandler);
        settingsPanelTop.add(languageButton);

        soundButton = new JButton("sound");
        soundButton.setFont(font);
        soundButton.setBackground(color);
        soundButton.setForeground(Color.BLACK);
        soundButton.setFocusPainted(false);
        soundButton.setActionCommand("sound");
        soundButton.addActionListener(msHandler);
        settingsPanelTop.add(soundButton);

        backToMenuButton = new JButton("back to menu");
        backToMenuButton.setFont(font);
        backToMenuButton.setBackground(color); 
        backToMenuButton.setForeground(Color.BLACK);
        backToMenuButton.setFocusPainted(false);
        backToMenuButton.setActionCommand("backToMenu");
        backToMenuButton.addActionListener(msHandler);
        settingsPanelTop.add(backToMenuButton);
        settingsPanel.add(settingsPanelTop, BorderLayout.PAGE_START);
        
        return settingsPanel;
	};
	
	
	public guiFrame() {
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
		con = this.getContentPane();
		
		try {
		    URL url = getClass().getResource("others/Rumadai.wav");
		    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
		    Clip music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		menuPanel = new JPanel();
		menuPanel = this.menuFrame(); 
        con.add(menuPanel);
        menuPanel.setVisible(true);
        
        settingsPanel = new JPanel();
    	settingsPanel = this.settingsFrame();
    	
    	//difficultyFrame = new difficultyFrame(this);
	};
	
	
	public class menuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
			
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	
	        } 
	        else if (e.getActionCommand() == "difficulty") {
	        	//difficultyFrame.setVisible(true);
	        }
	        else if (e.getActionCommand() == "settings") {
	        	
	        	con.add(settingsPanel);
	    		settingsPanel.setVisible(false);
	        	menuPanel.setVisible(false);
	        	settingsPanel.setVisible(true);
	        	
	        }
	        else if (e.getActionCommand() == "exitgame") {
	            System.exit(0);
	        }
	        else if (e.getActionCommand() == "backToMenu") {
	        	menuPanel.setVisible(true);
	        	settingsPanel.setVisible(false);
	        	languagePanel.setVisible(false);
	        }
	        else if (e.getActionCommand() == "language") {
	        	lngPanel = new languagePanel();
	        	languagePanel = lngPanel.setUpLanguages();
	        	settingsPanel.add(languagePanel, BorderLayout.CENTER);
	        	languagePanel.setVisible(false);
	        	languagePanel.setVisible(true);
	        } 
	        else if (e.getActionCommand() == "sound") {
	        	
	        	
	        }
	        else if (e.getActionCommand() == "character") {
				
	        } 
			
		}
	};
	
}
