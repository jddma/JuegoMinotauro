package juego;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;



public class Circle extends Sprite{
	
    private int dx;
    private int dy;
    
    public Circle(int x, int y, int width, int height) throws Exception {
        super(x, y,width,height);
    }
   
    public void move(Rectangle muro) {  	
    	if(! getBounds().intersects(muro))
    	{
        x += dx;
        y += dy;
    	}
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
        }
        
        if (key == KeyEvent.VK_LEFT && dy==0) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT && dy==0) {
           dx = 5;
          
        }

        if (key == KeyEvent.VK_UP && dx==0) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN && dx==0) {
            dy = 5;
        }
    }

    public void keyReleased(KeyEvent e) {
    
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}