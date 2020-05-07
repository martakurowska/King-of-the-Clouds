package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//Marta Kurowska
public class EscapeDialogFrame extends JFrame implements ActionListener {
	
	public JPanel panelSetup, panelTopSetup; 
	public JLabel label;
	public JButton noButton, yesButton;
	private Font defaultFont; 
	private Color colorOfButton, colorOfDialog; 
	private GuiFrame guiFrame; 
	int width, height;
	
	public EscapeDialogFrame(GuiFrame gui) {
		guiFrame = gui;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300,120);
		this.setTitle("Choose");
		this.setResizable(false);
		width = (guiFrame.screenWidth/2)-(this.getWidth()/2);
		height = (guiFrame.screenHeight/2)-(this.getHeight()/2);
		this.setLocation(width, height);
		defaultFont = new Font("Impact", Font.PLAIN, 20);  
		colorOfButton = new Color(225,108,164);	
		colorOfDialog = new Color(251, 211, 224);
		
		panelSetup = new JPanel(); 
		panelSetup.setLayout(new BorderLayout());
		panelSetup.setBackground(colorOfDialog);;
		panelSetup.setLayout(new GridBagLayout());   
		
		panelTopSetup = new JPanel();
        label = new JLabel(guiFrame.languageBundle.getString("label"));
        label.setFont(defaultFont);
        panelTopSetup.setBackground(colorOfDialog);
        label.setOpaque(false);
        panelTopSetup.add(label);
        this.add(panelTopSetup, BorderLayout.PAGE_START);
        
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = 0;
        constraints.ipady = 0;
        constraints.gridx = 0;
        constraints.gridy = 1;

        noButton = new JButton(guiFrame.languageBundle.getString("no"));
        noButton.setSelected(true);
        noButton.setFont(defaultFont);
        noButton.setSize(100, 100);
        noButton.setBackground(colorOfButton);
        noButton.addActionListener(this);
        noButton.setActionCommand("no");
        panelSetup.add(noButton, constraints);
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        yesButton = new JButton(guiFrame.languageBundle.getString("yes"));
        yesButton.setFont(defaultFont);
        yesButton.setSize(100, 100);
        yesButton.setBackground(colorOfButton);
        yesButton.addActionListener(this);
        yesButton.setActionCommand("yes");
        panelSetup.add(yesButton, constraints);
        
        this.add(panelSetup, BorderLayout.CENTER);
     
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//jesli "no" to gra sie wznawia, okienko sie zamyka, jesli "yes" to timer.stop() czyli funkcja doOneLoop zatrzymuje sie, zapisywane sa zycia i uzyskane punkty, wracamy do menu
		if (e.getActionCommand() == "no") {
			guiFrame.gamePanel.isGameRunning = true;
			guiFrame.gamePanel.timer.start();
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		} 
		else if (e.getActionCommand() == "yes") {
			guiFrame.gamePanel.timer.stop();
			guiFrame.menuPanel.lives = guiFrame.gamePanel.balloon.lives;
			guiFrame.isGameActive = false;
			guiFrame.container.remove(guiFrame.gamePanel);
			guiFrame.container.remove(guiFrame.menuPanel);
			guiFrame.container.add(guiFrame.menuPanel);
			guiFrame.menuPanel.setVisible(true);
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
}