package ge.edu.sangu.sangu2015.achelashvili.KnightMoves;

/*
 * Based on BlackTracking Algorithm:
 * 
 * while there are untried tours
*{ 
*   generate the next tour 
*   if this tour covers all squares 
*   { 
*      print this path;
*  }
*}

 * 
 */

public class ChessProb {

// * * * *	
	
public static final int N = 8; // C++ #Define

// ფუნქცია ამოწმებს, არის თუ არა i,j ინდექსები სწორ ადგილას, ანუ გაცდა თუ არ გაცდა მაგიდის N*N განზომილებას
static boolean isSafe(int x, int y, int sol[][])
{
    return  x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1;
}

// void ფუნქცია - ბეჭდავს საბოლოო მატრიცას sol[N][N]
static void printSolution(int sol[][])
{
    for (int x = 0; x < N; x++)
    {
        for (int y = 0; y < N; y++)
            System.out.printf(" %2d ",sol[x][y]); //
        System.out.printf("\n");
    }
    
}
 
/* ეს ფუნქცია ძირითადად იყენებს solveKTUtil() პრობლემის გადასაჭრელად.
 *  აბრუნებს - მცდარობას false - თუ აღარ დარჩა გადასვლა. წინააღმდეგ შემთხვევაში აბრუნებს true და ბეჭდავს შედეგს.
 *  ფუნქცია ბეჭდავს ყველაზე ოპტიმალურ შედეგს
 */

static boolean solveKT()
{
	int sol[][] = new int[N][N];
	
	for (int x = 0; x < N; x++)
        for (int y = 0; y < N; y++)
            sol[x][y] = -1;
	
	
	/* xMove[] და  yMove[] - მხედრის შემდეგი სვლის კოორდინატები */
	int xMove[] = {2,1,-1,-2,-2,-1,1,2};
	int yMove[]= {1,2,2,1,-1,-2,-2,-1};

	// მხედრის საწყისი სვლა
    sol[0][0] = 0;

    /* ფუნქცია დაიწყებს წერტილიდან 0.0 და ი solveKTUtil() */
    if(solveKTUtil(0, 0, 1, sol, xMove, yMove) == false)
    {
        System.out.printf("Solution does not exist");
        return false;
    }
    else
        printSolution(sol);
 
    return true;

}

// ფუნქცია: solveKTUtil
static boolean solveKTUtil(int x, int y, int movei, int sol[][], int xMove[],
                int yMove[])
{
   int k, next_x, next_y;
   if (movei == N*N)
       return true;
 
   // ამ ციკლით ფუნქცია იპოვის შემდეგ ნაბიჯებს x და  y კოორდინატებისთვის
   for (k = 0; k < 8; k++)
   {
       next_x = x + xMove[k];
       next_y = y + yMove[k];
       if (isSafe(next_x, next_y, sol))
       {
         sol[next_x][next_y] = movei;
         if (solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove) == true)
             return true;
         else
             sol[next_x][next_y] = -1;// backtracking
       }
   }
 
   return false;
}

// End Of Class //

	public static void main(String[] args) {
		
			solveKT();
	}

}