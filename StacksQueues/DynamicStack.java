package solvedArchive.StacksQueues;

import java.util.Arrays;

//custom stack with dynamic size
class DynamicStackMethods {

    int initialSize;
    int[] data;
    int ptr = -1;

    DynamicStackMethods(int initialSize){
        this.initialSize = initialSize;
        this.data = new int[initialSize];
    }


    public boolean push(int item){
        if(isFull())
            data = Arrays.copyOf(data, data.length+initialSize); //increasing the size by initialSize

        ptr++;
        data[ptr] = item;
        return true;
    }


    public int pop() throws Exception{
        if(isEmpty())
            throw new Exception("Cannot pop, Stack is empty");

        int removed = data[ptr];
        ptr--;
        return removed;
    }


    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Cannot peek, Stack is empty");

        return data[ptr];
    }



    private boolean isFull(){
        return ptr == data.length-1;
    }

    private boolean isEmpty(){
        return ptr==-1;
    }

}

public class DynamicStack{
    public static void main(String[] args) throws Exception {
        DynamicStackMethods dm = new DynamicStackMethods(5);

        System.out.println(dm.data.length);

        dm.push(2);
        dm.push(2);
        dm.push(3);
        dm.push(6);
        dm.push(5);
        dm.push(9);

        System.out.println(dm.data.length);

    }
}

