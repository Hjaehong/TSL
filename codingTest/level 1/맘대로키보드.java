import java.util.*;

public class Solution {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};
        Map<Character, Integer> key1= new LinkedHashMap<>();
        Map<Character, Integer> key2= new LinkedHashMap<>();
        int val = 0;
        String k = "";

        for(int z = 0; z < keymap.length; z++) {
            if(key1.isEmpty()) {
                k = keymap[0];
                for(int i = 0; i < k.length(); i++) {
                    if(key1.containsKey(k.charAt(i))) {
                        continue;
                    } else {
                        key1.put(k.charAt(i),i + 1);
                    }
                }
            } else {
                k = keymap[1];
                for(int i = 0; i < k.length(); i++) {
                    if(key2.containsKey(k.charAt(i))) {
                        continue;
                    } else {
                        key2.put(k.charAt(i),i+1);
                    }
                }
            }
        }
        return answer;
    }
}

//==================================================================

// main

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));




    }
}