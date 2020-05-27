package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

//Marta Kurowska
public class MenuPanel extends JPanel {
	
	MenuScreenHandler msHandler = new MenuScreenHandler();
	GuiFrame guiFrame;
	Font defaultFont = new Font("Impact", Font.PLAIN, 34);   								
	Color colorOfButton = new Color(225,108,164);
	ArrayList<Integer> data;
	public JButton newGameBtn, loadGameBtn, exitGameBtn, settingsBtn, saveBtn;
	ImageIcon menuImage, points, livesIcon;
	GridBagConstraints constraints;
	//domyslnie gracz ma 0 pkt i 3 zycia
	int score = 0, lives = 3;
	
	//metoda ustawiajaca wyglad przyciskow
	public void setButton(JButton btn) {
		btn.setFont(defaultFont);
        btn.setBackground(colorOfButton); 
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.addActionListener(msHandler);
        this.add(btn, constraints);
	}
	
	public MenuPanel(GuiFrame gui) {
			
        guiFrame = gui;
		this.setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.ipadx = 150;
        constraints.ipady = 15;
        constraints.insets = new Insets(160, 0, 0, 0);

        constraints.gridx = 0;    
        constraints.gridy = 0;
    	defaultFont = new Font("Impact", Font.PLAIN, 34);   								
		colorOfButton = new Color(225,108,164);											
        newGameBtn = new JButton(guiFrame.languageBundle.getString("newgame"));
        setButton(newGameBtn);
        newGameBtn.setActionCommand("newgame");

        constraints.gridy = 1;
        constraints.insets = new Insets(15, 0, 0, 0);
        loadGameBtn = new JButton(guiFrame.languageBundle.getString("loadgame"));
        setButton(loadGameBtn);
        loadGameBtn.setActionCommand("loadgame");

        constraints.gridy = 2;
        saveBtn = new JButton(guiFrame.languageBundle.getString("savegame"));
        setButton(saveBtn);
        saveBtn.setActionCommand("savegame");

        constraints.gridy = 3;
        settingsBtn = new JButton(guiFrame.languageBundle.getString("settings"));
        setButton(settingsBtn);
        settingsBtn.setActionCommand("settings");
        
        constraints.gridy = 4;
        exitGameBtn = new JButton(guiFrame.languageBundle.getString("exit"));
        setButton(exitGameBtn);
        exitGameBtn.setActionCommand("exitgame");
		
	}

	@Override
	public void paintComponent(Graphics g) {
		//drukowanie tla, ilosci punktow i zyc
		super.paintComponent(g);
		menuImage = new ImageIcon(getClass().getResource("others/menu2.png"));
		g.drawImage(menuImage.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
		
		points = new ImageIcon(getClass().getResource("others/points/1.png"));
		g.drawImage(points.getImage(), 5, 5, this);	
		g.setColor(new Color(253,191,0));
		g.setFont(guiFrame.menuPanel.defaultFont);
		g.drawString(String.valueOf(score) , 64, 45);
		
		if(lives == 3) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/3lives.png")); 
		}
		else if(lives == 2) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/2lives.png")); 
		}
		else if(lives == 1) {
			livesIcon = new ImageIcon(getClass().getResource("others/hearts/1lives.png")); 
		}
		g.drawImage(livesIcon.getImage(), guiFrame.getWidth() - 197, 5, this);

	}
	
	public class MenuScreenHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "newgame") {
				//wyswietla panel gry
	        	MenuPanel.this.setVisible(false);
	        	guiFrame.gamePanel = new GamePanel(guiFrame);
	        	guiFrame.container.add(guiFrame.gamePanel);
	        	guiFrame.gamePanel.setVisible(true);
	        	guiFrame.isGameActive = true;   	
	        } 
	        else if (e.getActionCommand() == "loadgame") {
	        	//wczytuje zapisane w bazie danych informacje o ilosci zyc i punktow
	        	Connection conn = null;
	        	
	        	data = new ArrayList<Integer>();
	        	
	        	try {
					conn = DriverManager.getConnection(	"jdbc:h2:./data/database", "sa", "");
					
					Statement statement = conn.createStatement();
					
					//zapobiega bledom "tablica nie istnieje" gdy uzytkownik nigdy nie zapisal swojego wyniku, a postanowil kliknac wczytaj gre
					statement.executeUpdate("CREATE TABLE IF NOT EXISTS `score` ("+
							  "`Id` int(6) unsigned NOT NULL auto_increment,"+
							  "`points` int default NULL,"+
							  "`lives` int default NULL,"+
							  "PRIMARY KEY  (`Id`)"+
							") ;");
					
		        	statement.execute("SELECT * FROM score");
		        	
		        	ResultSet rs = statement.getResultSet();
					ResultSetMetaData md  = rs.getMetaData();
					
					while (rs.next()) {
			            for (int ii = 1; ii <= md.getColumnCount(); ii++){
			            	data.add((Integer) rs.getObject(ii));
			            }
			            //wczytanie zapisanych w bazie danych wrtoœci punktów i zyc
			            score = data.get(1);
						lives = data.get(2);
			        }
					//wywoluje metode paintComponent zeby odswierzyc informacje o punktach i zyciach
					repaint();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					if(conn != null) {
	    				try {
							conn.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
	    			}
				}
				
	        } 
	        else if (e.getActionCommand() == "savegame") {
	        	//zapisuje w bazie danych informacje o ilosci zyc i punktow
	        	Connection conn = null;
	        	try {
	        		
					conn = DriverManager.getConnection(	"jdbc:h2:./data/database", "sa", "");
					Statement statement = conn.createStatement();
					
					statement.executeUpdate("DROP TABLE IF EXISTS `score`;");
					
					statement.executeUpdate("CREATE TABLE `score` ("+
							  "`Id` int(6) unsigned NOT NULL auto_increment,"+
							  "`points` int default NULL,"+
							  "`lives` int default NULL,"+
							  "PRIMARY KEY  (`Id`)"+
							") ;");
					
					statement.executeUpdate("INSERT INTO `score` (`Id`,`points`,`lives`) VALUES (1, " + score + ", " + lives + ");");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
        			if(conn != null) {
        				try {
							conn.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
        			}
        		}
	        } 
	        else if (e.getActionCommand() == "settings") {
	        	//wyswietla panel ustawien
	        	MenuPanel.this.setVisible(false);
	        	guiFrame.container.add(guiFrame.settingsPanel);
	        	guiFrame.settingsPanel.setVisible(true);
	        	guiFrame.settingsPanel.add(guiFrame.settingsPanel.characterPanel, BorderLayout.CENTER);
	        	guiFrame.settingsPanel.characterPanel.setVisible(true);
	        }
	        else if (e.getActionCommand() == "exitgame") {
	        	//wyjscie z gry
	            System.exit(0);
	        } 
		}
	}
}