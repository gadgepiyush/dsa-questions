package solvedArchive.StacksQueues;


class CustomQueueMethods {

    int[] data;
    int initialSize;
    int end = 0;

    CustomQueueMethods(int initialSize){
        this.initialSize = initialSize;
        this.data = new int[initialSize];
    }


    //adds element in the start(i.e. end of the array)
    public boolean insert(int item){
        if(isFull())
            return false;

        data[end] = item;
        end++;
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

        end--;
        return removed;
    }


    public int displayFront() throws Exception{
        if(isEmpty())
            throw new Exception("Queue is empty");

        return data[0];
    }



    private boolean isFull(){
        return end == data.length-1;
    }

    private boolean isEmpty(){
        return end == -1;
    }

}


class CustomQueue{

    public static void main(String[] args) throws Exception{
        CustomQueueMethods queue = new CustomQueueMethods(4);
        queue.insert(41);
        queue.insert(21);
        queue.insert(14);
        queue.insert(13);
        queue.insert(21);
        queue.insert(11);

        System.out.println(queue.displayFront());
    }

}