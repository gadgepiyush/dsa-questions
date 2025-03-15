package solvedArchive.Heap;

import java.util.*;


//leetcode  347
public class TopKFrequentElements {
    public static void main(String[] args) {
        int arr[] = {1,2};
        for(int i: topKFrequent(arr, 2)){
            System.out.print(i + " ");
        }
    }

    static int[] topKFrequent(int arr[], int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int res[] = new int[k];
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0) +1);
        }

        List<Integer>[] freq = new List[arr.length+1];

        for(int i : map.keySet()){
            if(freq[map.get(i)]==null)
                freq[map.get(i)] = new ArrayList<>();
            freq[map.get(i)].add(i); // the number which is occuring n times is the index i
        }

        for(int i=freq.length-1 ; i>=0 ; i--){
            if(freq[i] != null){
                for (int j : freq[i]) {
                    res[k-1] = j;
                    k--;
                }
            }
        }

        return res;
    }
}
