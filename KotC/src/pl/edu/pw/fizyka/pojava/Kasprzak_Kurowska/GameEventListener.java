package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameEventListener extends KeyAdapter {

	GamePanel board;
	
	public GameEventListener (GamePanel board) {
		this.board = board; 
	}
	
	public void KeyReleased (KeyEvent e) {
		this.board.keyReleased(e); 
	}
	
	public void KeyPressed (KeyEvent e) {
		this.board.keyPressed(e);
		
	}
}
