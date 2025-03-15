package solvedArchive.Arrays;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
public class MissingAndRepeatingNumbers {
    public static void main(String[] args) {
        int arr[] = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }

    static ArrayList<Integer> findTwoElement(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0 ; i<arr.length ; i++){
            int x = Math.abs(arr[i]) -1;

            if(arr[x] < 0){
                res.add(x +1);
            } else {
                arr[x] *= -1;
            }
        }

        for(int i=0 ; i<arr.length ; i++){
            if(arr[i]>0)
                res.add(i+1);
        }

        return res;
    }
}
