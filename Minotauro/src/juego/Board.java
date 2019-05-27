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
    private final int DELAY = 15;
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
        circle = new Circle(455,475,30,30);
        
        //El constructor indica cada cuanto tiempo debe lanzar un ActionListener
        timer = new Timer(DELAY, this);
        timer.start();        
    }


    private Muro[] DefinirMuros() {	   	
    	return new Muro[]{new Muro(30,10,5,470),new Muro(30,10,980,5),new Muro(980+30,10,5,470),new Muro(30,480,425,5),new Muro(490,480,525,5),
			 new Muro(450,297,5,185),new Muro(490,257,5,225),new Muro(445,257,50,5),new Muro(400,297,50,5),new Muro(445,210,5,50),
			 new Muro(400,260,5,40),new Muro(75,220,375,5),new Muro(75,220,5,225),new Muro(75,445,340,5),new Muro(280,260,120,5),
			 new Muro(280,265,5,70),new Muro(280,335,50,5),new Muro(240,220,5,150),new Muro(240,370,130,5),new Muro(365,300,5,70),
			 new Muro(325,300,40,5),new Muro(365,335,45,5),new Muro(405,370,5,40),new Muro(405,370,45,5),new Muro(210,405,195,5),
			 new Muro(205,255,5,155),new Muro(170,225,5,150),new Muro(170,40,50,5)};
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
