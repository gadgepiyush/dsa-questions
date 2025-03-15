package solvedArchive.OverlappingIntervals;

import java.util.ArrayList;
import java.util.List;

// leetcode 57
public class InsertInterval {
    public static void main(String[] args) {
        int arr[][] = {{1,4},{9,12},{19,22}};
        int[][] merged = insert(arr, new int[]{7,13});

        for(int[] i : merged){
            for(int j : i){
                System.out.print(j+ " ");
            }
            System.out.println();
        }

    }

    static int[][] insert(int[][] intervals, int[] newInterval){
        List<int[]> res = new ArrayList<>();



        return res.toArray(new int[res.size()][]);
    }
}
