package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DifficultyFrame extends JFrame implements ActionListener {
	
	public ResourceBundle languageBundle; 
	public JPanel panelSetup; 
	public JButton easyButton, normalButton, hardButton; 
	private Font defaultFont; 
	private Color colorOfButton; 
	int width, height;
	int balloonSpeed = 10;
	public static final int gameSpeed = 10; 
	
	public void setButton(JButton btn) {
		btn.addActionListener(this);
		btn.setFont(defaultFont); 
		btn.setBackground(colorOfButton); 
		btn.setForeground(Color.BLACK);
		btn.setFocusPainted(false);
		panelSetup.add(btn);
	} 
	
	public DifficultyFrame(GuiFrame guiFrame) {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,200);
		this.setTitle("Choose your level");
		this.setResizable(false);
		width = (guiFrame.screenWidth/2)-(this.getWidth()/2);
		height = (guiFrame.screenHeight/2)-(this.getHeight()/2);
		this.setLocation(width, height);
		defaultFont = new Font("Impact", Font.PLAIN, 34);   								 
		colorOfButton = new Color(225,108,164);	
		
		panelSetup = new JPanel();
		panelSetup.setLayout(new GridLayout(3,1)); 
		
		this.setFont(defaultFont);
		this.setBackground(colorOfButton);
		this.setForeground(Color.BLACK);
		languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
		
 		easyButton = new JButton(languageBundle.getString("easy")); 
 		easyButton.addActionListener(this);
		easyButton.setActionCommand("Easy"); 
		setButton(easyButton);
	
		
		normalButton = new JButton(languageBundle.getString("normal")); 
		normalButton.addActionListener(this);
		normalButton.setActionCommand("Normal"); 
		setButton(normalButton);
	
		
		hardButton = new JButton(languageBundle.getString("hard")); 
		hardButton.addActionListener(this);
		hardButton.setActionCommand("Hard"); 
		setButton(hardButton);
	
		this.add(panelSetup);
		
	} 
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Easy") {
	       balloonSpeed = 15;
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getActionCommand() == "Normal") {
			balloonSpeed = 10;
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getActionCommand() == "Hard") {
			balloonSpeed = 5;
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
			
	}
}


