package solvedArchive.LinkedList;

public class PalindromeLL {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(ListNode head){

        ListNode slow = head;
        ListNode fast = head;

        //find midpoint
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow;
        ListNode prev = null;

        //reverse LL from mid
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //checking from the two heads obtained if it is palindrome
        while(prev!=null){
            if(head.data != prev.data)
                return false;

            head = head.next;
            prev = prev.next;
        }

        return true;
    }
}
