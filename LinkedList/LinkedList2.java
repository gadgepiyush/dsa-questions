package solvedArchive.LinkedList;

public class LinkedList2{
    public static void main(String[] args) {

        LLNode n1 = new LLNode(1);
        insertNode(n1, 3);
        insertNode(n1, 4);
        insertNode(n1, 7);
        insertNode(n1, 1);
        insertNode(n1, 2);
        insertNode(n1, 6);
        traverse(n1);

        traverse(deleteMiddle(n1));


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


    //leetcode 234
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


    //leetcode 24 Swap Nodes in Pairs
    static LLNode swapNode(LLNode head){
        if(head==null || head.next==null)
            return head;

        LLNode newHead = head.next;

        LLNode temp = head.next.next;
        head.next.next = head;
        head.next = temp;

        LLNode prev = head;
        while(prev.next != null && prev.next.next!=null){
            LLNode nextNode = prev.next;
            LLNode nextNextNode = prev.next.next;

            prev.next = nextNextNode;
            nextNode.next = nextNextNode.next;
            nextNextNode.next = nextNode;

            prev = nextNode;
        }

        return newHead;
    }


    //leetcode 1721 Swapping Nodes in a Linked List kth position from start and end
    static LLNode swapNodePosition(LLNode head, int k){

        LLNode originalHead = head;
        LLNode temp1 = head;

        int length = 0;
        while(head!=null){              //finding the length of the linkedlist
            length++;
            head = head.next;
        }

        int i = 1;

        while(i!=k){                    //finding the element at the kth position from start
            temp1 = temp1.next;
            i++;
            length--;
        }

        LLNode temp2 = temp1;
        if(i<length){                   //finding the element at kth position from end
            while (i < length) {
                temp2 = temp2.next;
                i++;
            }
        }
        else {                          //finding the element at kth position from start
            temp2 = originalHead;
            int pointerHead = 1;
            while(pointerHead<length){
                temp2 = temp2.next;
                pointerHead++;
            }
        }

        int temp = temp1.data;          //swapping the obtained node
        temp1.data = temp2.data;
        temp2.data = temp;

        return originalHead;
    }


    //leetcode 19 Remove Nth Node From End of List
    static LLNode swapFromEnd(LLNode head, int n){
        LLNode originalHead = head;

        int backPointer = -1*n;
        LLNode backNode = head;
        while(head != null){
            if(backPointer>0){
                backNode = backNode.next;
            }
            backPointer++;
            head = head.next;
        }

        if(originalHead==backNode)
            return backNode.next;

        backNode.next = backNode.next!=null ? backNode.next.next : null;

        return backPointer>0 ? originalHead : originalHead.next;
    }


    //leetcode 2095 Delete the Middle Node of a Linked List
    static LLNode deleteMiddle(LLNode head){
        LLNode fast = head;
        LLNode slow = head;
        LLNode prev = null;

        while(fast != null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = slow.next;

        return head;
    }

}






