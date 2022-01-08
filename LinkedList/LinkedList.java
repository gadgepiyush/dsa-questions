

class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){ this.data = data; }
    }

    static class Methods{
        Node head = null;

        void traverse(){
            Node currNode = head;
            if(head == null){
                System.out.println("LL is empty");
                return;
            }

            while (currNode != null){
                System.out.print(currNode.data+" -> ");
                currNode = currNode.next;
            }
            System.out.println("null");
        }

        void insertAtEnd(int data){
            Node newNode = new Node(data);

            if (head == null){
                head = newNode;
                return;
            }

            Node currNode = head;
            while (currNode.next != null){
                currNode = currNode.next;
            }

            currNode.next = newNode;
        }

        void insertAtHead(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        void insertAtPosition(int data, int position){
            Node newNode = new Node(data);
            Node currentNode = head;

            if(position == 0){
                newNode.next = head;
                head = newNode;
            }

            for(int i=0 ; i<position-1 ; i++){
                currentNode = currentNode.next;
            }

            newNode.next = currentNode.next;
            currentNode.next = newNode;


        }

        void deleteNode(int position){
            Node currNode = head;

            if(position == 0){
                head = head.next;
            }

            for(int i=0 ; i<position-1 ; i++){
                currNode = currNode.next;
            }

            currNode.next = currNode.next.next;
        }

        void reverseLL(){
            Node currNode = head;
            Node prevNode = null;

            while (currNode != null){
                Node temp = currNode.next;
                currNode.next = prevNode;
                prevNode = currNode;
                currNode = temp;
            }

            head = prevNode;
        }

        void findPositionFromEnd(int element){
            Node currNode = head;
            Node prev = null;

            while(currNode != null){
                Node temp = currNode.next;
                currNode.next = prev;
                prev = currNode;
                currNode = temp;
            }
            currNode = prev;

            int count = 0;
            while (currNode.data != element){
                count++;
                currNode = currNode.next;
            }

            System.out.println(count);
        }

        void removeDuplicate() {
            Node currNode = head;

            while (currNode.next != null) {

                if(currNode.data == currNode.next.data){
                    currNode.next = currNode.next.next;
                    continue;
                }

                currNode = currNode.next;

            }

        }

        
    }

    public static void main(String[] args) {

        Methods m1 = new Methods();


        m1.insertAtEnd(1);
        m1.insertAtEnd(2);
        m1.insertAtEnd(2);
        m1.insertAtEnd(4);
        m1.insertAtEnd(2);
        m1.insertAtEnd(5);
        m1.traverse();

        m1.traverse();



//        m1.insertAtPosition(1000,0);
//        m1.traverse();
//        m1.deleteNode(3);
//        m1.reverseLL();
//        m1.findPositionFromEnd(1000);
    }
}



