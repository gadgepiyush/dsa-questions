package solvedArchive.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//leetcode 3
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        int back = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;

        for(int front = 0 ; front<s.length() ; front++){
            while (set.contains(s.charAt(front))){
                set.remove(s.charAt(back));
                back++;
            }

            set.add(s.charAt(front));
            max = Math.max(max, front - back +1);
        }

        return max;
    }
}
