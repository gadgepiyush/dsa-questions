package solvedArchive.Strings;

//leetcode 5
public class LongestPalindromicSubstr{
    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }

    static String longestPalindrome(String s){
        int dp[][] = new int[s.length()][s.length()];

        String ans = "";
        int maxLen = 0;

        for(int diff=0 ; diff<s.length() ; diff++){

            int i=0, j=i+diff;
            while(j<s.length()){
                if(diff==0) {
                    dp[i][j] = 1;
                }
                else if (diff==1) {
                    dp[i][j] = s.charAt(i)==s.charAt(j) ? 2 : 0;
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                        dp[i][j] = dp[i+1][j-1] +2;
                    }
                }

                if(dp[i][j]!=0){
                    int length = j-i+1;
                    if(length>maxLen){
                        maxLen = length;
                        ans = s.substring(i, j+1);
                    }

                }
                i++;
                j++;
            }
        }

        return ans;
    }

}
