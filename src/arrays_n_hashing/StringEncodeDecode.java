package arrays_n_hashing;

import java.util.List;

public class StringEncodeDecode {

    public static void main(String[] args) {
        List<String> words = List.of("Wood", "Goon", "Hammer");
//        List<String> word2 = List.of();
//        List<String> word3 = List.of("");
        List<String> word4 = List.of("","   ","!@#$%^&*()_+","LongStringWithNoSpaces","Another, String With, Commas");

        String enco = encode(words);
//        String enco2 = encode(word2);
//        String enco3 = encode(word3);
        String enco4 = encode(word4);


        List<String> decodedWords = decode(enco);
//        List<String> decodedWords2 = decode(enco2);
//        List<String> decodedWords3 = decode(enco3);
        List<String> decodedWords4 = decode(enco4);

        System.out.println("-e>"+enco+"<-");
        System.out.println("->"+decodedWords+"<-");
//        System.out.println("->"+enco2+"<-");
//        System.out.println("->"+decodedWords2+"<-");
//        System.out.println("->"+enco3+"<-");
//        System.out.println("->"+decodedWords3+"<-");
        System.out.println("-e>"+enco4+"<-");
        System.out.println("->"+decodedWords4+"<-");

    }

    public static String encode(List<String> strs) {
        StringBuilder phrase = new StringBuilder();

        if ( strs.size()==0 ){
            return null;
        } else if ( strs.size()==1 && strs.isEmpty() ) {
            return "";
        }

        for ( int i = 0; i < strs.size(); i++ ) {

            phrase.append(strs.get(i)).append(i + 1 == strs.size() ?
                    "" : "\n");

        }
        return phrase.toString();
    }



    public static List<String> decode(String str) {
//        System.out.println("-> decode"+str+"<-");
        if ( str == null ){
            return List.of();
        }
        return List.of(str == "" ? new String[]{""} : str.split("\n"));
    }
}
