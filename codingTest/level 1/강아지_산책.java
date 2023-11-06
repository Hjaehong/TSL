import java.util.*;
class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};
        int width = park[0].length()-1;
        int height = park.length - 1;
        // 공원 다 자르기
        for(int i = 0; i < park.length; i++) {
            String[] findStart = park[i].split("");

            for (int j = 0; j < findStart.length; j++) {
                // 시작 지점 설정
                if (findStart[j].equals("S")) {
                    answer[0] = i;
                    answer[1] = j;
                }
                // x 부분 못 지나가게
            }
        }

        // 로봇 강아지 움직이는 방법

        // 문자 쪼개기
        String[] splitRes;
        Map<String, Integer> splitMap = new LinkedHashMap<>();
        for (String r : routes) {
            splitRes = r.split(" ");
            splitMap.put(splitRes[0], Integer.parseInt(splitRes[1]));
        }

        Set<String> keys = splitMap.keySet();

       for (String key : keys) {

           switch (key) {
               case "E" :
                   answer[1] += splitMap.get(key);
                   if(answer[1] > width) {
                       answer[1] -= splitMap.get(key);
                   }
                   break;
               case "W" :
                   answer[1] -= splitMap.get(key);
                   if(answer[1] < 0) {
                       answer[1] += splitMap.get(key);
                   }
                   break;
               case "S" :
                   answer[0] += splitMap.get(key);
                   if(answer[0] > height) {
                       answer[0] -= splitMap.get(key);
                   }
                   break;
               case "N" :
                   answer[0] -= splitMap.get(key);
                   if(answer[0] < height) {
                       answer[0] += splitMap.get(key);
                   }
                   break;
           }
       }


        return answer;
    }
}
