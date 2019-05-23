package juego;

import java.awt.event.KeyEvent;

public class Circle extends Sprite{
    private int dx;
    private int dy;
    
    public Circle(int x, int y, int width, int height) throws Exception {
        super(x, y,width,height);
    }
   
    public void move() {
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
        }
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -5;
        }

        if (key == KeyEvent.VK_RIGHT) {
           dx = 5;
          
        }

        if (key == KeyEvent.VK_UP) {
            dy = -5;
        }

        if (key == KeyEvent.VK_DOWN) {
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