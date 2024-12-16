package sliding_window;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(characterReplacement("XYYX", 2));
        System.out.println(characterReplacement("BAAABABB", 3));
        System.out.println(characterReplacement("AAABABB", 1));
        System.out.println(characterReplacement("ABBB", 2));
        System.out.println(characterReplacement("ABAB", 1));
    }

    public static int characterReplacement(String s, int k) {

        // Frequency array for 26 uppercase English letters
        int[] count = new int[26];
        int maxFreq = 0, res = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            // Increment the count for the current character
            count[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

            // Shrink the window if it exceeds the allowable replacements
            while ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            // Update the result with the current window size
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

}
