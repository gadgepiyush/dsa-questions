package solvedArchive.PrefixSum;

import java.util.HashMap;

//Leetcode 525 - Contiguous Array
//https://youtu.be/9ZyLjjk536U?si=N7MG58ZMDHfhzz7B
public class ContagiousArray {
    public static void main(String[] args) {
        int arr[] = {0,1,1};
        System.out.println(findMaxLength(arr));
    }

    static int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int greatestSum = 0;
        int currSum = 0;
        map.put(-1, 0);

        for(int i=0 ; i<arr.length ; i++){
            currSum += arr[i]==1 ? 1 : -1;

            if(currSum == 0){
                greatestSum = i+1;
            }
            else if(map.containsKey(currSum)){ //find the first index where that particular sum as found
                greatestSum = Math.max(greatestSum, i - map.get(currSum));
            }
            else { // if the sum is found first time insert that index into the map
                map.put(currSum, i);
            }
        }

        return greatestSum;
    }
}
