package solvedArchive.LinkedList;


//leetcode 92 reverse LL 2
public class ReverseLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        /*head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);*/

        traverse(reverseBtwn(head,1, 2));


    }

    static void traverse(ListNode head){
        while (head != null){
            System.out.print(head.data+"-> ");
            head = head.next;
        }
    }

    static ListNode reverseBetween(ListNode head, int left, int right){

        ListNode n1 = head;
        ListNode n2 = head;
        ListNode n1Prev = head;
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

        ListNode n2Next = n2.next;

        ListNode prev = null;
        ListNode curr = n1;
        while(curr != n2Next){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        n1Prev.next = n2;
        n1.next = n2Next;

        return head.next==null || leftOriginal==1 ? n2 : head;
    }

    static ListNode reverseLL(ListNode head){
        if(head==null)
            return null;

        ListNode prev = null;
        ListNode curr = head;


        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    static ListNode reverseBtwn(ListNode head, int left, int right){
        int temp = 0;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode beforeLeft = dummyNode;

        while(temp<left-1){
            beforeLeft = beforeLeft.next;
            temp++;
        }

        ListNode currNode = beforeLeft.next;
        ListNode prevNode = null;
        while(left<=right){
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            left++;
        }

        currNode.next= currNode;
        beforeLeft.next = prevNode;

        return dummyNode.next;
    }
}
