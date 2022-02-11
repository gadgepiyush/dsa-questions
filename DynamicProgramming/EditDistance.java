package solvedArchive.DynamicProgramming;

public class EditDistance{
    public static void main(String[] args) {
        System.out.println(editDistanceDP("abc", "xyz", 0, 0, new int[3][3]));
    }

    //naive recursive solution
    static int editDistance(String s1, String s2){
        if(s1.isEmpty() || s2.isEmpty())
            return Math.max(s1.length(), s2.length());

        int ans;
        if(s1.charAt(0)==s2.charAt(0)) {
            ans = editDistance(s1.substring(1), s2.substring(1));
        }
        else{
            int insertion = editDistance(s1.substring(1), s2);
            int deletion = editDistance(s1, s2.substring(1));
            int replacement = editDistance(s1.substring(1), s2.substring(1));

            ans = Math.min(insertion, Math.min(deletion, replacement)) +1;
        }

        return ans;
    }


    //DP approach (memoization)
    static int editDistanceDP(String s1, String s2, int i, int j, int memo[][]){
        if(i==s1.length() || j==s2.length())
            return Math.max(s1.substring(i).length(), s2.substring(j).length());

        if(memo[i][j]!=0)
            return memo[i][j];

        int ans;
        if(s1.charAt(i) == s2.charAt(j)){
            ans = editDistanceDP(s1, s2, i+1, j+1, memo);
        }
        else{
            int insertion = editDistanceDP(s1, s2, i+1, j, memo);
            int deletion = editDistanceDP(s1, s2, i, j+1, memo);
            int replacement = editDistanceDP(s1, s2, i+1, j+1, memo);

            ans = Math.min(insertion, Math.min(deletion, replacement)) +1;
        }

        memo[i][j] = ans;

        return ans;
    }

}
