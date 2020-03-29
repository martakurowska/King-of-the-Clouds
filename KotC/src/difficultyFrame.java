import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class difficultyFrame extends JFrame implements ActionListener {
	
	public ResourceBundle bundle; 
	public JLabel label; 
	public JPanel panel; 
	public JButton easy, normal, hard, mammamia; 
	private Font font; 
	private Color color; 
	private guiFrame guiFrame; 
	
	public difficultyFrame(guiFrame guiFrame) {
		
		Locale.setDefault(new Locale("en","GB", "WIN"));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300,200);
		setTitle("Choose your level");
		setResizable(false);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1)); 
		font = new Font("Impact", Font.PLAIN, 34);   								 
		color = new Color(225,108,164);	
		this.setFont(font);
		this.setBackground(color);
		this.setForeground(Color.BLACK);
		bundle = ResourceBundle.getBundle("others/myProp"); 
		
 		easy = new JButton(/*bundle.getString("easy")*/"Easy"); 
		easy.setActionCommand("Easy"); 
		easy.addActionListener(this);
		easy.setFont(font); 
		easy.setBackground(color); 
		easy.setForeground(Color.BLACK);
		panel.add(easy);
	
		
		normal = new JButton(/*bundle.getString("normal")*/"Normal"); 
		normal.setActionCommand("Normal"); 
		normal.addActionListener(this);
		normal.setFont(font); 
		normal.setBackground(color); 
		normal.setForeground(Color.BLACK);
		panel.add(normal);
	
		
		hard = new JButton(/*bundle.getString("hard")*/"Hard"); 
		hard.setActionCommand("Hard"); 
		hard.addActionListener(this);
		hard.setFont(font); 
		hard.setBackground(color); 
		hard.setForeground(Color.BLACK);
		panel.add(hard);
	
		this.add(panel);
		
	} 
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Easy") {
			
		} else if (e.getActionCommand() == "Normal") {
			
		} else if (e.getActionCommand() == "Hard") {
			
		}
			
	}
	
}
