package ge.edu.sangu.sangu2015.gogishvili.simplesamples;

public class Sample08 {
	public static void main(String[] args) {
		int i = 17;
		int a = 0;
		switch (i) {
		case 13:
			a++;
			break;
		case 18:
			a--;
		case 17:
			a +=2;
			break;
		default:
			break;
		}
		System.out.print(a);
	}

}
