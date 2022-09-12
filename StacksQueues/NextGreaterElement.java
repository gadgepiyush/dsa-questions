package solvedArchive.StacksQueues;
import java.util.*;


//leetcode 496
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr1[] = {2,4};
        int arr2[] = {1,2,3,4};

        for(int i: nextGreaterElement(arr1, arr2))
            System.out.print(i+" ");
    }

    static int[] nextGreaterElement(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<arr1.length ; i++)
            map.put(arr1[i], i);

        int res[] = new int[arr1.length];

        for(int i=arr2.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && st.peek()<=arr2[i])
                st.pop();

            if(map.containsKey(arr2[i]))
                res[map.get(arr2[i])] = !st.isEmpty() ? st.peek() : -1;

            st.push(arr2[i]);
        }

        return res;
    }
}
