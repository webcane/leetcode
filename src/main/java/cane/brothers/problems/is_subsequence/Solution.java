package cane.brothers.problems.is_subsequence;

public class Solution {

    public static boolean is_subsequence(String full, String search) {
//        int one = 0;
        int match = 0;
        for (int i = 0; i < full.length(); i++) {
            if (full.charAt(i) == search.charAt(match)) {
                match++;

                if (match == search.length()) {
                    return true;
                }
            }
        }
        return false;
//        while (one < full.length() && match < search.length()) {
//            var c1 = full.charAt(one);
//            var c2 = search.charAt(match);
//            if (c1 == c2) {
//                match++;
//            }
//            one++;
//        }
//        return match == search.length();
    }

}
