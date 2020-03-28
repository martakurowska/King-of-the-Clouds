import java.awt.*;
import java.awt.Color; 
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiFrame extends JFrame implements ActionListener {
	
	Graphics g;
	JPanel topPanel, topPanelA, topPanelB, centerPanel;                      
	JLabel background;
	public JButton newGame, loadGame, exitGame, settings, levelChange; 
	private Font font; 
	private Color color; 
	ImageIcon img, img2;
	//public ResourceBundle bundle;
	private String selected;
/*	public LevelSettings levelSettings;
	public ColorSettings colorSettings;					//tego jeszcze nie mamy 
	public Game newgame; */
	boolean started = false;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public settingsFrame settingsFrame;
	
    
    
    
	public guiFrame() {
		//this.setSize(1360, 960);
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
		
		try {
		    URL url = getClass().getResource("others/cgf.wav");
		    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
		    Clip music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		img = new ImageIcon(getClass().getResource("others/menu3.png"));
        background = new JLabel("",img,JLabel.CENTER);
        //background.setBounds(0,0,1360, 960);
        //background.setBounds(0,0,(int) (screenWidth*0.7),(int) (screenHeight*0.85));
        
        background.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 150;
        c.ipady = 18;
        c.insets = new Insets(15, 0, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        JLabel lbl1 = new JLabel("");
        lbl1.setPreferredSize(new Dimension(10,140));
        background.add(lbl1, c);
        
        c.gridy = 1;
    	font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);												//ustawienie koloru przycisku
        newGame = new JButton("new game");
        newGame.setFont(font);
        newGame.setBackground(color);
        newGame.setForeground(Color.BLACK);
        newGame.setActionCommand("newgame");
 //     newGame.addActionListener(this);
        background.add(newGame, c);

        c.gridy = 2;
        loadGame = new JButton("load game");
        loadGame.setFont(font);
        loadGame.setBackground(color); 
        loadGame.setForeground(Color.BLACK);
        loadGame.setActionCommand("loadgame");
     // loadGame.addActionListener(this);
        background.add(loadGame, c);

        c.gridy = 3;
        levelChange = new JButton("difficulty");
        levelChange.setFont(font);
        levelChange.setBackground(color);
        levelChange.setForeground(Color.BLACK);
        levelChange.setActionCommand("difficulty");
     // levelChange.addActionListener(this);
        background.add(levelChange, c);

        c.gridy = 4;
        settings = new JButton("settings");
        settings.setFont(font);
        settings.setBackground(color); 
        settings.setForeground(Color.BLACK);
        settings.setActionCommand("settings");
        settings.addActionListener(this);
        background.add(settings, c);
        
        c.gridy = 5;
        exitGame = new JButton("exit");
        exitGame.setFont(font);
        exitGame.setBackground(color); 
        exitGame.setForeground(Color.BLACK);
        exitGame.setActionCommand("exitgame");
        exitGame.addActionListener(this);
        background.add(exitGame, c);

        
       // background.setPreferredSize(new Dimension(500,600));
        this.add(background);
		
		
        
    /*    this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END); */ 
        
	
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "newgame") {
            selected = "newgame";
        } 
        else if (e.getActionCommand() == "loadgame") {
            selected = "loadgame";
        } 
        else if (e.getActionCommand() == "difficulty") {
            selected = "difficulty";
        }
        else if (e.getActionCommand() == "settings") {
        	selected = "settings";
        	//settingsFrame = new settingsFrame(this);
        	//settingsFrame.setVisible(true);
            //img2 = new ImageIcon(getClass().getResource("others/settings.png"));
    		//background = new JLabel("",img2,JLabel.CENTER);
    		
    		
        }
        else if (e.getActionCommand() == "exitgame") {
            selected = "exitgame";
            System.exit(0);
        }
    }

}
