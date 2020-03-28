import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Color; 
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.net.URL;


public class guiFrame extends JFrame{
	
	Graphics g;
	JPanel topPanel, centerPanel;                      
	JLabel background;
	JButton newGame, load, exit, level; 
	ButtonGroup group; 
	private ImageIcon menu;
	Image img;
	boolean started = false;
	private int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
    
    
    
	public guiFrame() {
	//	this.setSize(1360, 960);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
		this.setSize((int) (screenWidth*0.7),(int) (screenHeight*0.85) );
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
		centerPanel.setBackground(null);
		centerPanel.setOpaque(false);
		centerPanel.setLayout(new GridLayout(0,1,0,80)); //rows, columns, size of horizontal gaps, size of vertical gaps
		newGame = new JButton("New Game");
		load = new JButton("Load"); 
		level = new JButton("Level"); 
		exit = new JButton("Exit"); 
		newGame.setFont(new Font("Impact", Font.PLAIN, 14));
        newGame.setBackground(new Color(225,108,164));
        newGame.setForeground(Color.white); 
        load.setFont(new Font("Impact", Font.PLAIN, 14));
        load.setBackground(new Color(225,108,164));
        load.setForeground(Color.white);
        level.setFont(new Font("Impact", Font.PLAIN, 14));
        level.setBackground(new Color(225,108,164));
        level.setForeground(Color.white);
        exit.setFont(new Font("Impact", Font.PLAIN, 14));
        exit.setBackground(new Color(225,108,164));
        exit.setForeground(Color.white);
        centerPanel.add(newGame);
        centerPanel.add(load);
        centerPanel.add(level);
        centerPanel.add(exit);
		ImageIcon img = new ImageIcon(guiFrame.class.getResource("menu2.png"));
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,(int) (screenWidth*0.7),(int) (screenHeight*0.85));
        
       // background.setPreferredSize(new Dimension(500,600));
        this.add(background);
		this.add(centerPanel, BorderLayout.CENTER);
		
        
    /*    this.add(leftPanel, BorderLayout.LINE_START);
        this.add(rightPanel, BorderLayout.LINE_END); */ 
        
	
	}
	
	

}
