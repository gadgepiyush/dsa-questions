package solvedArchive.LinkedList;

public class LinkedList2{
    public static void main(String[] args) {

        LLNode n1 = new LLNode(1);
        insertNode(n1, 2);
        insertNode(n1, 2);
        insertNode(n1, 1);
//        insertNode(n1, 7);
//        insertNode(n1, 5);
//        insertNode(n1, 6);
        traverse(n1);
        LLNode n2 = removeVal(n1, 2);
        traverse(n2);


    }

    static void insertNode(LLNode head, int val){
        if(head.next==null){
            head.next = new LLNode(val);
            return;
        }

        insertNode(head.next, val);
    }


    static void traverse(LLNode head){
        if(head==null){
            System.out.println("null");
            return;
        }

        System.out.print(head.data+" -> ");

        traverse(head.next);
    }


    static LLNode removeVal(LLNode head, int val){


        if(head.data==val)
            head=head.next;
        removeValHelper(head, val);



        return head;
    }

    static void removeValHelper(LLNode head, int val){

        if(head==null)
            return;

        if(head.next!=null && head.next.data==val){
            head.next=head.next.next;
            removeValHelper(head, val);
        }
        else{
            removeValHelper(head.next, val);
        }
    }

}






