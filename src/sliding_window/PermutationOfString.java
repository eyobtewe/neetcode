package sliding_window;

public class PermutationOfString {
    public static void main(String[] args) {
        System.out.println("\n" + checkInclusion("abc", "leetcaabode"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26], count2 = new int[26];
        int matches = 0;

        // Populate frequency arrays for s1 and the initial window of s2
        for (int i = 0; i < s1.length(); i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Initialize matches for the first window
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        // Sliding window to compare subsequent windows in s2
        for (int right = s1.length(); right < s2.length(); right++) {
            int left = right - s1.length();

            if (matches == 26) return true; // All characters match

            // Slide the window: remove left character and add right character
            int leftChar = s2.charAt(left) - 'a';
            int rightChar = s2.charAt(right) - 'a';

            // Update matches for the left character being removed
            if (count1[leftChar] == count2[leftChar]) matches--;
            count2[leftChar]--;
            if (count1[leftChar] == count2[leftChar]) matches++;

            // Update matches for the right character being added
            if (count1[rightChar] == count2[rightChar]) matches--;
            count2[rightChar]++;
            if (count1[rightChar] == count2[rightChar]) matches++;
        }

        return matches == 26;
    }

}

/*
//class Solution {
//    public static boolean checkInclusion(String s1, String s2) {
/// /        System.out.printf("\n %s, %s\n\n", s1, s2);
//
//        if ( s1.length() > s2.length() ) return false;
//
//        int left = 0;
//        int right = s1.length() - 1;
//
//        HashMap<Character, Integer> s1Map, s2Map;
//
//        s1Map = new HashMap<>();
//        s2Map = new HashMap<>();
//
//        char[] s1CharArray = s1.toCharArray();
//        char[] s2CharArray = s2.toCharArray();
//
//        for ( int i = 0; i < s1.length(); i++ ) {
//            char c = s1CharArray[i];
//            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
//            c = s2CharArray[i];
//            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
//        }
//
//        while ( true ) {
//            System.out.printf("\n+ | %s - %s |",s1Map,s2Map);
//            if ( s1Map.equals(s2Map) ) return true;
//
//            left++;
//            right++;
//
//            if ( right == s2.length() ) return false;
//
//            char cL = s2.charAt(left-1);
//            char cR = s2.charAt(right);
//
//            s2Map.put(cL, s2Map.get(cL) - 1);
//            if ( s2Map.get(cL) == 0 ) s2Map.remove(cL);
//            s2Map.put(cR, s2Map.getOrDefault(cR, 0) + 1);
//
//
//        }
//
////        return false;
//    }
//}
*/