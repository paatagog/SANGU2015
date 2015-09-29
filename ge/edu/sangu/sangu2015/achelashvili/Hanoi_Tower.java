package ge.edu.sangu.sangu2015.achelashvili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hanoi_Tower Game Calculator:
 * Calculate The <b>Minimum</b> Movements
 * Of The Number You Input:
 * @author Madhackers
 */

public class Hanoi_Tower {

	static int k=0; // Counter of Movements
	
	public static int Func(int x,int a,int c,int b){
	
		if (x>0){
			Func(x - 1, a, b, c);
            k++; // Increase in Each Recursion
            Func(x - 1, a, c, b);
		}
		return k;
	}
	
	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String BufferLine = null;  

		System.out.println(" Enter Value Of The Hanoi Tower Discs: ");
		
		try {
			BufferLine = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Input Method From StackOverFlow
		int X = Integer.parseInt(BufferLine);
		X = Func(X,1,3,2);
	    System.out.println(" Minimum Movements Of Hanoi: " + X);
	}

}
