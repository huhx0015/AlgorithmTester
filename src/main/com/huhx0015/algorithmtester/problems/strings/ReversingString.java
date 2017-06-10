package main.com.huhx0015.algorithmtester.problems.strings;

/**
 * Created by Michael Yoon Huh on 3/31/2017.
 */
public class ReversingString {

    public static void main(String[] args) {
        System.out.println(reverseString("hello my name is korean"));
    }

    private static String reverseString(String str) {
        char[] reversedStringArray = new char[str.length()];

        int j = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStringArray[j] = str.charAt(i);
            j++;
        }

        return String.valueOf(reversedStringArray);
    }
}
