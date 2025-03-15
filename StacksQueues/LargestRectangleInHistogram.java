package solvedArchive.StacksQueues;

import java.util.Stack;

//leetcode 84
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int arr[] = {1,1};

        System.out.println(largestRectangleArea(arr));
    }

    static int largestRectangleArea(int arr[]){
        Stack<Integer> st = new Stack<>();
        int prevSmall[] = new int[arr.length];
        int nextSmall[] = new int[arr.length];
        int maxArea =0;

        //find the prevSmall of all the elements
        for(int i=0 ; i<arr.length ; i++){
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();

            prevSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();
        //find the nextSmall of all the elements
        for(int i=arr.length-1 ; i>=0 ; i--){
            while (!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();

            nextSmall[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }

        int currMaxArea = 0;
        for(int i=0 ; i<arr.length ; i++){
            currMaxArea = (nextSmall[i] - prevSmall[i] - 1) * arr[i];

            maxArea = Math.max(maxArea, currMaxArea);
        }

        return maxArea;
    }
}
