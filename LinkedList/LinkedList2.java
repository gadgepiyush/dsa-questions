package solvedArchive.LinkedList;

public class LinkedList2{
    public static void main(String[] args) {

        LLNode n1 = new LLNode(1);
        insertNode(n1, 2);
        insertNode(n1, 3);
        insertNode(n1, 3);
        insertNode(n1, 2);
        insertNode(n1, 1);
        traverse(n1);

        System.out.println(palindromeLL(n1));

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


    static boolean palindromeLL(LLNode head){
        LLNode fast = head;
        LLNode slow = head;

        //finding the mid-point
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        //reversing the LL from tail to mid-point
        LLNode prev = null;
        LLNode curr = slow;
        while(curr != null){
            LLNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //checking the palindrome
        while(prev != null){
            if(head.data != prev.data)
                return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }

}






