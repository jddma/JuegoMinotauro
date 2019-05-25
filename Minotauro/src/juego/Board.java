package juego;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {
    //Permite lanzar constantemente eventos de tipo ActionListener.
    private Timer timer;    
    private Circle circle;
    private Muro[]muros;
    private final int DELAY = 10;
    private final int B_WIDTH = 1024;
    private final int B_HEIGHT = 512;
    
    public Board() throws Exception {
       initBoard();
    }
    
    private void initBoard() throws Exception {
        //Adiciona la clase que permite gestionar los eventos del teclado.
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        //Objetos del juego.
        circle = new Circle(0,0,30,30);
        
        //El constructor indica cada cuanto tiempo debe lanzar un ActionListener
        timer = new Timer(DELAY, this);
        timer.start();        
    }


    private Muro[] DefinirMuros() {
    	Muro[]muros=new Muro[6];
    	muros[0]=new Muro(30,10,5,470);
    	muros[1]=new Muro(30,10,980,5);
    	muros[2]=new Muro(980+30,10,5,470);
    	muros[3]=new Muro(30,480,460,5);
    	muros[4]=new Muro(530,480,485,5);
    	muros[5]=new Muro(490,250,5,235);
    	
    	return muros;
    }
    
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;     
       g2d.setColor(Color.RED);
       g2d.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
       /*
       Graphics2D wall = (Graphics2D) g;
       wall.setColor(Color.BLUE);
       wall.fillRect(muro.x, muro.y , muro.width, muro.height);*/
       
       muros=DefinirMuros();
       Graphics2D[]wall=new Graphics2D[muros.length];
       for(int i=0; i<muros.length; i++)
       {
    	   wall[i]= (Graphics2D) g;
           wall[i].setColor(Color.BLUE);
           wall[i].fillRect(muros[i].x, muros[i].y , muros[i].width, muros[i].height);
       }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circle.move(muros);
        repaint();  
    }
        
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            circle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            circle.keyPressed(e);
        }
    }
}
