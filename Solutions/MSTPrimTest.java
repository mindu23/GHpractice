package com.Solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {
/*
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0
 */
	static int N;
	static boolean[] visited;
	static int[] minEdge;
	static int[][] adjMatrix;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		// 타 정점에서 자신으로의 최소 간선 비용
		minEdge = new int[N];
		adjMatrix = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			// 큰 값으로 초기화
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0;
		
		for(int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			for(int j = 0; j < N; j++) {
				// 방문하지 않았고 minEdge가 작은 값을 찾는다.
				if(!visited[j] && min > minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			// 다음 방문해야 할 곳 찾음
			// 방문 처리
			visited[minVertex] = true;
			// 간선 비용 누적
			result += min;
			// 방금 추가된 정점의 minEdge 갱신하기
			for(int j = 0; j < N; j++) {
				if(!visited[j]&& adjMatrix[minVertex][j] != 0 && minEdge[j]>adjMatrix[minVertex][j])
					minEdge[j] = adjMatrix[minVertex][j];
			}
		}
		System.out.println(result);
	}
}
