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
	
	public void setButton(JButton btn) {
		btn.addActionListener(this);
		btn.setFont(font); 
		btn.setBackground(color); 
		btn.setForeground(Color.BLACK);
		btn.setFocusPainted(false);
		panel.add(btn);
	}
	
	public difficultyFrame(guiFrame guiFrame) {
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300,200);
		setTitle("Choose your level");
		setResizable(false);
		font = new Font("Impact", Font.PLAIN, 34);   								 
		color = new Color(225,108,164);	
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1)); 
		
		this.setFont(font);
		this.setBackground(color);
		this.setForeground(Color.BLACK);
		bundle = ResourceBundle.getBundle("myProp"); 
		
 		easy = new JButton(bundle.getString("easy")); 
		easy.setActionCommand("Easy"); 
		setButton(easy);
	
		
		normal = new JButton(bundle.getString("normal")); 
		normal.setActionCommand("Normal"); 
		setButton(normal);
	
		
		hard = new JButton(bundle.getString("hard")); 
		hard.setActionCommand("Hard"); 
		setButton(hard);
	
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
