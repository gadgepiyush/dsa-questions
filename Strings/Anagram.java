package solvedArchive.Strings;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {

        System.out.println(anagram2("aabac","baacc"));

    }

    //using hashmap
    static boolean anagram1(String s, String t){

        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i), 1);
            }
        }

        for(int i=0 ; i<t.length() ; i++){
            if(map.containsKey(t.charAt(i))  &&  map.get(t.charAt(i))!=0){
                map.put(t.charAt(i), map.get(t.charAt(i))-1);
            }
            else{
                return false;
            }
        }

        return true;
    }


    //using array
    static boolean anagram2(String s, String t){
        if(s.length() != t.length())
            return false;

        int charCount[] = new int[26];

        for(int i=0 ; i<s.length() ; i++)
            charCount[s.charAt(i) - 97]++;  // '97' is the ascii value of 'a'


        for(int i=0 ; i<t.length() ; i++){
            if(charCount[t.charAt(i)-97] != 0)
                charCount[t.charAt(i)-97]--;

            else
                return false;
        }

        return true;
    }


    //fastest working solutions
    static boolean anagram3(String s, String t){

        if(s.length()!=t.length())
            return false;

        int charCount[] = new int[26];

        for(int i=0 ; i<s.length() ; i++)
            charCount[s.charAt(i)- 97]++;

        for(int i=0 ; i<t.length() ; i++)
            charCount[t.charAt(i) -97]--;

        for(int i : charCount)
            if(i!=0)
                return false;

        return true;
    }
}
