package solvedArchive.DynamicProgramming;

// the catalan sereis is (1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …)
public class CatalanNumber{
    public static void main(String[] args) {
        System.out.println(noOfBST(3, new int[6]));
     }

    //leetcode 96 no. of BST
    static int noOfBST(int n, int memo[]){
        if(memo[n] != 0)
            return memo[n];

        if(n<=1)
            return 1;

        int total = 0;
        for(int i=1; i<=n ; i++){
            int left = noOfBST(i-1, memo);
            int right = noOfBST(n-i, memo);

            total += left*right;
        }

        memo[n] = total;

        return total;
    }

}
