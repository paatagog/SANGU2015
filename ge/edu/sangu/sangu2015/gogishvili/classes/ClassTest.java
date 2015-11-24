package ge.edu.sangu.sangu2015.gogishvili.classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClassTest {
	
	
	public static void print(Point p) {
		System.out.println("x = " + p.getX() + "; y = " + p.getY() + ";");
	}
	
	public static void main(String[] args) {
		Point p = new Point(1, 4.6);
		ColorPoint cp = new ColorPoint(4.7, 122);
		print(cp);
		
		Pajero pajero = new Pajero();
		TestDrive td = new TestDrive();
		td.setA(pajero);
		td.test01();
		
		List l = new ArrayList();
		Set s = new HashSet();
		
		
	}

}
