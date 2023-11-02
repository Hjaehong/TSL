import java.util.*;
class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};
        // 문자 쪼개기
        String[] splitRes;
        HashMap<String, Integer> splitMap = new HashMap<>();

        for (String r : routes) {
            splitRes = r.split(" ");
            splitMap.put(splitRes[0], Integer.parseInt(splitRes[1]));
        }
        Set<String> keys = splitMap.keySet();
        
        for (String key : keys) {

           switch (key) {
               case "E" :
                   answer[1] += splitMap.get(key);
                   break;
               case "W" :
                   answer[1] -= splitMap.get(key);
                   break;
               case "S" :
                   answer[0] += splitMap.get(key);
                   break;
               case "N" :
                   answer[0] -= splitMap.get(key);
                   break;
           }
       
        
        }
        return answer;
    }
}