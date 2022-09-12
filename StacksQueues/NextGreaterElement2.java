package solvedArchive.StacksQueues;
import java.util.Stack;

//leetcode 503
public class NextGreaterElement2 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,3};

        for(int i : nextGreaterElements(arr)){
            System.out.print(i+" ");
        }

    }

    static int[] nextGreaterElements(int[] arr) {
        int res[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();
        int j;
        for(int i= arr.length-1 ; i>=0 ; i--){
            j=i+1;

            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            res[i] = !st.isEmpty() ? st.peek() : helper(i, arr);

            st.push(arr[i]);
        }

        return res;
    }

    static int helper(int i, int arr[]){
        for(int j=0 ; j<i ; j++){
            if(arr[j]>arr[i])
                return arr[j];
        }

        return -1;
    }
}
