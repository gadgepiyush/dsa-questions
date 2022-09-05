package solvedArchive.LinkedList;


//leetcode 92 reverse LL 2
public class ReverseLL {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);

        traverse(reverseBetween(head, 1, 2));


    }

    static void traverse(LLNode head){
        while (head != null){
            System.out.print(head.data+"-> ");
            head = head.next;
        }
    }


    static LLNode reverseBetween(LLNode head, int left, int right){

        LLNode n1 = head;
        LLNode n2 = head;
        LLNode n1Prev = head;
        int leftOriginal = left;

        while(left>2){
            n1 = n1.next;
            n2 = n2.next;
            n1Prev = n1Prev.next;
            left--;
            right--;
        }

        while(left != 1){
            n1 = n1.next;
            n2 = n2.next;
            left--;
            right--;
        }

        while(right != 1){
            n2 = n2.next;
            right--;
        }

        LLNode n2Next = n2.next;

        LLNode prev = null;
        LLNode curr = n1;
        while(curr != n2Next){
            LLNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        n1Prev.next = n2;
        n1.next = n2Next;

        return head.next==null || leftOriginal==1 ? n2 : head;
    }



}
