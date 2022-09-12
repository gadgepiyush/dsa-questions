package solvedArchive.StacksQueues;
import java.util.Stack;

//leetcode 739
public class DailyTemprature {
    public static void main(String[] args) {
        int arr[] = {73,74,75,71,69,72,76,73};

        for(int i: nextGreaterElements(arr)){
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
}
