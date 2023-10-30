import java.util.Arrays;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // String[] answer = new String[players.length];
        String temp="";
        int i = 0;
        for(int i = 0; i < callings.length; i++) {
            for(int j = 0; j < players.length; j++) {
                if(players[j].equals(callings[i]) && j >0) {
                    temp = players[j];
                    players[j] = players[j-1];    
                    players[j-1] = temp;
                }
            }
        }
    return players;
    }
}

// 시간 초과 해결하기

import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerIndexMap.put(players[i], i);
        }
        
        String temp;
        for (String calling : callings) {
						// hashMap에서 calling값과 일치하는 index 추출
            Integer index = playerIndexMap.get(calling);
            if (index != null && index > 0) {
                temp = players[index];
                players[index] = players[index-1];
                players[index-1] = temp;
                
                playerIndexMap.put(players[index], index);
                playerIndexMap.put(players[index-1], index-1);
                
            }
        }
        return players;
    }
}