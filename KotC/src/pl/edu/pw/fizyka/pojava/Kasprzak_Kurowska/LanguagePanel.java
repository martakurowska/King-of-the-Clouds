package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JPanel;

public class LanguagePanel implements ActionListener{
	
	public Locale enLocale = new Locale("en", "GB");
	public Locale plLocale = new Locale("pl", "PL"); 				//Locale jest u�ywane do identyfikacji obiekt�w 
	public Locale frLocale = new Locale("fr", "FR"); 			//a nie jest samo w sobie kontenerem dla obiekt�w
	public Locale ruLocale = new Locale("ru", "RU"); 
	public Locale svLocale = new Locale("sv", "SE"); 
	 
	private JButton polish, english, french, russian, swedish; 
	JPanel panelSetup;
	Icon imageFlag;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public DifficultyFrame difficultyFrame;
	public ResourceBundle languageBundle;
	public GuiFrame guiFrame;
	public EscapeDialogPanel dialogFrame;

	public void setButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
	}
	
	public LanguagePanel(GuiFrame gui, DifficultyFrame difficulty, EscapeDialogPanel dialog) {
		
		panelSetup = new JPanel();
		panelSetup.setOpaque(false);
		panelSetup.setLayout(new GridBagLayout());
		languageBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp");
		
		guiFrame = gui;
		difficultyFrame = difficulty;
		dialogFrame = dialog;
		
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = -35;
        c.ipady = -98;
        c.insets = new Insets(40, 70, 40, 70);

        c.gridx = 0;
        c.gridy = 0;
        
        imageFlag = new ImageIcon(getClass().getResource("others/flags/uk.png"));
        english = new JButton(imageFlag);
        setButton(english);
        english.setActionCommand("english");
        panelSetup.add(english, c);
       
        c.gridx = 1;
        c.gridy = 0;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/poland.png"));
        polish = new JButton(imageFlag);
        setButton(polish);
        polish.setActionCommand("polish");
        panelSetup.add(polish, c);
        
        c.gridx = 0;
        c.gridy = 1;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/france.png"));
        french = new JButton(imageFlag);
        setButton(french);
        french.setActionCommand("french");
        panelSetup.add(french, c);
        
        c.gridx = 1;
        c.gridy = 1;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/russia.png"));
        russian = new JButton(imageFlag);
        setButton(russian);
        russian.setActionCommand("russian");
        panelSetup.add(russian, c);

        c.gridx = 0;
        c.gridy = 2;
        imageFlag = new ImageIcon(getClass().getResource("others/flags/sweden.png"));
        swedish = new JButton(imageFlag);
        setButton(swedish);
        swedish.setActionCommand("swedish");
        panelSetup.add(swedish, c);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "english") {
			LanguagePanel language = new LanguagePanel(guiFrame, difficultyFrame, dialogFrame);
			changingLanguageOnGuiFrame(enLocale); 
			changingLanguageOnDifficultyFrame(enLocale);
			changeEscapeDialogPanel(enLocale);
        } 
        else if (e.getActionCommand() == "polish") {	
        	LanguagePanel language = new LanguagePanel(guiFrame, difficultyFrame, dialogFrame);
			changingLanguageOnGuiFrame(plLocale); 
			changingLanguageOnDifficultyFrame(plLocale);
			changeEscapeDialogPanel(plLocale);
        }
        else if (e.getActionCommand() == "french") {  
        	LanguagePanel language = new LanguagePanel(guiFrame, difficultyFrame, dialogFrame);
			changingLanguageOnGuiFrame(frLocale); 
			changingLanguageOnDifficultyFrame(frLocale);
			changeEscapeDialogPanel(frLocale);
        }
        else if (e.getActionCommand() == "russian") {  
        	LanguagePanel language = new LanguagePanel(guiFrame, difficultyFrame, dialogFrame);
			changingLanguageOnGuiFrame(ruLocale); 
			changingLanguageOnDifficultyFrame(ruLocale);
			changeEscapeDialogPanel(ruLocale);
        }
        else if (e.getActionCommand() == "swedish") {
        	LanguagePanel language = new LanguagePanel(guiFrame, difficultyFrame, dialogFrame);
			changingLanguageOnGuiFrame(svLocale);
			changingLanguageOnDifficultyFrame(svLocale);
			changeEscapeDialogPanel(svLocale);
        } 
	}
	
	public JPanel setUpLanguages() {
		return panelSetup;
	}
 
 	public void changingLanguageOnGuiFrame(Locale newLocale) {
		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
		guiFrame.newGameBtn.setText(newBundle.getString("newgame"));
		guiFrame.loadGameBtn.setText(newBundle.getString("loadgame"));
		guiFrame.levelChangeBtn.setText(newBundle.getString("levelChange"));
		guiFrame.settingsBtn.setText(newBundle.getString("settings"));
		guiFrame.exitGameBtn.setText(newBundle.getString("exit"));
		guiFrame.backToMenuButton.setText(newBundle.getString("backtomenu"));
		guiFrame.characterButton.setText(newBundle.getString("character")); 
		guiFrame.languageButton.setText(newBundle.getString("language"));
		guiFrame.soundButton.setText(newBundle.getString("sound"));
	} 
 	
 	public void changingLanguageOnDifficultyFrame(Locale newLocale) {
 		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
 		difficultyFrame.easyButton.setText(newBundle.getString("easy"));
 		difficultyFrame.normalButton.setText(newBundle.getString("normal"));
 		difficultyFrame.hardButton.setText(newBundle.getString("hard"));
 	}
 	
 	public void changeEscapeDialogPanel(Locale newLocale) {
 		ResourceBundle newBundle = ResourceBundle.getBundle("pl/edu/pw/fizyka/pojava/Kasprzak_Kurowska/properties/myProp", newLocale);
 		dialogFrame.label.setText(newBundle.getString("label"));
 		dialogFrame.noButton.setText(newBundle.getString("no"));
 		dialogFrame.yesButton.setText(newBundle.getString("yes"));
 	}
}
