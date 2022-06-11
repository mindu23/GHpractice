package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int start = 0;
        int end = V-1; // 도착점 인덱스
        final int INFINITY = Integer.MAX_VALUE;

        int[][] matrix = new int[V][V];
        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        for(int i = 0; i < V; i++){
            st = new StringTokenizer(br.readLine().trim(), " ");
            for(int j = 0; j < V; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.fill(distance, INFINITY);
        distance[start] = 0;

        int min = 0, current = 0;
        for(int i = 0; i < V; i++){
            // 방문하지 않는 점점들 중 최소 가중치의 정점 선택
            min = INFINITY;
            for(int j = 0; j < V; j++){
                if(!visited[j] && distance[j] < min) {
                    min = distance[j];
                    current = j;
                }
            }

            visited[current] = true; // 선택 정점 방문 처리
            // 선택 정점과 도착점이 같으면 탈출
            if(current == end)
                break;

            // current 정점을 경유지로 하여 갈 수 있는 정점 처리
            for(int j = 0; j < V; j++){
                if(!visited[j] && matrix[current][j] != 0 && distance[j] > min + matrix[current][j]){
                    distance[j] = min + matrix[current][j];
                }
            }
        }
        System.out.println(distance[end]);
    }
}
