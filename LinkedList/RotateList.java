package solvedArchive.LinkedList;

public class RotateList {
    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        head.next = new LLNode(2);
        head.next.next = new LLNode(3);
        head.next.next.next = new LLNode(4);
        head.next.next.next.next = new LLNode(5);

        traverse(rotateRight(head, 6));

    }

    static void traverse(LLNode head){
        if(head==null)
            return;

        System.out.print(head.data+" ");

        traverse(head.next);
    }


    static LLNode rotateRight(LLNode head, int k){
        int length = 0;
        LLNode temp = head;

        while(temp!= null) {
            temp = temp.next;
            length++;
        }

        if(k==length)
            return head;

        k = k>length ? k%length : k;
        System.out.println(k);

        int back = -1*k + 1;
        LLNode frontNode = head;
        LLNode backNode = head;


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
