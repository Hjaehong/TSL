public class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int[] wall = new int[n];


        for(int s : section) {
            wall[s-1] = 1;
        }
        for(int i = 0; i < n;) {
            if(wall[i] == 1) {
                answer++;
                int end = Math.min(i + m, n);
                for(int j = i; j < end; j++) {
                    wall[j] = 0;
                }
                i = end;
            } else {
                i++;
            }
        }

        return answer;
    }


}

