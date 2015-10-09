package ge.edu.sangu.sangu2015.barnabishvili.chess;

public class KnightTourProblem {

    static final int[] deltaX = {-2, -2, -1, 1, 2, 2, 1, -1};
    static final int[] deltaY = {1, -1, -2, -2, -1, 1, 2, 2};

    int boardWidth;
    int boardHeight;
    int boardArea;

    boolean[][] visited;

    public KnightTourProblem()
    {
        this(8, 8);
    }

    public KnightTourProblem(int boardWidth, int boardHeight) {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        boardArea = boardWidth * boardHeight;

        visited = new boolean[boardHeight][boardWidth];
    }

    boolean isValidPosition(int x, int y) {
        return 0 <= x && x < boardWidth && 0 <= y && y < boardHeight;
    }

    /**
     * Performs brute-force search and prints out the tour if it exists
     */
    boolean dfs(int x, int y, int step) {

        if (!isValidPosition(x, y) || visited[y][x])
            return false;

        if (step == boardArea) {
            System.out.println(String.format("#%d: (%s; %s)", step, x + 1, y + 1));
            return true;
        }

        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            if (dfs(x + deltaX[i], y + deltaY[i], step + 1)) {
                System.out.println(String.format("#%d: (%s; %s)", step, x + 1, y + 1));
                return true;
            }
        }

        visited[y][x] = false;
        return false;
    }

    public boolean solve(int x, int y) {

        x--;
        y--;

        if (!isValidPosition(x, y)) {
            throw new IllegalArgumentException("Starting position of the knight is invalid");
        }

        return dfs(x, y, 1);
    }

    public static void main(String[] args) {
        KnightTourProblem calc = new KnightTourProblem(7, 7);
        calc.solve(1, 1);
    }
}
