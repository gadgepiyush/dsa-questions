package solvedArchive.StacksQueues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

//interview-bit question
public class NearestSmallerElement{
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        int temp[] = {39, 27, 11, 4, 24, 32, 32, 1};
        for(int i : temp)
            arr.add(i);

        System.out.println(prevSmaller(arr));
    }

    static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr){
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i : arr){
            if(st.isEmpty()) {
                res.add(-1);
                st.push(i);
            }
            else{
                if(i<=st.peek()){
                    while(!st.isEmpty()){
                        if(st.peek()>=i)
                            st.pop();
                        else
                            break;
                    }
                    if(st.isEmpty()) {
                        st.push(i);
                        res.add(-1);
                    }
                    else{
                        res.add(st.peek());
                        st.push(i);
                    }
                }
                else{
                    res.add(st.peek());
                    st.push(i);
                }
            }

        }


        return res;
    }
}
