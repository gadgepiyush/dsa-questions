package solvedArchive.Maths;

//counts number of trailing zeros in the numbers because calculating factorial of very big number would give overflow
public class TrailingZeros {
    public static void main(String[] args) {
        int n = 99;

        System.out.println(trailingZeros(n));
    }

    static int trailingZeros(int n){
        int count = 0;

        for(int i=5 ; i<=n ; i*=5){
            count += n/i;
        }

        return count;
    }
}
