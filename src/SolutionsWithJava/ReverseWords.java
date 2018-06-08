package SolutionsWithJava;

/*
 * 151. Reverse Words in a String
 * runtime beats: 82.41%
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].equals("")) {
                stringBuilder.append(str[i] + " ");
            }
        }

        return String.valueOf(stringBuilder).trim();

    }

    public static void main(String[] args) {
        String s = "   a   b ";
        System.out.println(ReverseWords.reverseWords(s));

    }
}
