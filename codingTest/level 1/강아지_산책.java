import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int[] Solution(String[] park, String[] routes) {

        // 선언부
        int[] answer = {0,0};
        int width = park[0].length()-1;
        int height = park.length - 1;
        String[][] parks = new String[park.length][park[0].length()];

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
                parks[i][j] = findStart[j];
            }
        }

        // 로봇 강아지 움직이는 방법

        // 문자 쪼개기 ( 방향, 이동 거리 )
        String[] splitRes;
        Map<String, Integer> splitMap = new LinkedHashMap<>();
        for (String r : routes) {
            splitRes = r.split(" ");
            splitMap.put(splitRes[0], Integer.parseInt(splitRes[1]));
        }

        Set<String> keys = splitMap.keySet();

        for (String key : keys) {
                    // x 위치를 지나가면 원래자리로 되돌아감
            MeetX(splitMap.get(key), parks, answer, key, width, height);

        }
        
        return answer;
    }

    private void MeetX(int end, String[][] parks, int[] answer, String key, int width, int height) {
        int x = 0;
        int y = 0;
        for(int i = 0; i < end; i++){
            switch (key) {
                case "E":
                    answer[1] += 1;
                    break;
                case "S":
                    answer[0] += 1;
                    break;
                case "W":
                    answer[1] -= 1;
                    break;
                case "N":
                    answer[0] -= 1;
                    break;
            }
            if ( x < height && y < width) {
                x = answer[0];
                y = answer[1];
            }

            if(parks[x][y].equals("X") && key.equals("E")|| answer[1] > width) {
                answer[1] -= y;
                break;
            } else if (parks[x][y].equals("X") && key.equals("W")) {
                answer[1] += y;
                break;
            } else if( parks[x][y].equals("X") && key.equals("S")|| answer[0] > height){
                answer[0] -= x;
                break;
            } else if( parks[x][y].equals("X") && key.equals("N")) {
                answer[0] += x;
                break;
            }
        }
    }

}




// 수정 본

import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        // 선언부
        int[] answer = {0, 0};
        int height = park.length;
        int width = park[0].length();
        String[][] parks = new String[height][width];

        // 공원 다 자르기
        for (int i = 0; i < park.length; i++) {
            parks[i] = park[i].split("");
            for (int j = 0; j < width; j++) {
                // 시작 지점 설정
                if (parks[i][j].equals("S")) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        // 로봇 강아지 움직이기
        for (String r : routes) {
            String[] splitRes = r.split(" ");
            String direction = splitRes[0];
            int steps = Integer.parseInt(splitRes[1]);

            // 이동 전 위치 저장
            int[] prevPos = Arrays.copyOf(answer, answer.length);

            // 이동
            for (int i = 0; i < steps; i++) {
                switch (direction) {
                    case "E":
                        answer[1]++;
                        break;
                    case "S":
                        answer[0]++;
                        break;
                    case "W":
                        answer[1]--;
                        break;
                    case "N":
                        answer[0]--;
                        break;
                }
                // 벽(X)를 만나거나 범위를 벗어난 경우
                if (answer[0] >= height || answer[1] >= width || answer[0] < 0 || answer[1] < 0 || parks[answer[0]][answer[1]].equals("X")) {
                    answer[0] = prevPos[0];
                    answer[1] = prevPos[1];
                    break;
                }
            }
        }

        return answer;
    }

}