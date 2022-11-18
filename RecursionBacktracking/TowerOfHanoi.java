package solvedArchive.RecursionBacktracking;

public class TowerOfHanoi{
    public static void main(String[] args) {
        towerOfHanoi(3, 1, 2, 3);
    }

    static void towerOfHanoi(int n, int s, int m, int d){
        if(n==1){
            System.out.println("move disk from "+ s + " to " + d);
            return;
        }

        towerOfHanoi(n-1, s, d, m);
        System.out.println("move disk from "+ s + " to " + d);
        towerOfHanoi(n-1, m, s, d);
    }
}
