package solvedArchive.StacksQueues;

import java.lang.reflect.GenericDeclaration;

class CircularQueueMethods{

    protected int[] data;
    int size;
    int end = 0;
    int front = 0;

    CircularQueueMethods(int initialSize){
        this.size = initialSize;
        this.data = new int[size];
    }


    //insert into the circular queue
    boolean insert(int item){
        if(isFull())
            return false;

        data[end] = item;
        end++;
        end = end %data.length;
        size++;
        return true;
    }

    int remove() throws Exception{
        if(isEmpty())
            throw new Exception("Queue is Empty");

        int removed = data[front];
        front = front%data.length;
        size--;
        return removed;
    }


    int getFront() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }

        return data[front];
    }

    void display(){
        for(int i =front ; i<end ; i++){
            System.out.print(data[i]);
        }
        System.out.println();
    }


    boolean isFull(){
        return end == data.length; //
    }

    boolean isEmpty(){
        return end ==0;
    }

}


public class CircularQueue {
    public static void main(String[] args) {

    }
}
