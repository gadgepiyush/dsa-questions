package solvedArchive.StacksQueues;


class CustomQueueMethods {

    int[] data;
    int initialSize;
    int ptr = 0;

    CustomQueueMethods(int initialSize){
        this.initialSize = initialSize;
        this.data = new int[initialSize];
    }


    //adds element in the start(i.e. end of the array)
    public boolean insert(int item){
        if(isFull())
            return false;

        data[ptr] = item;
        ptr++;
        return true;
    }


    //removes element from the end(i.e. 0th index of the array)
    public int remove() throws Exception{
        if(isEmpty())
            throw new Exception("Cannot remove, Queue is empty");

        int removed = data[0];
        for (int i=1 ; i<data.length ; i++){
            data[i-1] = data[i];

        }

        ptr--;
        return removed;
    }


    // displays the end item which would be removed if the remove func is called
    public int displayFront() throws Exception{
        if(isEmpty())
            throw new Exception("Queue is empty");

        return data[0];
    }


    //prints the whole queue in the order it is inserted
    public void printQueue(){
        for(int i = ptr -1; i>=0 ; i--){
            System.out.print(data[i]+" -> ");
        }
        System.out.println("end");
    }


    private boolean isFull(){
        return ptr == data.length;
    }

    private boolean isEmpty(){
        return ptr == 0;
    }

}


class CustomQueue{

    public static void main(String[] args) throws Exception{
        CustomQueueMethods queue = new CustomQueueMethods(6);


        queue.printQueue();
        queue.remove();
        queue.printQueue();
    }

}