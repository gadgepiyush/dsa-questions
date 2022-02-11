package solvedArchive.DynamicProgramming;

import java.util.Map;

public class LCS{
    public static void main(String[] args) {

        System.out.println(lcsDP("abc", "adbc",0,0, new int[3][4]));

    }


    //naive recursive code using virtual indexing because substring method has time complexity O(N)
    static int lcsRecur(String s1, String s2, int i1, int i2){
        if(i1==s1.length() || i2==s2.length())
            return 0;

        int lcsVal = 0;

        if(s1.charAt(i1)==s2.charAt(i2))
            lcsVal = lcsRecur(s1, s2, i1+1, i2+1) +1;
        else
            lcsVal = Math.max(lcsRecur(s1, s2, i1, i2+1), lcsRecur(s1, s2, i1+1, i2));

        return lcsVal;
    }

    static class Pair{
        int i,j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    //DP approach (top-down)
    static int lcsDP(String s1, String s2, int i1, int i2, int solution[][]){
        if(i1==s1.length() || i2==s2.length())
            return 0;

        if(solution[i1][i2] != 0)
            return solution[i1][i2];

        int lcsVal = 0;

        if(s1.charAt(i1)==s2.charAt(i2))
            lcsVal = lcsDP(s1, s2, i1+1, i2+1, solution) +1;
        else
            lcsVal = Math.max(lcsDP(s1, s2, i1, i2+1, solution), lcsDP(s1, s2, i1+1, i2, solution));

        solution[i1][i2] = lcsVal;
        return lcsVal;
    }
}
