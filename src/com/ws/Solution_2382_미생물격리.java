package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
	N*N의 구역
	K개의 미생물
	미생물이 구역을 벗어나는 걸 방기하기 위해 가장자리에는 약품이 칠해져 있다.
	R, C, cnt(미생물 개수), dir(상하좌우)
	1시간마다 이동방향의 다음 셀로 이동
	약품이 칠해진 셀에 도착하면 cnt/2고 이동 방향이 반대로 바뀐다.
	cnt가 홀수인 경우 소수점 버림
	두개의 군집이 한 셀에 모이면 군집은 합쳐짐. 이동 방향은 미생물 수가 많이 남은 곳과 동일하게 된다.
	M 시간동안 격리후 남아있는 미생물의 총합을 구해라
	
 */

public class Solution_2382_미생물격리 {

	static int[] dr = {0,-1,1,0,0};
	static int[] dc = {0,0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<int[]> pq = new PriorityQueue<>();
			for(int k = 0; k < K; k++) {
				int[] arr = new int[4];
				st = new StringTokenizer(br.readLine());
				arr[0] = k;
				for(int i = 1; i < 4; i++) {
					arr[i] = Integer.parseInt(st.nextToken()); // r c cnt dir
				}
				pq.offer(arr);
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			
			
		}
	}

}
