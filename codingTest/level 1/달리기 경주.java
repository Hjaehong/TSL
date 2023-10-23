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