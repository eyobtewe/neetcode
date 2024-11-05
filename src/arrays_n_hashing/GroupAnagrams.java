package arrays_n_hashing;

import java.util.*;

public class GroupAnagrams {


    public static void main(String[] args) {

        String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};

        System.out.println();
        System.out.println(Arrays.toString(strs));
        System.out.println();
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anas = new HashMap<String, List<String>>();

        for ( String w : strs ){
            char[] w1 = w.toCharArray();
            Arrays.sort(w1);
            String key = Arrays.toString(w1);
//            String key = generateKey(w);
            if ( anas.containsKey(key) ){
                List<String> temp = anas.get(key);
                temp.add(w);
                anas.put(key,temp);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(w);
                anas.put(key,temp);
            }
        }

        List<List<String>>   anagrams = new ArrayList<>(anas.values());


        return anagrams;

    }

//        public static String generateKey(String word1) {
//            char[] w1 = word1.toCharArray();
//            Arrays.sort(w1);
//            return Arrays.toString(w1);
//        }

//    public static boolean isAnagram(String word1, String word2) {
//        if ( word1.length() != word2.length() ) {
//            return false;
//        }
//        char[] w1 = word1.toCharArray();
//        char[] w2 = word2.toCharArray();
//
//        Arrays.sort(w1);
//        Arrays.sort(w2);
//
//        boolean flag = Arrays.toString(w1).equals(Arrays.toString(w2));
////        if ( flag ){
////
////            System.out.println(Arrays.toString(w1)+" - "+Arrays.toString(w2));
////        }
//
//        return flag;
//    }

}
