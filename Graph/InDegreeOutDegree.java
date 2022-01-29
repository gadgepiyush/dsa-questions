package solvedArchive.Graph;
import java.util.*;

public class InDegreeOutDegree{

    public static void main(String[] args) {

        int edges[][] = {{1,3},{2,3}};

        System.out.println(findJudge(3,edges));

    }

    //in this ques we have to find a node which has in-degree 'n-1' and out-degree '0'
    static int findJudge(int n, int trust[][]){

        //this array keeps the count of in-degree and out-degree
        int countKeeper[][] = new int[n+1][2];

        //index 0 = in-degree, index 1 = out-degree
        for(int i[] : trust){
            countKeeper[i[0]][1]++;
            countKeeper[i[1]][0]++;
        }

        for(int i=1 ; i<=n ; i++){
            if(countKeeper[i][0]==n-1 && countKeeper[i][1]==0)
                return i;
        }

        return -1;
    }

}
