package solvedArchive.LinkedList;

public class LinkedList2{
    public static void main(String[] args) {

        LLNode n1 = new LLNode(2);
        insertNode(n1, 2);
        insertNode(n1, 2);
        insertNode(n1, 2);
        insertNode(n1, 5);
        insertNode(n1, 6);
        traverse(n1);
        removeDuplicate(n1);
        traverse(n1);

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


    // prevNode initially will be null when calling the func
    static LLNode reverse(LLNode currNode, LLNode prevNode){
        if(currNode==null)
            return prevNode;

        LLNode temp = currNode.next;
        currNode.next = prevNode;

        return reverse(temp, currNode);
    }


    //removes duplicate nodes
    static void removeDuplicate(LLNode head){

        if(head.next==null)
            return;

        if(head.data == head.next.data) {
            head.next = head.next.next;
            removeDuplicate(head);
        }
        else {

            removeDuplicate(head.next);
        }
    }


    //removes all occurrences of the val
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






