package pl.edu.pw.fizyka.pojava.Kasprzak_Kurowska;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Wiktoria Kasprzak
public class GameLoop implements ActionListener{
	//klasa podpiêta do timera w GamePanel, zatem cyklicznie bedzie wywolywana metoda doOneLoop, ktora odpowiada za poruszanie siê obiektów
	private GamePanel gamePanel;
	
	public GameLoop(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.gamePanel.doOneLoop();
		
	}

}

