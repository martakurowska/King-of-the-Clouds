import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;


public class languagePanel implements ActionListener{
	
	public Locale enLocale = new Locale("en", "GB");
	public Locale plLocale = new Locale("pl", "PL"); 				//Locale jest u¿ywane do identyfikacji obiektów 
	public Locale frLocale = new Locale("fr", "FR"); 			//a nie jest samo w sobie kontenerem dla obiektów
	public Locale ruLocale = new Locale("ru", "RU"); 
	public Locale svLocale = new Locale("sv", "SE"); 
	
	private JButton polish, english, french, russian, swedish; 
	JPanel panel;
	Icon img;
	protected int screenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
    protected int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    private Font font =new Font("Impact", Font.PLAIN, 34); 
	private Color color= new Color(225,108,164); 
    public difficultyFrame difficultyFrame;
	public ResourceBundle bundle;
	public guiFrame guiFrame;

	public void setButton(JButton btn) {
		
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(this);
	}
	
	
	public languagePanel(guiFrame gui, difficultyFrame difficulty) {
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setLayout(new GridBagLayout());
		bundle = ResourceBundle.getBundle("myProp"); 
		
		guiFrame = gui;
		difficultyFrame = difficulty;
		
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 90;
        c.ipady = -10;
        //c.insets = new Insets(0, 0, 0, 0);

        c.gridx = 0;
        c.gridy = 0;
        
        img = new ImageIcon(getClass().getResource("others/uk.png"));
        english = new JButton(img);
        setButton(english);
        english.setActionCommand("english");
        panel.add(english, c);
       
        c.gridx = 1;
        c.gridy = 0;
        img = new ImageIcon(getClass().getResource("others/poland.png"));
        polish = new JButton(img);
        setButton(polish);
        polish.setActionCommand("polish");
        panel.add(polish, c);
        
        c.gridx = 0;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/france.png"));
        french = new JButton(img);
        setButton(french);
        french.setActionCommand("french");
        panel.add(french, c);
        
        c.gridx = 1;
        c.gridy = 1;
        img = new ImageIcon(getClass().getResource("others/russia.png"));
        russian = new JButton(img);
        setButton(russian);
        russian.setActionCommand("russian");
        panel.add(russian, c);

        c.gridx = 0;
        c.gridy = 2;
        img = new ImageIcon(getClass().getResource("others/sweden.png"));
        swedish = new JButton(img);
        setButton(swedish);
        swedish.setActionCommand("swedish");
        panel.add(swedish, c);
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "english") {
			languagePanel language = new languagePanel(guiFrame, difficultyFrame);
			changingLanguageOnGuiFrame(enLocale); 
			changingLanguageOnDifficultyFrame(enLocale);
        } 
        else if (e.getActionCommand() == "polish") {	
        	languagePanel language = new languagePanel(guiFrame, difficultyFrame);
			changingLanguageOnGuiFrame(plLocale); 
			changingLanguageOnDifficultyFrame(plLocale);
        }
        else if (e.getActionCommand() == "french") {  
        	languagePanel language = new languagePanel(guiFrame, difficultyFrame);
			changingLanguageOnGuiFrame(frLocale); 
			changingLanguageOnDifficultyFrame(frLocale);
        }
        else if (e.getActionCommand() == "russian") {  
        	languagePanel language = new languagePanel(guiFrame, difficultyFrame);
			changingLanguageOnGuiFrame(ruLocale); 
			changingLanguageOnDifficultyFrame(ruLocale);
        }
        else if (e.getActionCommand() == "swedish") {
        	languagePanel language = new languagePanel(guiFrame, difficultyFrame);
			changingLanguageOnGuiFrame(svLocale);
			changingLanguageOnDifficultyFrame(svLocale);
        } 
	}
	
	public JPanel setUpLanguages() {
		return panel;
	}
 
 	public void changingLanguageOnGuiFrame(Locale newLocale) {
		ResourceBundle newbundle = ResourceBundle.getBundle("myProp", newLocale);
		guiFrame.newGameBtn.setText(newbundle.getString("newgame"));
		guiFrame.loadGameBtn.setText(newbundle.getString("loadgame"));
		guiFrame.levelChangeBtn.setText(newbundle.getString("levelChange"));
		guiFrame.settingsBtn.setText(newbundle.getString("settings"));
		guiFrame.exitGameBtn.setText(newbundle.getString("exit"));
		guiFrame.backToMenuButton.setText(newbundle.getString("backtomenu"));
		guiFrame.characterButton.setText(newbundle.getString("character")); 
		guiFrame.languageButton.setText(newbundle.getString("language"));
		guiFrame.soundButton.setText(newbundle.getString("sound"));
	} 
 	
 	public void changingLanguageOnDifficultyFrame(Locale newLocale) {
 		ResourceBundle newbundle = ResourceBundle.getBundle("myProp", newLocale);
 		difficultyFrame.easy.setText(newbundle.getString("easy"));
 		difficultyFrame.normal.setText(newbundle.getString("normal"));
 		difficultyFrame.hard.setText(newbundle.getString("hard"));
 	}
}
