package solvedArchive.LinkedList;


//leetcode 2 Add Two Numbers
public class AddLL {
    public static void main(String[] args) {
        LLNode head1 = new LLNode(9);
        head1.next = new LLNode(9);
        head1.next.next = new LLNode(9);
        head1.next.next.next = new LLNode(9);
        head1.next.next.next.next = new LLNode(9);
        head1.next.next.next.next.next = new LLNode(9);
        head1.next.next.next.next.next.next = new LLNode(9);


        LLNode head2 = new LLNode(9);
        head2.next = new LLNode(9);
        head2.next.next = new LLNode(9);
        head2.next.next.next = new LLNode(9);


        traverse(addTwoNumbers(head1, head2));

    }

    static void traverse(LLNode head){
        while (head != null){
            System.out.print(head.data+"-> ");
            head = head.next;
        }
    }

    static LLNode addTwoNumbers(LLNode head1, LLNode head2){
        int carry = (head1.data + head2.data)/10;
        LLNode newHead = new LLNode((head1.data + head2.data)%10);
        head1 = head1.next;
        head2 = head2.next;

        LLNode curr = newHead;
        while (head1 != null && head2 != null){
            curr.next = new LLNode((head1.data + head2.data + carry)%10);
            carry = (head1.data + head2.data + carry)/10;

            curr = curr.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        while (head1 != null){
            curr.next = new LLNode((head1.data + carry)%10);
            carry = (head1.data + carry)/10;

            curr = curr.next;
            head1 = head1.next;
        }

        while (head2 != null){
            curr.next = new LLNode((head2.data + carry)%10);
            carry = (head2.data + carry)/10;

            curr = curr.next;
            head2 = head2.next;
        }

        if(carry!=0){
            curr.next = new LLNode(carry);
        }

        return newHead;
    }
}
