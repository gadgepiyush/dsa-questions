package solvedArchive.OverlappingIntervals;


import java.util.*;

//leetcode 56
public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = {{1,8},{2,6},{8,10},{15,18}};

        int merged[][] = merge(arr);

        System.out.println(merged);
    }

    static int[][] merge(int intervals[][]){
        if(intervals.length<=1)
            return intervals;

        Arrays.sort(intervals, Comparator.comparing(i->i[0]));
        List<int[]> res = new ArrayList<>();

        int[] newInterval = intervals[0];
        res.add(newInterval);

        for(int interval[] : intervals){
            if(interval[0] <= newInterval[1]){
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
            else {
                newInterval = interval;
                res.add(newInterval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
