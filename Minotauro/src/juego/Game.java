package juego;

import javax.swing.JFrame;

public class Game extends JFrame{
	
	public Game() throws Exception {
        initUI();
    }
    
    private void initUI() throws Exception {
        add(new Board());
        setResizable(false);
        pack();
        
        setTitle("minotauro");
        setLocationRelativeTo(null);        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        try 
        {
            JFrame ex = new Game();                
            ex.setVisible(true);
        } 
        catch (Exception ex1)
        {
            ex1.printStackTrace();
        }
         
    }
	
}
