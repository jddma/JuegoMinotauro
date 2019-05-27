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
        circle = new Circle(305,50,30,30);
        
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
			 new Muro(205,255,5,155),new Muro(170,225,5,150),new Muro(140,405,65,5),new Muro(135,255,5,155),new Muro(80,305,25,5),
			 new Muro(110,350,25,5),new Muro(30,185,385,5),new Muro(445,200,5,20),new Muro(445,200,60,5),new Muro(410,160,5,25),
			 new Muro(410,160,20,5),new Muro(460,45,5,160),new Muro(65,45,395,5),new Muro(375,125,90,5),new Muro(375,125,5,30),
			 new Muro(335,85,5,105),new Muro(335,85,90,5),new Muro(300,45,5,110),new Muro(270,150,30,5),new Muro(235,80,5,105),
			 new Muro(240,110,30,5),new Muro(270,75,30,5),new Muro(200,50,5,75),new Muro(145,120,60,5),new Muro(120,85,40,5)};
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

    public void actionPerformed(ActionEvent e) {
        circle.move(muros);
        repaint();  
    }
        
    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            circle.keyReleased(e);
        }

        public void keyPressed(KeyEvent e) {
            circle.keyPressed(e);
        }
    }
}
