package solvedArchive.StacksQueues;

class CustomStackMethods{

    protected int[] data;
    private static final int defaultSize = 10;

    int ptr = -1;

    CustomStackMethods(){
        this(defaultSize);
    }

    CustomStackMethods(int size){
        this.data = new int[size];
    }

    //method to push an item into stacked
    public boolean push(int item){

        if(isFull()){
            return false;
        }

        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws Exception {
        if(isEmpty()){
            throw new Exception("Cannot pop, stack is empty");
        }
//        int removed = data[ptr];
//        ptr--;
//        return removed;
        return data[ptr--];
    }

    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Cannot peek, stack is empty");
        }
        return data[ptr];
    }

    private boolean isFull(){
        return ptr == data.length-1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

}


public class CustomStack {

    public static void main(String[] args) throws Exception {
        CustomStackMethods stack = new CustomStackMethods(5);

        stack.push(1);

        System.out.println(stack.peek());

    }

}

