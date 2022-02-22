package solvedArchive.DynamicProgramming;
import java.util.*;

public class PalindromePartitioning{
    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        System.out.println(noOfPartitions(s, 0, s.length()-1, new int[s.length()][s.length()]));
    }


    //leetcode 132 min no. of cuts for palindrome partition
    static int noOfPartitions(String s, int start, int end, int memo[][]){
        if(isPalindrome(s, start, end))
            return 0;

        if(memo[start][end] != 0)
            return memo[start][end];

        int minCuts = Integer.MAX_VALUE;
        for(int i=start ; i<end ; i++){
            int leftSub = noOfPartitions(s, start, i, memo);
            int rightSub = noOfPartitions(s, i+1, end, memo);

            minCuts = Math.min(minCuts, leftSub+rightSub+1);
        }

        memo[start][end] = minCuts;

        return minCuts;
    }

    //leetcode 131 return all the palindromic substrings


    static boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }

}
