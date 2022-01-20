package solvedArchive.Strings;

public class RansomNote {

    public static void main(String[] args) {
        System.out.println(ransomNote("aa","ab"));
    }

    static boolean ransomNote(String ransom, String magazine){

        int charCount[] = new int[26];

        for(int i=0 ; i<ransom.length() ; i++)
            charCount[ransom.charAt(i)-97]++;


        for(int i=0 ; i<magazine.length() ; i++)
            if(charCount[magazine.charAt(i)-97]!=0)
                charCount[magazine.charAt(i)-97]--;


        for(int i : charCount)
            if(i!=0)
                return false;

        return true;
    }

}
