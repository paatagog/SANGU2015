package ge.edu.sangu2015.gogishvili.simplesamples;

public class Sample06 {

	public static int multiplyBy2(int i) {
		return i * 2;
	}
	
	public static int add2(int i) {
		return i + 2;
	}
	
	public static void main(String[] args) {
		int i = 3;
		System.out.println(i);
		multiplyBy2(i);
		System.out.println(i);
		int j = add2(i);
		System.out.println(j);
	}
}
