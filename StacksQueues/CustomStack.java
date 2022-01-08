package solvedArchive.StacksQueues;

public class CustomStack{

    protected int[] data;
    private static final int defaultSize = 10;

    int ptr = -1;

    CustomStack(){
        this(defaultSize);
    }

    CustomStack(int size){
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

    public

    private boolean isFull(){
        return ptr == data.length-1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }



}
