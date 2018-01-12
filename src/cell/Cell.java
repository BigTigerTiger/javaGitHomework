package cell;
//表达每一个方块。
import java.awt.Graphics;
 
public class Cell {
	private boolean alive = false;
	
	public void die() { alive = false; }
	public void reborn() { alive = true; }
	public boolean isAlive() { return alive; }
	
	public void draw(Graphics g, int x, int y, int size) {		
		g.drawRect(x, y, size, size);		//按照图形类Graphics g的drawRect方法，画矩形
		if ( alive ) {
			g.fillRect(x, y, size, size);	//填充矩形
		}
	}
}
