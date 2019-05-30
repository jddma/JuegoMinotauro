package juego;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private final Rectangle Final=new Rectangle(458,217,25,25);
    
    public Board() throws Exception {
       initBoard();
    }
    
    private void initBoard() throws Exception {
        //Adiciona la clase que permite gestionar los eventos del teclado.
        addKeyListener(new TAdapter());
        setFocusable(true);
        
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
       
        //Objetos del juego.
        circle = new Circle(0,0,30,30);
        
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
			 new Muro(110,350,25,5),new Muro(30,185,385,5),new Muro(445,200,5,20),new Muro(445,200,50,5),new Muro(410,160,5,25),
			 new Muro(410,160,20,5),new Muro(460,45,5,160),new Muro(65,45,395,5),new Muro(375,125,90,5),new Muro(375,125,5,30),
			 new Muro(335,85,5,105),new Muro(335,85,90,5),new Muro(300,45,5,110),new Muro(270,150,30,5),new Muro(235,80,5,105),
			 new Muro(240,110,30,5),new Muro(270,75,30,5),new Muro(200,50,5,75),new Muro(145,120,60,5),new Muro(110,85,60,5),
			 new Muro(145,155,5,30),new Muro(200,125,5,30),new Muro(110,85,5,100),new Muro(65,50,5,100),new Muro(495,15,5,155),
			 new Muro(490,235,5,55),new Muro(495,165,35,5),new Muro(495,200,70,5),new Muro(560,130,5,70),new Muro(530,130,30,5),
			 new Muro(500,90,200,5),new Muro(700,90,5,75),new Muro(565,200,415/**/,5),new Muro(595,165,110,5),new Muro(565,130,105,5),
			 new Muro(700,200,40,5),new Muro(735,125,5,80),new Muro(705,90,240,5),new Muro(775,90,5,80),new Muro(810,125,5,75),
			 new Muro(815,125,90,5),new Muro(940,95,5,70),new Muro(845,165,100,5),new Muro(975,60,5,140),new Muro(531855,55,445,5),
			 new Muro(975,205,5,245),new Muro(525,445,450,5),new Muro(495,410,450,5),new Muro(940,235,5,180),new Muro(905,205,5,175),
			 new Muro(525,375,380,5),new Muro(495,340,380,5),new Muro(870,235,5,105),new Muro(835,205,5,105),new Muro(525,305,310,5),
			 new Muro(495,270,310,5),new Muro(800,235,5,35),new Muro(765,205,5,30),new Muro(730,235,5,35),new Muro(695,205,5,30),
			 new Muro(660,235,5,35),new Muro(625,205,5,30),new Muro(590,235,5,35),new Muro(545,205,5,30),new Muro(530,55,450,5)};
    }
    
    public void paintComponent(Graphics g) {
       super.paintComponent(g);
       Graphics2D g2d = (Graphics2D) g;     
       g2d.setColor(Color.RED);
       g2d.fillOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
 
       Graphics2D meta=(Graphics2D)g;
       meta.setColor(Color.YELLOW);
       meta.fillOval(Final.x,Final.y,Final.width,Final.height);
       
       muros=DefinirMuros();
       Graphics2D[]wall=new Graphics2D[muros.length];
       for(int i=0; i<muros.length; i++)
       {
    	   wall[i]= (Graphics2D) g;
           wall[i].setColor(Color.CYAN);
           wall[i].fill3DRect(muros[i].x, muros[i].y , muros[i].width, muros[i].height,true);
       }
    }

    public void actionPerformed(ActionEvent e) {
    	if(circle.getBounds().intersects(Final))
    	{
    		JOptionPane.showMessageDialog(null,"　　　　GANASTE!!!!!!!!!!","FIN",JOptionPane.INFORMATION_MESSAGE,null);
    		try 
    		{
				circle=new Circle(0,0,30,30);
			} 
    		catch (Exception ex) 
    		{
				ex.printStackTrace();
			}
    	}   		
    	else
	        circle.move(muros);

    	setVisible(true);
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
