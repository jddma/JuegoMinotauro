package juego;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	public void DefinirVentana() throws Exception {
		add(new Board());
        setResizable(false);
        pack();
        
        setTitle("Minotauro");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation( EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        (new Game()).DefinirVentana();;         
    }
	
}
