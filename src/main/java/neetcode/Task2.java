package neetcode;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(isAnagram("rota", "taro"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        return Arrays.equals(sCharArray, tCharArray);
    }
}
