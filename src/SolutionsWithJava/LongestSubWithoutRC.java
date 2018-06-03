package SolutionsWithJava;

import java.util.HashSet;
import java.util.Set;

/* 3. Longest Substring Without Repeating Characters
 * Runtime Beats: 13.43%
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * */
public class LongestSubWithoutRC {
    public int lengthOfLongestSubstring(String s) {
        if (s.equals(""))
            return 0;
        Set<String> set = new HashSet<>();
        int max = 0, lastpos = 0, position = 0;
        String[] sa = s.split("");
        for (int i = 0; i < sa.length; i++) {
            if (!set.contains(sa[i])) {
                set.add(sa[i]);
            } else {
                if (set.size() > max)
                    max = set.size();

                lastpos = position;
                while (position < sa.length) {
                    if (sa[position].equals(sa[i]) && position < i) {
                        break;
                    }
                    position++;
                }

                position++;

                for (int j = lastpos; j < position; j++) {
                    set.remove(sa[j]);
                }
                set.add(sa[i]);

            }
        }
        return set.size() > max ? set.size() : max;
    }

    public static void main(String[] args) {
        String s = "umvejcuuk";
        LongestSubWithoutRC longestSubWithoutRC = new LongestSubWithoutRC();
        System.out.println(longestSubWithoutRC.lengthOfLongestSubstring(s));
    }
}
