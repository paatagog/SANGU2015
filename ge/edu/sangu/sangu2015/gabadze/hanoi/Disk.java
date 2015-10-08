package tower.of.hanoi;
import java.awt.Color;



/**
 * @author user
 * 
 *
 *
 */
public class Disk {

	private int Id;
	private Color color;
	private int x;
	private int y;
	private int w;
	private int h;

	public Disk(Color color, int x, int y, int w, int h, int Id) {
		this.color = color;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Id = Id;
	}

	 

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

}
