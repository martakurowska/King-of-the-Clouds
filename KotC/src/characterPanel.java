import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class characterPanel extends JPanel implements ActionListener  {

	private JButton char1, char2, char3, char4, char5, char6; 
	JPanel panel; 
	Icon img; 
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    
    public void setButton(JButton btn) {
		
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
	}  
    
    
    public characterPanel() {
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
        img = new ImageIcon(getClass().getResource("others/balonMaly1.png"));
        char1 = new JButton(img);
        setButton(char1);
        char1.setActionCommand("yellow");
        panel.add(char1, c);
        
        c.gridx = 1;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/balonMaly2.png"));
        char2 = new JButton(img);
        setButton(char2);
        char1.setActionCommand("happy");
        panel.add(char2, c);
    	
        c.gridx = 2;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/balonMaly3.png"));
        char3 = new JButton(img);
        setButton(char3);
        char3.setActionCommand("orange");
        panel.add(char3, c);
    	
        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 80, 0, 80);
        img = new ImageIcon(getClass().getResource("others/balonMaly4.png"));
        char4 = new JButton(img);
        setButton(char4);
        char4.setActionCommand("blue");
        panel.add(char4, c);
        
        c.gridx = 1;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/balonMaly5.png"));
        char5 = new JButton(img);
        setButton(char5);
        char5.setActionCommand("moro");
        panel.add(char5, c);
        
        c.gridx = 2;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/balonMaly6.png"));
        char6 = new JButton(img);
        setButton(char6);
        char6.setActionCommand("crazy");
        panel.add(char6, c);
    }
    
    
    public JPanel setUpCharacter() {
		return panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "yellow") {
	
		} 
		else if (e.getActionCommand() == "happy") {	
			
		}
		else if (e.getActionCommand() == "orange") {  
    
		}
		else if (e.getActionCommand() == "blue") {  
    
		}
		else if (e.getActionCommand() == "moro") {
    
		} 
		else if (e.getActionCommand() == "crazy") {
				
		}	
	}
}