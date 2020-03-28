import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Color; 
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class guiFrame extends JFrame  {
	
	Graphics g;
	JPanel topPanel, topPanelA, topPanelB, centerPanel;                      
	JLabel background;
	public JButton newGame, loadGame, exitGame, settings, levelChange; 
	private Font font; 
	private Color color; 
	public ResourceBundle bundle;
/*	public LevelSettings levelSettings;
	public ColorSettings colorSettings;					//tego jeszcze nie mamy 
	public Game newgame; */
	private ImageIcon menu;
	Image img;
	boolean started = false;
	private int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
    
    
    
	public guiFrame() {
		//this.setSize(1360, 960);
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
		
		
		/*topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(700,50));
		topPanel.setBackground( new Color(126,177,211));
		topPanelA = new JPanel();
		topPanelA.setPreferredSize(new Dimension(350,50));
		topPanelA.setBackground( new Color(126,177,211));
		topPanelA.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl2 = new JLabel("Hello");
        topPanelA.add(lbl2);                                                //topPanel którego chyba nie robimy jednak
        topPanelB = new JPanel();
        topPanelB.setPreferredSize(new Dimension(350,50));
        topPanelB.setBackground( new Color(126,177,211));
        topPanelB.setLayout(new FlowLayout(FlowLayout.RIGHT));
        JLabel lbl3 = new JLabel("Hello");
        topPanelB.add(lbl3);
        topPanel.add(topPanelA);
        topPanel.add(topPanelB);
		img = new Image(guiFrame.class.getResource("volumebutton.png"));
		this.add(topPanel, BorderLayout.PAGE_START);
		*/
		
		
		try {
		    URL url = guiFrame.class.getResource("cgf.wav");
		    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
		    Clip music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		ImageIcon img = new ImageIcon(guiFrame.class.getResource("menu3.png"));
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
        lbl1.setPreferredSize(new Dimension(10,120));
        background.add(lbl1, c);
        
        c.gridy = 1;
    	font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);												//ustawienie koloru przycisku
        newGame = new JButton("new game");
        newGame.setFont(font);
        newGame.setBackground(color);
        newGame.setForeground(Color.BLACK);
        newGame.setActionCommand("NewGame");
 //     newGame.addActionListener(this);
        background.add(newGame, c);

        c.gridy = 2;
        loadGame = new JButton("load game");
        loadGame.setFont(font);
        loadGame.setBackground(color); 
        loadGame.setForeground(Color.BLACK);
        loadGame.setActionCommand("loadGame");
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
     // settings.addActionListener(this);
        background.add(settings, c);
        
        c.gridy = 5;
        exitGame = new JButton("exit");
        exitGame.setFont(font);
        exitGame.setBackground(color); 
        exitGame.setForeground(Color.BLACK);
        exitGame.setActionCommand("exitGame");
     // exitGame.addActionListener(this);
        background.add(exitGame, c);

        
       // background.setPreferredSize(new Dimension(500,600));
        this.add(background);
		
		
        
    /*    this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END); */ 
        
	
	}
	
	

}
