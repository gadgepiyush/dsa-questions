package solvedArchive.BitManipulation;

public class EvenOdd {
    public static void main(String[] args) {
        int x = 6;

        //just perform AND(&) with one if it is one then odd else even
        if((x & 1) == 1){
            System.out.println("odd");
        }
        else {
            System.out.println("even");
        }
    }
}
