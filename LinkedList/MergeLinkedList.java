package solvedArchive.LinkedList;

public class MergeLinkedList {

    public static void main(String[] args) {
        LLNode n1 = new LLNode(1);
        LLNode n2 = new LLNode(1);

        LinkedList2.insertNode(n1, 2);
        LinkedList2.insertNode(n1, 4);

        LinkedList2.insertNode(n2, 3);
        LinkedList2.insertNode(n2, 4);

        LinkedList2.traverse(LLMerge(n1,n2));
    }

    static LLNode LLMerge(LLNode n1, LLNode n2){

        if(n1==null)
            return n2;
        else if(n2==null)
            return n1;
        else if(n1==null && n2==null)
            return null;

        LLNode head = null;

        if(n1.data < n2.data){
            head=n1;
            n1 = n1.next;
        }
        else {
            head= n2;
            n2 = n2.next;
        }

        LLNode currNode = head;
        while(n1!=null && n2 !=null){
            if(n1.data < n2.data){
                currNode.next = n1;
                n1 = n1.next;
            }
            else{
                currNode.next = n2;
                n2 = n2.next;
            }
            currNode = currNode.next;
        }

        while(n1!=null){
            currNode.next=n1;
            n1=n1.next;
            currNode = currNode.next;
        }

        while(n2!=null){
            currNode.next=n2;
            n2=n2.next;
            currNode = currNode.next;
        }

        return head;
    }

}
