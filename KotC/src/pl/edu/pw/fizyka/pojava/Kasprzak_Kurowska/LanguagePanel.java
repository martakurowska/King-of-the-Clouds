package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JPanel;

//Marta Kurowska: layout, konstruktor + metoda setButton(), Wiktoria Kasprzak: actionListener,
//Wspólnie: metody zmieniaj¹ce jêzyk
public class LanguagePanel implements ActionListener{
	
	public Locale enLocale = new Locale("en", "GB");
	public Locale plLocale = new Locale("pl", "PL"); 				//Locale jest uzywane do identyfikacji obiektow 
	public Locale frLocale = new Locale("fr", "FR"); 			//a nie jest samo w sobie kontenerem dla obiektow
	public Locale ruLocale = new Locale("ru", "RU"); 
	public Locale svLocale = new Locale("sv", "SE"); 
	 
	private JButton polish, english, french, russian, swedish; 
	JPanel panelSetup;
	Icon imageFlag;
	GridBagConstraints constraints;
	public ResourceBundle languageBundle;
	public MenuPanel menuPanel;
	public SettingsPanel settingsPanel;
	public GuiFrame guiFrame;

	public void setButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
		panelSetup.add(btn, constraints);
	}
	
	public LanguagePanel(MenuPanel menu, SettingsPanel settings, GuiFrame gui) {
		
		panelSetup = new JPanel();
		panelSetup.setOpaque(false);
		panelSetup.setLayout(new GridBagLayout());
		languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
		
		menuPanel = menu;
		guiFrame = gui;
		settingsPanel = settings;
		
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = -35;
        constraints.ipady = -98;
        constraints.insets = new Insets(40, 70, 40, 70);

        constraints.gridx = 0;
        constraints.gridy = 0;  
        imageFlag = new ImageIcon(getClass().getResource("others/flags/uk.png"));
        english = new JButton(imageFlag);
        setButton(english);
        english.setActionCommand("english");
       
        constraints.gridx = 1;
        constraints.gridy = 0;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/poland.png"));
        polish = new JButton(imageFlag);
        setButton(polish);
        polish.setActionCommand("polish");
        
        constraints.gridx = 0;
        constraints.gridy = 1;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/france.png"));
        french = new JButton(imageFlag);
        setButton(french);
        french.setActionCommand("french");
        
        constraints.gridx = 1;
        constraints.gridy = 1;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/russia.png"));
        russian = new JButton(imageFlag);
        setButton(russian);
        russian.setActionCommand("russian");

        constraints.gridx = 0;
        constraints.gridy = 2;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/sweden.png"));
        swedish = new JButton(imageFlag);
        setButton(swedish);
        swedish.setActionCommand("swedish");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "english") {
			changingLanguageOnGuiFrame(enLocale); 
			changingLanguageOnDifficultyFrame(enLocale);
			changeElementsOfGamePanel(enLocale);
			changingLanguageOnSettingsPanel(enLocale);
        } 
        else if(e.getActionCommand() == "polish") {	
			changingLanguageOnGuiFrame(plLocale); 
			changingLanguageOnDifficultyFrame(plLocale);
			changeElementsOfGamePanel(plLocale);
			changingLanguageOnSettingsPanel(plLocale);
        }
        else if(e.getActionCommand() == "french") {  
			changingLanguageOnGuiFrame(frLocale); 
			changingLanguageOnDifficultyFrame(frLocale);
			changeElementsOfGamePanel(frLocale);
			changingLanguageOnSettingsPanel(frLocale);
        }
        else if(e.getActionCommand() == "russian") {  
			changingLanguageOnGuiFrame(ruLocale); 
			changingLanguageOnDifficultyFrame(ruLocale);
			changeElementsOfGamePanel(ruLocale);
			changingLanguageOnSettingsPanel(ruLocale);
        }
        else if(e.getActionCommand() == "swedish") {
			changingLanguageOnGuiFrame(svLocale);
			changingLanguageOnDifficultyFrame(svLocale);
			changeElementsOfGamePanel(svLocale);
			changingLanguageOnSettingsPanel(svLocale);
        } 
	}
	
	public JPanel setUpLanguages() {
		return panelSetup;
	}
 
 	public void changingLanguageOnGuiFrame(Locale newLocale) {
		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
		menuPanel.newGameBtn.setText(newBundle.getString("newgame"));
		menuPanel.loadGameBtn.setText(newBundle.getString("loadgame"));
		menuPanel.saveBtn.setText(newBundle.getString("savegame"));
		menuPanel.settingsBtn.setText(newBundle.getString("settings"));
		menuPanel.exitGameBtn.setText(newBundle.getString("exit"));
	} 
 	
 	public void changingLanguageOnSettingsPanel(Locale newLocale) {
 		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
 		settingsPanel.backToMenuButton.setText(newBundle.getString("backtomenu"));
 		settingsPanel.characterButton.setText(newBundle.getString("character")); 
 		settingsPanel.languageButton.setText(newBundle.getString("language"));
 		settingsPanel.difficultyButton.setText(newBundle.getString("levelChange"));
 		settingsPanel.soundButton.setText(newBundle.getString("sound"));
 	}
 	
 	public void changingLanguageOnDifficultyFrame(Locale newLocale) {
 		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
 		settingsPanel.difficultyPanel.easyButton.setText(newBundle.getString("easy"));
 		settingsPanel.difficultyPanel.normalButton.setText(newBundle.getString("normal"));
 		settingsPanel.difficultyPanel.hardButton.setText(newBundle.getString("hard"));
 	}
 	
 	public void changeElementsOfGamePanel(Locale newLocale) {
 		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
 		guiFrame.escapeDialog.label.setText(newBundle.getString("label"));
 		guiFrame.escapeDialog.noButton.setText(newBundle.getString("no"));
 		guiFrame.escapeDialog.yesButton.setText(newBundle.getString("yes"));
 		guiFrame.youWon = newBundle.getString("youwon");
 		guiFrame.gameOver = newBundle.getString("gameover");
 	}
}
