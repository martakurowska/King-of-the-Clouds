import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class languagePanel implements ActionListener{
	
	JPanel panel;
	JButton english, polish, french, russian, swedish;
	Icon img;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    private Font font =new Font("Impact", Font.PLAIN, 34); 
	private Color color= new Color(225,108,164); 
    
	public languagePanel() {
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridBagLayout());
		
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 90;
        c.ipady = -10;
        //c.insets = new Insets(0, 0, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        
        img = new ImageIcon(getClass().getResource("others/uk.png"));
        english = new JButton(img);
        english.setBorderPainted(false);
        english.setFocusPainted(false);
        english.setContentAreaFilled(false);
        english.addActionListener(this);
        english.setActionCommand("english");
        panel.add(english, c);
       
        c.gridx = 1;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/poland.png"));
        polish = new JButton(img);
        polish.setBorderPainted(false);
        polish.setFocusPainted(false);
        polish.setContentAreaFilled(false);
        polish.addActionListener(this);
        polish.setActionCommand("polish");
        panel.add(polish, c);
        
        c.gridx = 0;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/france.png"));
        french = new JButton(img);
        french.setBorderPainted(false);
        french.setFocusPainted(false);
        french.setContentAreaFilled(false);
        french.addActionListener(this);
        french.setActionCommand("french");
        panel.add(french, c);
        
        c.gridx = 1;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/russia.png"));
        russian = new JButton(img);
        russian.setBorderPainted(false);
        russian.setFocusPainted(false);
        russian.setContentAreaFilled(false);
        russian.addActionListener(this);
        russian.setActionCommand("russian");
        panel.add(russian, c);

        c.gridx = 0;
        c.gridy = 2;
        img = new ImageIcon(getClass().getResource("others/sweden.png"));
        swedish = new JButton(img);
        swedish.setBorderPainted(false);
        swedish.setFocusPainted(false);
        swedish.setContentAreaFilled(false);
        swedish.addActionListener(this);
        swedish.setActionCommand("swedish");
        panel.add(swedish, c);
        
       
        
        
        
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "english") {
			
        } 
        else if (e.getActionCommand() == "polish") {
        	
        }
        else if (e.getActionCommand() == "french") {
        	
        }
        else if (e.getActionCommand() == "russian") {
        	
        }
        else if (e.getActionCommand() == "swedish") {
        	
        }
	}
	
	public JPanel setUpLanguages() {
		return panel;
	}
}
