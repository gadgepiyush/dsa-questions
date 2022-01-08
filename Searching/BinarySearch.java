package solvedArchive.Searching;

public class BinarySearch {

    public static void main(String[] args) {

        int x= mySqrt(8);
        System.out.println(x);

    }

    static int mySqrt(int x){

        int start=0;
        int end = x;

        while (start <= end) {

            long mid = (start+end)/2;

            if(mid*mid > x){
                end = (int)mid-1;
            }
            else if(mid*mid < x){
                start = (int)mid+1;
            }
            else{
                return (int)mid;
            }
        }


        return end;
    }

}
