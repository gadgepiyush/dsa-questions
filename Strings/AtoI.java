package solvedArchive.Strings;

public class AtoI{
    public static void main(String[] args) {
        String str = "words and 987";

        System.out.println(atoI(str));
    }

    static int atoI(String s) {
        int res = 0;
        boolean flag = false;
        int i=0;
        while(s.charAt(i)=='-' || s.charAt(i)<'0' || s.charAt(i)>'9') {
         if(s.charAt(i)=='-')
                flag = true;
            i++;
        }

        for(int j=i ; j<s.length() ; j++){
            if(s.charAt(j)<'0' || s.charAt(j)>'9')
                break;

            res *= 10;
            res += s.charAt(j) -'0';
        }

        if(flag==true)
            res *= -1;

        return res;
    }
}