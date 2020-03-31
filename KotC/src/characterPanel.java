import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class characterPanel implements ActionListener  {

	private JButton char1, char2, char3, char4, char5, char6; 
	JPanel panel; 
	Icon img;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    guiFrame guiFrame;
    
    
    public void setButton(JButton btn) {
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
	}  
     
    public characterPanel(guiFrame gui) {
    	guiFrame = gui;
    	panel = new JPanel(); 
    	panel.setOpaque(false);
    	panel.setLayout(new GridBagLayout());   
    	GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = -280;
        c.ipady = -60;
        c.insets = new Insets(-90, 80, 50, 80);

        c.gridx = 0;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
        char1 = new JButton(img);
        setButton(char1);
        char1.addActionListener(this);
        char1.setActionCommand("yellow");
        panel.add(char1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
        char2 = new JButton(img);
        setButton(char2);
        char2.addActionListener(this);
        char2.setActionCommand("happy");
        panel.add(char2, c);
    	
        c.gridx = 2;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
        char3 = new JButton(img);
        setButton(char3);
        char3.addActionListener(this);
        char3.setActionCommand("orange");
        panel.add(char3, c);
    	
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 80, 0, 80);
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
        char4 = new JButton(img);
        char4.addActionListener(this);
        setButton(char4);
        char4.setActionCommand("blue");
        panel.add(char4, c);
        
        c.gridx = 1;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
        char5 = new JButton(img);
        setButton(char5);
        char5.addActionListener(this);
        char5.setActionCommand("moro");
        panel.add(char5, c);
        
        c.gridx = 2;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
        char6 = new JButton(img);
        setButton(char6);
        char6.addActionListener(this);
        char6.setActionCommand("crazy");
        panel.add(char6, c);
    }
    
    public JPanel setUpCharacter() {
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "yellow") {
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly1.png"));
		} 
		else if (e.getActionCommand() == "happy") {	
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly2.png"));
		}
		else if (e.getActionCommand() == "orange") {  
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly3.png"));
		}
		else if (e.getActionCommand() == "blue") {  
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly4.png"));
		}
		else if (e.getActionCommand() == "moro") {
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly5.png"));
		} 
		else if (e.getActionCommand() == "crazy") {
			guiFrame.balloon = new ImageIcon(getClass().getResource("others/balloons/balonMaly6.png"));
		}	
	}
}