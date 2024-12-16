package sliding_window;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindowString {
    public static void main(String[] args) {
        System.out.println(minWindow("OUZODYXAZV", "XYZ"));
    }

    public static String minWindow(String s, String t) {

        Set<Character> tt = new HashSet<>();
        for ( char c : t.toCharArray() ) tt.add(c);

        int left = 0, right = tt.size();
        int counter=0;

        int index=0;

        while ( index < s.length() ) {

            if ( counter==tt.size() ) return s.substring(left,right);


            if ( tt.contains(s.charAt(index)) ) {
                 counter++;
            } else if ( counter==0 ) {
                left++;
            }


            index++;
            right++;

        }

        return "";
    }
}
