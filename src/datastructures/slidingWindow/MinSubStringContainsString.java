package datastructures.slidingWindow;

import java.util.*;


/**
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 *
 * */
class MinSubStringContainsStringSolution {
    boolean isEqual(Map<Character, Integer> smp, Map<Character, Integer> tmp) {
        for (Map.Entry<Character, Integer> record: tmp.entrySet()) {
            if (record.getValue() > smp.getOrDefault(record.getKey(), 0)) return false;
        }
        return true;
    }


    public String minWindow(String s, String t) {
        int i, j, n, m;
        n = s.length();
        m = t.length();
        String ans = "";

        Map<Character, Integer> smp = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();



        for (char x: t.toCharArray()) tmp.put(x, tmp.getOrDefault(x, 0) + 1);
        j = 0;

        for (i = 0; i < n; i++) {
            smp.put(s.charAt(i), smp.getOrDefault(s.charAt(i), 0) + 1);
            while (j < i &&
                    (tmp.getOrDefault(s.charAt(j), 0) == 0
                            || (smp.getOrDefault(s.charAt(j), 0) > tmp.getOrDefault(s.charAt(j), 0))))
            {
                smp.put(s.charAt(j), smp.getOrDefault(s.charAt(j), 0) - 1);
                j++;
            }

            if (isEqual(smp, tmp) && (ans.isEmpty() || ans.length() > (i - j + 1))) ans = s.substring(j, i + 1);
        }
        return ans;
    }
}

public class MinSubStringContainsString {
}
