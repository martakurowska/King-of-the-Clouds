import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.net.URL;


public class guiFrame extends JFrame{
	
	Graphics g;
	JPanel topPanel, centerPanel;
	JLabel background;
	private ImageIcon menu;
	Image img;
	boolean started = false;
	//private int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
   // private int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public guiFrame() {
		this.setSize(1360, 960);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("King of the Clouds Game");
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
		
		//centerPanel = new JPanel();
		ImageIcon img = new ImageIcon(guiFrame.class.getResource("menu2.png"));
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1360, 960);
       // background.setPreferredSize(new Dimension(500,600));
        this.add(background);
		//this.add(centerPanel, BorderLayout.CENTER);
		
        
        
	
	}
	
	

}
