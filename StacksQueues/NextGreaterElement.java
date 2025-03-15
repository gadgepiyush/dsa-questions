package solvedArchive.StacksQueues;
import java.util.*;


//leetcode 496
public class NextGreaterElement {
    public static void main(String[] args) {
        int arr1[] = {1,4};
        int arr2[] = {1,3,4,2};

        for(int i: nextGreater(arr1, arr2))
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

    static int [] nextGreater(int arr1[], int arr2[]){
        Stack<Integer> st = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int j=arr2.length-1 ; j>=0 ; j--){
            int i = arr2[j];
            if(st.isEmpty()){
                map.put(i, -1);
                st.push(i);
                continue;
            }

            if(st.peek()>i){
                map.put(i, st.peek());
                st.push(i);
            }else {
                while (!st.isEmpty() && st.peek()<i){
                    st.pop();
                }

                if(st.isEmpty()){
                    map.put(i, -1);
                    st.push(i);
                }else {
                    map.put(i, st.peek());
                    st.push(i);
                }
            }
        }

        for(int i=0 ; i<arr1.length ; i++ ){
            arr1[i] = map.get(arr1[i]);
        }

        return arr1;
    }
}
