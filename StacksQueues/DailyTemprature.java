package solvedArchive.StacksQueues;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//leetcode 739
public class DailyTemprature {
    public static void main(String[] args) {
        int arr[] = {89,62,70,58,47,47,46,76,100,70};

        for(int i: dailyTempratures(arr)){
            System.out.print(i+" ");
        }
    }

    static int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();

        int res[] = new int[arr.length];

        for(int i=arr.length-1 ; i>=0 ; i--){
            while(!st.isEmpty() && arr[(st.peek())]<=arr[i]) {
                st.pop();
            }

            res[i] = !st.isEmpty() ? st.peek()-i : 0;
            st.push(i);
        }

        return res;
    }

    static int[] dailyTempratures(int arr[]){
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=arr.length-1 ; i>=0 ; i--){
            int temp = arr[i];
            if(st.isEmpty()){
                map.put(arr[i], i);
                st.push(arr[i]);
                arr[i] = 0;
                continue;
            }

            if(st.peek()>arr[i]){
                arr[i] = map.get(st.peek()) -i;
                map.put(temp, i);
                st.push(temp);
            }
            else {
                while (!st.isEmpty() && st.peek()<arr[i] ){
                    st.pop();
                }

                if(st.isEmpty()){
                    arr[i] = 0;
                }
                else {
                    arr[i] = map.get(st.peek()) -i;
                }
                st.push(temp);
                map.put(temp, i);
            }
        }

        return arr;
    }
}
