package ge.edu.sangu.sangu2015.barnabishvili.hanoi;

import java.util.Scanner;

/**
 * Represents a model for storing the tower of hanoi with three pegs.
 */
class HanoiTower {

    int[] NumOfDisks = {0, 0, 0};

    public HanoiTower(int numOfDisks) {
        NumOfDisks[0] = numOfDisks;
    }

    boolean isMoveValid(int from, int to) {
        return from >= 1 && from <= 3 &&
                to >= 1 && to <= 3 &&
                NumOfDisks[from - 1] > 0;
    }

    /**
     * Performs a single disk movement
     * @param from initial peg the disk is removed from
     * @param to destination pag the disk is placed on
     */
    public void move(int from, int to) {

        if (!isMoveValid(from, to)) {
            throw new IllegalArgumentException("Move can't be performed.");
        }

        NumOfDisks[from - 1]--;
        NumOfDisks[to - 1]++;
    }

    /**
     * Counts the total number of disks on all pegs
     */
    public int countDisks() {
        return NumOfDisks[0] + NumOfDisks[1] + NumOfDisks[2];
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)", NumOfDisks[0], NumOfDisks[1], NumOfDisks[2]);
    }
}

public class HanoiSolver {

    HanoiTower tower;

    public void setTower(HanoiTower tower) {
        this.tower = tower;
    }

    void RecursiveSolver(int numOfDisks, int from, int to) {

        if (numOfDisks == 0) {
            return;
        }

        RecursiveSolver(numOfDisks - 1, from, 6 - from - to);
        tower.move(from, to);
        System.out.println(tower);
        RecursiveSolver(numOfDisks - 1, 6 - from - to, to);
    }

    public void solve() {
        System.out.println(tower);
        RecursiveSolver(tower.countDisks(), 1, 3);
    }

    public static void main(String[] args) {

        HanoiSolver solver = new HanoiSolver();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of disks: ");
        int numOfDisks = scanner.nextInt();

        solver.setTower(new HanoiTower(numOfDisks));
        solver.solve();
    }
}
