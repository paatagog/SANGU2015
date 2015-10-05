package ge.edu.sangu.sangu2015.gogoladze.hanoi;

import java.util.Scanner;

public class Hanoi {



	     
		public static int sum=0;
		public static void main(String[] args) {
		     
		       System.out.print("შეიყვანე დისკების რაოდენობა: ");
		       Scanner scanner = new Scanner(System.in);
		       int discs = scanner.nextInt();
		       //მოცემული გვაქვს სამი სვეტი A, B და C.
		       nabiji(discs, "A", "B", "C");
		       System.out.println("სულ საჭირო იყო "+sum+" ოპერაცია.");
		       scanner.close();

		}

		



			   public static void nabiji(int n, String a, String b, String c) {
			       if (n == 1) {
			           System.out.println(a + " ----> " + c);
			       } else {
			    	   nabiji(n - 1, a, c, b);
			           System.out.println(a + " ----> " + c);
			           nabiji(n - 1, b, a, c);
			       }
			       sum++;
			   }
		   
		   
		
	
	
}
