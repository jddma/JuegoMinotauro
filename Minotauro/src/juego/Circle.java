package juego;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Circle extends Sprite{
	
    private int dx;
    private int dy;
    
    public Circle(int x, int y, int width, int height) throws Exception {
        super(x, y,width,height);
    }
    
    private boolean VerificarChoque(Muro[]muros,int mov) {
    	int new_x=x,new_y=y;
    	switch(mov)
    	{
    		case 0:
    			new_y+=5;
    			break;
    			
    		case 1:
    			new_y-=5;
    			break;
    			
    		case 2:
    			new_x+=5;
    			break;
    			
    		case 3:
    			new_x-=5;
    			break;
    	}
    	
    	Rectangle new_position=new Rectangle(new_x,new_y,30,30);
    	for(int i=0; i<muros.length; i++)
    		if( new_position.intersects(muros[i].GetBounds()))
    			return true;  		
    	
    	return false;
    }
   
    public void move(Muro[]muros) {  	
    	System.out.println("x:" +x+
    						"\n" + "y:" +y+
    						"\n" + "-----------------");
    	if(dy!=0)
    	{
    		switch(dy)
    		{
    			case 5:
    				if(! VerificarChoque(muros,0))//abajo
    					y+=dy;
    				
    				break;
    				
    			case -5:
    				if(! VerificarChoque(muros,1))//arriba
    					y+=dy;
    				
    				break;
    		}
    	}
    	if(dx!=0)
    	{
    		switch(dx)
    		{
    			case 5:
    				if(! VerificarChoque(muros,2))//derecha
    					x+=dx;
    				
    				break;
    				
    			case -5:
    				if(! VerificarChoque(muros,3))//arriba
    					x+=dx;
    				
    				break;
    		}
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