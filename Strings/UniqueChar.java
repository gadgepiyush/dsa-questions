package solvedArchive.Strings;

import java.util.HashMap;

public class UniqueChar{

    //naive way first unique char in String (leetcode- 387)
    static int firstUniqueChar(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0 ; i<s.length() ; i++){
            char temp = s.charAt(i);

            if(map.containsKey(temp)){
                map.put(temp , map.get(temp)+1);
            }
            else{
                map.put(temp, 1);
            }
        }

        int i=0;
        for(char c: s.toCharArray()){
            if(map.get(c)==1){
                return i;
            }
            i++;
        }

        return -1;
    }


}
