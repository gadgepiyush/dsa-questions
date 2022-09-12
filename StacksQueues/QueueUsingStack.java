package solvedArchive.StacksQueues;
import java.util.Stack;

class QueueUsingStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public QueueUsingStack() {
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }

        int x = s2.pop();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return x;
    }

    public int peek() {
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.peek();

        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }

        return x;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}


class Main{
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        System.out.println(q.pop());
        q.push(5);

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());

    }
}