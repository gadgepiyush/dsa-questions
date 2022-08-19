package solvedArchive.Maths;

//Sieve of Eratosthenes
//Counts number of prime numbers in the given range
public class CountPrimes{
    public static void main(String[] args) {
        System.out.println(countPrimes(2));
    }

    static int countPrimes(int n){
        int count = 0;
        boolean isPrime[] = new boolean[n+1];

        isPrime[1] = true;

        int i;
        for(i=2 ; i*i<=n ; i++){
            for(int j=2*i ; j<=n ; j+=i){
                isPrime[j] = true;
            }
        }

        for(int j=1 ; j<n ; j++){
            if(isPrime[j]==false)
                count++;
        }

        return count;
    }


}
