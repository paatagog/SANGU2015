package ge.edu.sangu.sangu2015.gogishvili.simplesamples;

public class Sample07 {
	public static void move(int i, int j, int n) {
		if (n == 1) {
			System.out.println("from " + i + " to " + j);
		} else {
			int k = 6 - i - j;
			move(i, k, n - 1);
			move(i, j, 1);
			move(k, j, n - 1);
		}
	}
	
	public static void main(String[] args) {
		move(1, 2, 3);
	}

}
