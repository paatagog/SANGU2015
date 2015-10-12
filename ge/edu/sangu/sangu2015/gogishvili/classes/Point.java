package ge.edu.sangu.sangu2015.gogishvili.classes;

public class Point {

	private double x;
	
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point p) {
		return Math.sqrt((x - p.getX()) * (x - p.getX()) + (x - p.getX()) * (x - p.getX()));
	}
	
	public double distanceFromCenter() {
		return distance(new Point(0, 0));
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
}
