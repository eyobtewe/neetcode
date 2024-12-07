package sliding_window;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {

    public static void main(String[] args) {
        lengthOfLongestSubstring("azxyzdjroxyz"); //7
        lengthOfLongestSubstring("abcabcbb"); //3
        lengthOfLongestSubstring("bbbbb"); //1
        lengthOfLongestSubstring("pwwkew"); //3
        lengthOfLongestSubstring(" "); //1
        lengthOfLongestSubstring("au"); //2
        lengthOfLongestSubstring("aab"); //2
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        System.out.println(s);

        HashSet<Character> set = new HashSet<>();
        int left = 0, maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If duplicate is found, move `left` to shrink the window
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character and update the max length
            set.add(currentChar);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        System.out.println(maxLength);
        return maxLength;
    }
}

