package juego;

import java.awt.Rectangle;

public class Muro {

	protected int x;
    protected int y;
    protected int width;
    protected int height;
    
    public Muro(int x,int y,int width,int height) {
    	this.x=x;
    	this.y=y;
    	this.width=width;
    	this.height=height;
    }
    
    public Rectangle GetBounds() {
    	return new Rectangle(x,y,width,height);
    }
	
}
