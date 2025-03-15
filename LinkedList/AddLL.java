package solvedArchive.LinkedList;


//leetcode 2 Add Two Numbers
public class AddLL {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(9);
        head1.next.next = new ListNode(9);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next = new ListNode(9);
        head1.next.next.next.next.next.next = new ListNode(9);


        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(9);
        head2.next.next.next = new ListNode(9);


        traverse(addTwoNumbers(head1, head2));

    }

    static void traverse(ListNode head){
        while (head != null){
            System.out.print(head.data+"-> ");
            head = head.next;
        }
    }

    static ListNode addTwoNumbers(ListNode head1, ListNode head2){
        int carry = (head1.data + head2.data)/10;
        ListNode newHead = new ListNode((head1.data + head2.data)%10);
        head1 = head1.next;
        head2 = head2.next;

        ListNode curr = newHead;
        while (head1 != null && head2 != null){
            curr.next = new ListNode((head1.data + head2.data + carry)%10);
            carry = (head1.data + head2.data + carry)/10;

            curr = curr.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null){
            curr.next = new ListNode((head1.data + carry)%10);
            carry = (head1.data + carry)/10;

            curr = curr.next;
            head1 = head1.next;
        }

        while (head2 != null){
            curr.next = new ListNode((head2.data + carry)%10);
            carry = (head2.data + carry)/10;

            curr = curr.next;
            head2 = head2.next;
        }

        if(carry!=0){
            curr.next = new ListNode(carry);
        }

        return newHead;
    }
}
