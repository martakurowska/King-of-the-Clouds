package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.ImageIcon;

//Wiktoria Kasprzak
public class Points extends Sprite implements Runnable{

	GamePanel gamePanel;
	public ImageIcon imageIcon; 
	ArrayList<ImageIcon> images = new ArrayList<ImageIcon>();
	private boolean visible = true; 
	Random rand = new Random();
	ExecutorService exec;
	
	public Points(GamePanel game) { 
		gamePanel = game;
		initialize();
	}
	
	private void initialize() {
		imageIcon = new ImageIcon(getClass().getResource("others/points/1.png")); 
		
		for(int ii = 0; ii < 9; ii++) {
			ImageIcon img = new ImageIcon(getClass().getResource("others/points/" + (ii + 1) + ".png"));
			images.add(img);
		}
	
		x = rand.nextInt((int) (gamePanel.guiFrame.getWidth() - imageIcon.getIconWidth()) * 2);
		setX(x);
		
		y = rand.nextInt(gamePanel.background.imageIcon.getIconHeight() - gamePanel.guiFrame.getHeight() * 2) * (-1);
		setY(y);
		
		dy = 2;
		
		exec = Executors.newFixedThreadPool(1);
	}

	@Override
	public void move() { 
		if(visible) {
			y += dy;
			exec.execute(this);
		}
	}

	public boolean isVisible() {
		return visible; 
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible; 
	}

	@Override
	public void run() {
		
		int ii = 0;
		
		while(gamePanel.isGameRunning) {
			
			if (ii < images.size() - 1)
				ii++;
			else
				ii = 0;
			
			this.setImage(images.get(ii).getImage());
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}