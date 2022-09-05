package solvedArchive.LinkedList;

public class PalindromeLL {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(2);
        head.next.next.next.next.next = new LLNode(2);
        head.next.next.next.next.next.next = new LLNode(1);

        System.out.println(isPalindrome(head));
    }

    static boolean isPalindrome(LLNode head){

        LLNode slow = head;
        LLNode fast = head;

        //find midpoint
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        LLNode curr = slow;
        LLNode prev = null;

        //reverse LL from mid
        while(curr!=null){
            LLNode temp = curr.next;
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
