package tower.of.hanoi;
import java.awt.Color;
import java.util.ArrayList;



/**
 * @author user
 *
 */
public class Peg {

	private Color color;
	private int Id;
	private int x;
	private int y;
	private int w;
	private int h;
	private ArrayList<Disk> Disks;

	public Peg(Color color, int x, int y, int w, int h, int Id, ArrayList<Disk> disks) {
		this.color = color;
		this.Id = Id;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.Disks = disks;
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

	public ArrayList<Disk> getDisks() {
		return Disks;
	}

	public void setDisks(ArrayList<Disk> disks) {
		this.Disks = disks;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

}
