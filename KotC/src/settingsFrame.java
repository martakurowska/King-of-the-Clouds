import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class settingsFrame extends JPanel {
	
	JPanel settingsPanel, leftPanel, rightPanel;
	JButton soundButton, languageButton, characterButton, backToMenuButton;
	ImageIcon img;
	private Font font; 
	private Color color; 
	settingsScreenHandler ssHandler = new settingsScreenHandler();
	
	public settingsFrame() {
		settingsPanel = new JPanel() {
			@Override
		    public void paintComponent(Graphics G) {
		        super.paintComponent(G);
		        img = new ImageIcon(getClass().getResource("others/settings.png"));
		        G.drawImage(img.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		    }
		};
		settingsPanel.setBounds(0,0,1360, 960);
		//settingsPanel.setLayout(new BorderLayout());
		
		font = new Font("Impact", Font.PLAIN, 34);   								//ustawienia czcionki na przycisku 
		color = new Color(225,108,164);	
		
		characterButton = new JButton("character");
		characterButton.setFont(font);
		characterButton.setBackground(color);
		characterButton.setForeground(Color.BLACK);
        //character.setActionCommand("character");
 //     character.addActionListener(ssHandler);
		settingsPanel.add(characterButton);

        languageButton = new JButton("language");
        languageButton.setFont(font);
        languageButton.setBackground(color); 
        languageButton.setForeground(Color.BLACK);
        //language.setActionCommand("language");
     // language.addActionListener(ssHandler);
        settingsPanel.add(languageButton);

        soundButton = new JButton("sound");
        soundButton.setFont(font);
        soundButton.setBackground(color);
        soundButton.setForeground(Color.BLACK);
        //sound.setActionCommand("sound");
     // sound.addActionListener(ssHandler);
        settingsPanel.add(soundButton);

        backToMenuButton = new JButton("back to menu");
        backToMenuButton.setFont(font);
        backToMenuButton.setBackground(color); 
        backToMenuButton.setForeground(Color.BLACK);
        //backtomenu.setActionCommand("backToMenu");
        //backtomenu.addActionListener(ssHandler);
        settingsPanel.add(backToMenuButton);
	}
	
	public JPanel setUpSettings() {
		return settingsPanel;
	}
	
	public class settingsScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "character") {
				//setFalse(isMenuActive);
				//setFalse(isSettingsActive);
	        } 
	        else if (e.getActionCommand() == "language") {
	        	//setFalse(isMenuActive);
	        	//setFalse(isSettingsActive);
	        } 
	        else if (e.getActionCommand() == "sound") {
	        	//setFalse(isSettingsActive);
	        }
	        else if (e.getActionCommand() == "backToMenu") {
	        	/*menuPanel.setVisible(false);
	        	settings = new settingsFrame();
	        	settingsPanel = settings.setUpSettings();
	        	con.add(settingsPanel);*/
	        }
	        else if (e.getActionCommand() == "exitgame") {
	            System.exit(0);
	        }
			
		}
	}
}
