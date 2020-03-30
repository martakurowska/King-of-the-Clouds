import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.event.*;

public class guiFrame extends JFrame {
	                    
	public ResourceBundle bundle;
	ImageIcon img, img2;
	Container con; 
	private Font font; 
	private Color color; 
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, levelChangeBtn, soundButton, languageButton, characterButton, backToMenuButton;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	JPanel menuPanel, settingsPanel, settingsPanelTop, languagePanel,  characterPanel, soundPanel;
	menuScreenHandler msHandler = new menuScreenHandler();
	languagePanel lngPanel;
	difficultyFrame difficultyFrame;
	characterPanel charPanel; 
	soundPanel sound; 
	
	public void setButton(JButton btn) {
		btn.setFont(font);
        btn.setBackground(color); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
	}
	

	public JPanel menuFrame() {
		
		menuPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        img = new ImageIcon(getClass().getResource("others/menu2.png"));
		        G.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
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
    	font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);												//ustawienie koloru przycisku
        newGameBtn = new JButton(bundle.getString("newgame"));
        setButton(newGameBtn);
        newGameBtn.setActionCommand("newgame");
        newGameBtn.addActionListener(msHandler);
        menuPanel.add(newGameBtn, c);

        c.gridy = 2;
        loadGameBtn = new JButton(bundle.getString("loadgame"));
        setButton(loadGameBtn);
        loadGameBtn.setActionCommand("loadgame");
        loadGameBtn.addActionListener(msHandler);
        menuPanel.add(loadGameBtn, c);

        c.gridy = 3;
        levelChangeBtn = new JButton(bundle.getString("levelChange"));
        setButton(levelChangeBtn);
        levelChangeBtn.setActionCommand("difficulty");
        levelChangeBtn.addActionListener(msHandler);
        menuPanel.add(levelChangeBtn, c);

        c.gridy = 4;
        settingsBtn = new JButton(bundle.getString("settings"));
        setButton(settingsBtn);
        settingsBtn.setActionCommand("settings");
        settingsBtn.addActionListener(msHandler);
        menuPanel.add(settingsBtn, c);
        
        c.gridy = 5;
        exitGameBtn = new JButton(bundle.getString("exit"));
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
		
		characterButton = new JButton(bundle.getString("character")); 
		setButton(characterButton);
		characterButton.setActionCommand("character");
		characterButton.addActionListener(msHandler);
		settingsPanelTop.add(characterButton);

        languageButton = new JButton(bundle.getString("language"));
        setButton(languageButton);
        languageButton.setActionCommand("language");
        languageButton.addActionListener(msHandler);
        settingsPanelTop.add(languageButton);

        soundButton = new JButton(bundle.getString("sound"));
        setButton(soundButton);
        soundButton.setActionCommand("sound");
        soundButton.addActionListener(msHandler);
        settingsPanelTop.add(soundButton);

        backToMenuButton = new JButton(bundle.getString("backtomenu"));
        setButton(backToMenuButton);
        backToMenuButton.setActionCommand("backToMenu");
        backToMenuButton.addActionListener(msHandler);
        settingsPanelTop.add(backToMenuButton);
        settingsPanel.add(settingsPanelTop, BorderLayout.PAGE_START);
        
        return settingsPanel;
	}
	
	
	public guiFrame() {
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
		con = this.getContentPane();
		bundle = ResourceBundle.getBundle("myProp"); 
		try {
		    URL url = getClass().getResource("others/DDT.wav");
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
        menuPanel.revalidate();
        menuPanel.setVisible(true);
        
        
        settingsPanel = new JPanel();
    	settingsPanel = this.settingsFrame();
    	
    	difficultyFrame = new difficultyFrame(this);
    	lngPanel = new languagePanel(this, difficultyFrame);
    	charPanel = new characterPanel();
    	sound = new soundPanel(); 
    	
	}
	
	
	public class menuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
			
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	
	        } 
	        else if (e.getActionCommand() == "difficulty") {
	        	difficultyFrame.setVisible(true);

	        }
	        else if (e.getActionCommand() == "settings") {
	        	con.add(settingsPanel);
	    		settingsPanel.setVisible(false);
	        	menuPanel.setVisible(false);
	        	settingsPanel.setVisible(true);
	        	menuPanel.revalidate();
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
	        	languagePanel = lngPanel.setUpLanguages();
	        	settingsPanel.add(languagePanel, BorderLayout.CENTER);
	        	languagePanel.setVisible(false);
	        	languagePanel.setVisible(true);
	        	characterPanel.setVisible(false);
	        	soundPanel.setVisible(false);
	        } 
	        else if (e.getActionCommand() == "sound") {
	        	soundPanel = sound.setUpSounds();
	        	settingsPanel.add(soundPanel, BorderLayout.CENTER);
	        	soundPanel.setVisible(false);
	        	soundPanel.setVisible(true);
	        	languagePanel.setVisible(false);
	        	characterPanel.setVisible(false);

	        }
	        else if (e.getActionCommand() == "character") {
	        	characterPanel = charPanel.setUpCharacter();
				settingsPanel.add(characterPanel, BorderLayout.CENTER);
				characterPanel.setVisible(false);
				characterPanel.setVisible(true);
				languagePanel.setVisible(false);
				soundPanel.setVisible(false);
	        } 
		}
	}
	
}