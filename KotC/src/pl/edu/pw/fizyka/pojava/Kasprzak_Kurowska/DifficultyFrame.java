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
	
	public ResourceBundle bundle; 
	public JPanel panel; 
	public JButton easy, normal, hard; 
	private Font font; 
	private Color color; 
	int x, y;
	
	public void setButton(JButton btn) {
		btn.addActionListener(this);
		btn.setFont(font); 
		btn.setBackground(color); 
		btn.setForeground(Color.BLACK);
		btn.setFocusPainted(false);
		panel.add(btn);
	} 
	
	public DifficultyFrame(GuiFrame guiFrame) {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,200);
		this.setTitle("Choose your level");
		this.setResizable(false);
		x = (guiFrame.screenWidth/2)-(this.getWidth()/2);
		y = (guiFrame.screenHeight/2)-(this.getHeight()/2);
		this.setLocation(x, y);
		font = new Font("Impact", Font.PLAIN, 34);   								 
		color = new Color(225,108,164);	
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1)); 
		
		this.setFont(font);
		this.setBackground(color);
		this.setForeground(Color.BLACK);
		bundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
		
 		easy = new JButton(bundle.getString("easy")); 
 		easy.addActionListener(this);
		easy.setActionCommand("Easy"); 
		setButton(easy);
	
		
		normal = new JButton(bundle.getString("normal")); 
		normal.addActionListener(this);
		normal.setActionCommand("Normal"); 
		setButton(normal);
	
		
		hard = new JButton(bundle.getString("hard")); 
		hard.addActionListener(this);
		hard.setActionCommand("Hard"); 
		setButton(hard);
	
		this.add(panel);
		
	} 
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Easy") {
			
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getActionCommand() == "Normal") {
			
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} else if (e.getActionCommand() == "Hard") {
			
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
			
	}
}


