package arrays_n_hashing;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        if ( s.isEmpty() || s.length() == 1 ) return true;

        char[] cleanedUp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
//        System.out.println(cleanedUp.length);
        int j = cleanedUp.length - 1;

        for ( int k = 0; k < cleanedUp.length / 2; k++ ) {
            if ( cleanedUp[k] != cleanedUp[j--] ) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println( isPalindrome("Was it a car or a cat I saw?"));


        System.out.println(isPalindrome("tab a bat"));


    }
}
