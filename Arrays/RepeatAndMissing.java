package solvedArchive.Arrays;
import java.util.*;

public class RepeatAndMissing {
    public static void main(String[] args) {
        int arr[] = {3, 1, 2, 5, 3};

        System.out.println(repatedNum(arr));
    }


    static List<Integer> repatedNum(int arr[]){
        int temp[] = new int[arr.length+1];

        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(0);

        for(int i=0 ; i<arr.length ; i++){
            temp[arr[i]]++;
        }

        for(int i=1 ; i<temp.length ; i++){
            if(temp[i]==2)
                ans.set(0, i);
            else if(temp[i]==0)
                ans.set(1, i);
        }

        return ans;
    }
}
