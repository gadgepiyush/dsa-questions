package solvedArchive.BitManipulation;

//program to swap numbers using bit manipulation

public class Swapping{
    public static void main(String[] args){
        int a = 4;
        int b = 6;

        System.out.println("before swapping x and y are "+a+", "+b);

        /*
            for this operation we have to-do
            a^b three times and it will swap~ the numbers
        */

        a = a^b;
        b = a^b;
        a = a^b;

        System.out.println("after swapping x and y are "+a+", "+b);
    }
}
