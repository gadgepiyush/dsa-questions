package solvedArchive.DynamicProgramming;


public class RodCutting{
    public static void main(String[] args) {
        int price[] = {0,1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(rodCutting(price, price.length-1, new int[price.length]));
    }

    static int rodCutting(int price[], int n, int memo[]) {
        if(memo[n] != 0)
            return memo[n];

        int left = 1;
        int right = n-1;

        int max = price[n];
        while (left <= right) {
            int firstPiece = rodCutting(price, left, memo);
            int secondPiece = rodCutting(price, right, memo);

            max = Math.max(max, firstPiece+secondPiece);

            left++;
            right--;
        }

        memo[n] = max;

        return max;
    }



}
