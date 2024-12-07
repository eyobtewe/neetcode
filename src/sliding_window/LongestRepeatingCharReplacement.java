package sliding_window;

public class LongestRepeatingCharReplacement {

    public static void main(String[] args) {
//        System.out.println(
//                characterReplacement("XYYX", 2)
//        );
//        System.out.println(
//                characterReplacement("BAAABABB", 3)
//        );
//        System.out.println(
//                characterReplacement("AAABABB", 1)
//        );
//        System.out.println(
//                characterReplacement("ABBB", 2)
//        );
        System.out.println(
                characterReplacement("ABAB", 1)
        );
    }

    public static int characterReplacement(String s, int k) {
        System.out.println(s);

        if ( s == null || s.isEmpty() ) return 0;

        int left = 0, right = 0;
        int i = 0, j = 1;

        int maxLength = 1;

        while ( j < s.length() ) {
            if ( s.charAt(i) == s.charAt(j) ) {
                if ( j - i >= maxLength ) {
                    left = i;
                    right = j;
                    maxLength = j - i + 1;
                }
            } else {
                i = j;
            }
            j++;

        }

        if ( j-i == s.length() ) {
            return j-i;
        }

        StringBuilder sss = new StringBuilder(s);
        String repeaString = s.substring(left, left + 1);

        int counter = k;

        while ( true ) {
            if ( left > 0 && counter > 0 ) {
                int index = --left;
                char ch = sss.charAt(index);
                if ( !String.valueOf(ch).equals(repeaString) ) {
                    sss.setCharAt(index, repeaString.charAt(0));
                    counter--;
                }
            }
            if ( right < (s.length() - 1) && counter > 0 ) {
                int index = ++right;
                char ch = sss.charAt(index);
                if ( !String.valueOf(ch).equals(repeaString) ) {
                    sss.setCharAt(index, repeaString.charAt(0));
                    counter--;
                }
            }

            if ( counter >= 0 ) {
                if ( left > 0 && sss.charAt(left) == sss.charAt(left - 1) ) {
                    --left;
                } else if ( right < sss.length() - 1 && sss.charAt(right) == sss.charAt(right + 1) ) {
                    ++right;
                } else {
                    break;
                }
            }else {
                break;
            }
        }


        System.out.printf("\n" + sss + " %d [%d, %d]\n", counter, left, right);

        return right - left + 1;
    }
}
