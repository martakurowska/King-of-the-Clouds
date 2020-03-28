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
	JPanel topPanel, centerPanel;                      
	JLabel background;
	public JButton newGame, loadGame, exitGame, levelChange; 
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
	//	this.setSize(1360, 960);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setFocusable(true);
	    this.requestFocusInWindow();
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
		font = new Font("Impact", Font.PLAIN, 14);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);												//ustawienie koloru przycisku
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(700,50));
		topPanel.setBackground( new Color(126,177,211));
		//img = new Image(guiFrame.class.getResource("volumebutton.png"));
		this.add(topPanel, BorderLayout.PAGE_START);
		try {
		    URL url = guiFrame.class.getResource("cgf.wav");
		    AudioInputStream audio = AudioSystem.getAudioInputStream(url);
		    Clip music = AudioSystem.getClip();
		    music.open(audio);
		    music.loop(-1);
		} 
		catch (Exception e) {
		}
		
		centerPanel = new JPanel();

		ImageIcon img = new ImageIcon(guiFrame.class.getResource("menu2.png"));
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,(int) (screenWidth*0.7),(int) (screenHeight*0.85));
        
        add(background);
        background.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        c.insets = new Insets(10, 0, 0, 0);

        c.gridx = 5;
        
        c.gridy = 0;
        newGame = new JButton(bundle.getString("newgame"));
        newGame.setFont(font);
        newGame.setBackground(color);
        newGame.setActionCommand("NewGame");
 //     newGame.addActionListener(this);
        background.add(newGame, c);
        
        c.gridy = 1;
        loadGame = new JButton(bundle.getString("loadGame"));
        loadGame.setFont(font);
        loadGame.setBackground(color); 
        loadGame.setActionCommand("loadGame");
     // loadGame.addActionListener(this);
        background.add(loadGame, c);

        c.gridy = 2;
        levelChange = new JButton(bundle.getString("levelChange"));
        levelChange.setFont(font);
        levelChange.setBackground(color);
        levelChange.setActionCommand("levelChange");
     // levelChange.addActionListener(this);
        background.add(levelChange, c);

        c.gridy = 3;
        exitGame = new JButton(bundle.getString("exit"));
        exitGame.setFont(font);
        exitGame.setBackground(color); 
        exitGame.setActionCommand("exitGame");
     // exitGame.addActionListener(this);
        background.add(exitGame, c);

        
       // background.setPreferredSize(new Dimension(500,600));
        this.add(background);
		this.add(centerPanel, BorderLayout.CENTER);
		
        
    /*    this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END); */ 
        
	
	}
	
	

}
