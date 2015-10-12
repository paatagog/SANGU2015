package ge.edu.sangu.sangu2015.kavelashvili.Hanoi;

import java.util.Scanner;

public class HanoiTower {
  private static Scanner scanner;

public static void main(String[] args) {
	  
	  System.out.println(" შეიყვანეთ დისკთა რაოდენობა: ");
	  scanner = new Scanner(System.in); 
	  int nDisks = scanner.nextInt(); 
	  
    doTowers(nDisks, 'A', 'B', 'C');
  }

  public static void doTowers(int topN, char from, char inter, char to) {
    if (topN == 1){
      System.out.println("Disk 1 from " + from + " to " + to);
    }else {
      doTowers(topN - 1, from, to, inter);
      System.out.println("Disk " + topN + " from " + from + " to " + to);
      doTowers(topN - 1, inter, from, to);
    }
  }
}
