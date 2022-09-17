package solvedArchive.Strings;

public class RomanToInteger {
    public static void main(String[] args) {
        String str = "MCMXCIV";

        System.out.println(romanToInt(str));
    }

    static int romanToInt(String s){
        int total = 0;
        for(int i=0 ; i<s.length()-1 ; i++){
            if(getValue(s.charAt(i))<getValue(s.charAt(i+1)))
                total -= getValue(s.charAt(i));
            else
                total +=getValue(s.charAt(i));

        }

        total += getValue(s.charAt(s.length()-1));

        return total;
    }


    static int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }
}