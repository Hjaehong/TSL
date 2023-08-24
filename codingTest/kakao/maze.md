## 첫번째 시도

```java
import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    char[] direction = {'u', 'd', 'l', 'r'};
    String answer = "impossible";
    HashSet<String> visitedStates = new HashSet<>();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x, y, r, c, k, "", new boolean[n + 1][m + 1]);
        return answer;
    }

    public void dfs(int n, int m, int x, int y, int r, int c, int remain, String path, boolean[][] visited) {
        if (remain < 0) return;

        if (x == r && y == c && remain == 0) {
            if (answer.equals("impossible") || answer.compareTo(path) > 0) {
                answer = path;
            }
            return;
        }

        String state = x + "," + y + "," + remain;
        if (visitedStates.contains(state)) return;

        visited[x][y] = true;
        visitedStates.add(state);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx > 0 && ny > 0 && nx <= n && ny <= m && !visited[nx][ny]) {
                dfs(n, m, nx, ny, r, c, remain - 1, path + direction[i], visited);
            }
        }

        visited[x][y] = false;
        visitedStates.remove(state);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3, 4, 2, 3, 3, 1, 5));
    }
}


```

해당 코드는 제대로 목적지에 도착했지만 이전에 도착한 경로를 방문 처리하여 테스트가 원하는 정답이 아님

## 두번째 시도
```java
public void dfs(int n, int m, int x, int y, int r, int c, int remain, String path) {
    if (remain < 0) return;

    int distanceToTarget = Math.abs(x - r) + Math.abs(y - c);
    if(distanceToTarget > remain) return;  // Pruning by distance

    if (x == r && y == c && remain == 0) {
        if (answer.equals("impossible") || answer.compareTo(path) > 0) {
            answer = path;
        }
        return;
    }

    String state = x + "," + y + "," + remain;
    if (visitedStates.contains(state)) return;

    visitedStates.add(state);

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx > 0 && ny > 0 && nx <= n && ny <= m) {
            dfs(n, m, nx, ny, r, c, remain - 1, path + direction[i]);
        }
    }

    visitedStates.remove(state);
}

```

가지치기 전략으로 맨해튼 거리를 이용하여 시간을 단축해 보았지만 여전히 시간 초과 발생
