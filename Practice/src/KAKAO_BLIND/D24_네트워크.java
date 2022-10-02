package KAKAO_BLIND;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

public class D24_네트워크 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        Assertions.assertEquals(1, solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    private static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 아직 방문하지 않았다면 dfs
                visited = dfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private static boolean[] dfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (visited[i] || start == i || computers[start][i] == 0) continue;
            visited = dfs(i, computers, visited);
        }
        return visited;
    }
}
