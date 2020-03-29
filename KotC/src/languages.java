/*import java.awt.*;
import java.awt.Color; 
import javax.swing.*;
import javax.sound.sampled.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Locale; 					//klasa reprezentuj¹ca regiony polityczne, jêzykowe, kulturalne, geograficzne
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class languages extends JFrame implements ActionListener  {

	public guiFrame guiFrame; 
	public languagePanel languagePanel; 
	public ResourceBundle bundle;
	public Locale enLocale = new Locale("en", "EN");
	public Locale plLocale = new Locale("pl", "PL"); 				//Locale jest u¿ywane do identyfikacji obiektów 
	public Locale frLocale = new Locale("fr", "FR"); 			//a nie jest samo w sobie kontenerem dla obiektów
	public Locale ruLocale = new Locale("ru", "RU"); 
	public Locale svLocale = new Locale("sv", "SE"); 
	
	GridBagConstraints c; 
	private Font font; 
	private Color color; 
	
	private JButton polish, english, french, russian, swedish; 
	
	public languages () {
		
		font = new Font("Impact", Font.PLAIN, 15); 
		color = new Color(225,108,164);
		
		GridBagConstraints c = new GridBagConstraints(); 
		c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 1;
        c.insets = new Insets(15, 0, 0, 0);
        c.gridx = 5;
        c.gridy = 0;
        bundle = ResourceBundle.getBundle("guiFrame/myProp"); 
        
        c.gridy = 1;
        polish = new JButton(bundle.getString("pol"));
        polish.setActionCommand("polish");
        polish.addActionListener(this);
        polish.setFont(font);
        polish.setBackground(color);
        polish.setForeground(Color.BLACK); 
        this.add(polish);
        
        english = new JButton(bundle.getString("eng"));
        english.setActionCommand("english");
        english.addActionListener(this);
        english.setFont(font);
        english.setBackground(color); 
        english.setForeground(Color.BLACK);
        this.add(english);
        
        french = new JButton(bundle.getString("fren"));
        french.setActionCommand("french");
        french.addActionListener(this);
        french.setFont(font);
        french.setBackground(color); 
        french.setForeground(Color.BLACK);
        this.add(french);
        
        russian = new JButton(bundle.getString("ru"));
        russian.setActionCommand("russian");
        russian.addActionListener(this);
        russian.setFont(font);
        russian.setBackground(color);
        russian.setForeground(Color.BLACK);
        this.add(russian); 
        
        swedish = new JButton(bundle.getString("sv")); 
        swedish.setActionCommand("swedish"); 
        swedish.addActionListener(this);
        swedish.setFont(font); 
        swedish.setBackground(color);
        swedish.setForeground(Color.BLACK); 
        
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "polish":{
			                     	
			changingLanguageOnGuiFrame(plLocale);  //zmiana w klasie guiFrame
	 		}
		case "english":{
			  	
			changingLanguageOnGuiFrame(enLocale); 
			}
		case "french":{
			   	
			changingLanguageOnGuiFrame(frLocale); 
			}
		case "russian":{
				
			changingLanguageOnGuiFrame(ruLocale); 
		    }
		case "swedish":{
			  	
			changingLanguageOnGuiFrame(svLocale); 
     		}
		
		}	  		
		
	} 
	
	
	public void changingLanguageOnGuiFrame(Locale newLocale) {
		ResourceBundle newbundle = ResourceBundle.getBundle("guiFrame/myProp", newLocale);
		guiFrame.newGameBtn.setText(newbundle.getString("newGame"));
		guiFrame.loadGameBtn.setText(newbundle.getString("loadGame"));
		guiFrame.levelChangeBtn.setText(newbundle.getString("levelChange"));
		guiFrame.settingsBtn.setText(newbundle.getString("settings"));
		guiFrame.exitGameBtn.setText(newbundle.getString("exitGame"));	
		guiFrame.
	}
	
	
} */
