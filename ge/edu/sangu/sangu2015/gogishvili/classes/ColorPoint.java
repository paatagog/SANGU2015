package ge.edu.sangu.sangu2015.gogishvili.classes;

public class ColorPoint extends Point {
	
	private long color;

	public ColorPoint(double x, double y) {
		super(x, y);
	}

	public long getColor() {
		return color;
	}

	public void setColor(long color) {
		this.color = color;
	}

}
