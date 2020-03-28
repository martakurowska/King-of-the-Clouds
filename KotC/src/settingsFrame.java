import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class settingsFrame extends JFrame {
	JLabel background;
	ImageIcon img;
	
	public settingsFrame(guiFrame gui) {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		try {
			img = new ImageIcon(getClass().getResource("settings.png"));
			background = new JLabel("",img,JLabel.CENTER);
			gui.add(background);
			repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
		
}
