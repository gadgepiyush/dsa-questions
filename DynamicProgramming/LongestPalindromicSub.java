package solvedArchive.DynamicProgramming;

public class LongestPalindromicSub{
    public static void main(String[] args) {
        String s = "aacabdkacaa";
        String memo[][] = new String[s.length()][s.length()];

        System.out.println(palindromeByRemoving(0, s.length()-1, s, memo));
    }

    //leetcode 516 length of the longest palindromic subsequence
    static int LPS(int start, int end, String s, int memo[][]){
        if(start>=end)
            return start==end ? 1 : 0;

        if(memo[start][end]!=0)
            return memo[start][end];

        int total;
        if(s.charAt(start)==s.charAt(end)){
            total = 2 + LPS(start+1, end-1, s, memo);
        }
        else{
            total = Math.max(LPS(start+1, end, s, memo), LPS(start, end-1, s, memo));
        }

        memo[start][end] = total;

        return total;
    }


    //removes characters and makes the String Palindrome
    static String palindromeByRemoving(int start, int end, String s, String memo[][]){
        if(start>=end)
            return start==end ? s.charAt(start)+"" : "";

        if(memo[start][end] != null)
            return memo[start][end];

        String str;
        if(s.charAt(start)==s.charAt(end)){
            str = s.charAt(start) + palindromeByRemoving(start+1, end-1, s, memo) + s.charAt(end);
        }
        else {
            String startRemove = palindromeByRemoving(start+1, end, s, memo);
            String endRemove = palindromeByRemoving(start, end-1, s, memo);

            str = startRemove.length()>endRemove.length() ? startRemove : endRemove;
        }

        memo[start][end] = str;

        return str;
    }
}
