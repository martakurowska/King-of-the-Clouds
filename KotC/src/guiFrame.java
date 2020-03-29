import java.awt.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiFrame extends JFrame {
	                    
	//public ResourceBundle bundle;
/*	public LevelSettings levelSettings;
	public ColorSettings colorSettings;					//tego jeszcze nie mamy 
	public Game newgame; */
	ImageIcon img;
	Container con; 
	private Font font; 
	private Color color; 
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, levelChangeBtn; 
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    settingsFrame settings;
	JPanel menuPanel, settingsPanel;
	menuScreenHandler msHandler = new menuScreenHandler();

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
        newGameBtn.setActionCommand("newgame");
        newGameBtn.addActionListener(msHandler);
        menuPanel.add(newGameBtn, c);

        c.gridy = 2;
        loadGameBtn = new JButton("load game");
        loadGameBtn.setFont(font);
        loadGameBtn.setBackground(color); 
        loadGameBtn.setForeground(Color.BLACK);
        loadGameBtn.setActionCommand("loadgame");
        loadGameBtn.addActionListener(msHandler);
        menuPanel.add(loadGameBtn, c);

        c.gridy = 3;
        levelChangeBtn = new JButton("difficulty");
        levelChangeBtn.setFont(font);
        levelChangeBtn.setBackground(color);
        levelChangeBtn.setForeground(Color.BLACK);
        levelChangeBtn.setActionCommand("difficulty");
        levelChangeBtn.addActionListener(msHandler);
        menuPanel.add(levelChangeBtn, c);

        c.gridy = 4;
        settingsBtn = new JButton("settings");
        settingsBtn.setFont(font);
        settingsBtn.setBackground(color); 
        settingsBtn.setForeground(Color.BLACK);
        settingsBtn.setActionCommand("settings");
        settingsBtn.addActionListener(msHandler);
        menuPanel.add(settingsBtn, c);
        
        c.gridy = 5;
        exitGameBtn = new JButton("exit");
        exitGameBtn.setFont(font);
        exitGameBtn.setBackground(color); 
        exitGameBtn.setForeground(Color.BLACK);
        exitGameBtn.setActionCommand("exitgame");
        exitGameBtn.addActionListener(msHandler);
        menuPanel.add(exitGameBtn, c);
		
        return menuPanel;
	}
	
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
       
		
		
	}
	
	public class menuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
				//setFalse(isMenuActive);
				//setFalse(isSettingsActive);
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	//setFalse(isMenuActive);
	        	//setFalse(isSettingsActive);
	        } 
	        else if (e.getActionCommand() == "difficulty") {
	        	//setFalse(isSettingsActive);
	        }
	        else if (e.getActionCommand() == "settings") {
	        	menuPanel.setVisible(false);
	        	settings = new settingsFrame();
	        	settingsPanel = settings.setUpSettings();
	        	con.add(settingsPanel);
	        }
	        else if (e.getActionCommand() == "exitgame") {
	            System.exit(0);
	        }
			
		}
	}
}
