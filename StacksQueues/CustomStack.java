package solvedArchive.StacksQueues;

//stack implementation with all necessary methods

class CustomStackMethods{

    protected int[] data;
    private static final int defaultSize = 10;
    int ptr = -1;

    //empty constructor if we want to use default size
    CustomStackMethods(){ this(defaultSize); }

    //constructor if we want to use custom size stack
    CustomStackMethods(int size){  this.data = new int[size]; }


    public boolean push(int item){
        if(isFull())
            return false;

        ptr++;
        data[ptr] = item;
        return true;
    }


    public int pop() throws Exception {
        if(isEmpty())
            throw new Exception("Cannot pop, stack is empty");

        int removed = data[ptr];
        ptr--;
        return removed;
    }


    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Cannot peek, stack is empty");

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

        CustomStackMethods csm = new CustomStackMethods();

    }

}

