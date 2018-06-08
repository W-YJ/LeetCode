package SolutionsWithJava;

import java.util.ArrayList;
import java.util.List;

/*
 * 500. Keyboard Row
 * https://leetcode.com/problems/keyboard-row/description/
 * Runtime beats: 95.11
 * */
public class KeyboardRow {
    public static String[] findWords(String[] words) {
        String r1 = "qwertyuiop";
        String r2 = "asdfghjkl";
        String r3 = "zxcvbnm";

        char[] word;
        String check;
        List<String> out = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            word = words[i].toLowerCase().toCharArray();

            if (word.length == 1) {
                out.add(words[i]);
            }

            if (r1.indexOf(word[0]) > -1) {
                check = r1;
            } else if (r2.indexOf(word[0]) > -1) {
                check = r2;
            } else if (r3.indexOf(word[0]) > -1) {
                check = r3;
            } else {
                return out.toArray(new String[0]);
            }

            for (int j = 1; j < word.length; j++) {
                if (check.indexOf(word[j]) == -1) {
                    break;
                }

                if (j == word.length - 1) {
                    out.add(words[i]);
                }
            }
        }
        return out.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] input = {"asdfghjkla", "qwertyuiopq", "zxcvbnzzm", "asdfghjkla", "qwertyuiopq", "zxcvbnzzm"};
        String[] output = KeyboardRow.findWords(input);
        for (String s : output) {
            System.out.println(s);
        }

    }
}
