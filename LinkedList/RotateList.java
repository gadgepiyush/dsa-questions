package solvedArchive.LinkedList;

public class RotateList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        traverse(rotateRight(head, 6));

    }

    static void traverse(ListNode head){
        if(head==null)
            return;

        System.out.print(head.data+" ");

        traverse(head.next);
    }


    static ListNode rotateRight(ListNode head, int k){
        int length = 0;
        ListNode temp = head;

        while(temp!= null) {
            temp = temp.next;
            length++;
        }

        if(k==length)
            return head;

        k = k>length ? k%length : k;
        System.out.println(k);

        int back = -1*k + 1;
        ListNode frontNode = head;
        ListNode backNode = head;


        while(frontNode.next != null){
            frontNode = frontNode.next;
            if(back>0){
                backNode = backNode.next;
            }
            back++;
        }

        frontNode.next = head;
        head = backNode.next;

        backNode.next = null;

        return head;
    }

}
