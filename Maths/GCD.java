package solvedArchive.Maths;

public class GCD {
    public static void main(String[] args) {
        System.out.println(gcd(9,6));
    }

    static int gcd(int n1, int n2){
        int min = Math.min(n1, n2);
        int gcd=1;

        for (int i=1 ; i<=min ; i++){
            if(n1%i==0 && n2%i==0)
                gcd = i;
        }

        return gcd;
    }
}
