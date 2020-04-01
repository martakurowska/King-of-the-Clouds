import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;
import javax.swing.*;

public class escapeDialogPanel extends JFrame implements ActionListener{
	
	public ResourceBundle bundle; 
	public JPanel panel, panelTop; 
	public JLabel lbl;
	public JButton no, yes;
	private Font font; 
	private Color color1, color2; 
	private guiFrame guiFrame; 
	int x, y;
	
	public escapeDialogPanel(guiFrame gui) {
		bundle = ResourceBundle.getBundle("myProp"); 
		guiFrame = gui;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,120);
		this.setTitle("Choose");
		this.setResizable(false);
		x = (guiFrame.screenWidth/2)-(this.getWidth()/2);
		y = (guiFrame.screenHeight/2)-(this.getHeight()/2);
		this.setLocation(x, y);
		font = new Font("Impact", Font.PLAIN, 20);  
		color1 = new Color(225,108,164);	
		color2 = new Color(251, 211, 224);
		
		panel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		panel.setBackground(color2);;
		panel.setLayout(new GridBagLayout());   
		
		panelTop = new JPanel();
        lbl = new JLabel(bundle.getString("label"));
        lbl.setFont(font);
        panelTop.setBackground(color2);
        lbl.setOpaque(false);
        panelTop.add(lbl);
        this.add(panelTop, BorderLayout.PAGE_START);
        
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;

        no = new JButton(bundle.getString("no"));
        no.setSelected(true);
        no.setFont(font);
        no.setSize(100, 100);
        no.setBackground(color1);
        no.addActionListener(this);
        no.setActionCommand("no");
        panel.add(no, c);
        
        c.gridx = 1;
        c.gridy = 1;
        yes = new JButton(bundle.getString("yes"));
        yes.setFont(font);
        yes.setSize(100, 100);
        yes.setBackground(color1);
        yes.addActionListener(this);
        yes.setActionCommand("yes");
        panel.add(yes, c);
        
        this.add(panel, BorderLayout.CENTER);
     
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "no") {
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
		else if (e.getActionCommand() == "yes") {	
			guiFrame.gamePanel.setVisible(false);
			guiFrame.menuPanel.setVisible(true);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}
