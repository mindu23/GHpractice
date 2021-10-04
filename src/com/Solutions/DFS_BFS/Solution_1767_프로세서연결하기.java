package com.Solutions.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기 {

	public static class Pos{
		int r, c;
		
		Pos(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	static int N, min, max; // min은 wire max는 core
	static int[][] map;
	static ArrayList<Pos> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			list = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					//가에 있지 않은 코어를 list에 저장한다.
					if(i == 0 || i == N-1 || j == 0 || j == N-1 || map[i][j] == 0) continue;
					list.add(new Pos(i, j));
				}
			}
			
			min =N*N;
			max = 0;
			//코어 list에 있는 것들을 하나씩 순서대로 접근하면서 4방 중 하나 선택 -> 다음 -> 하나 선택 -> 다음을 반복한다.
			//dfs (접근할 코어의 인덱스, 연결 가능한 코어 개수, 연결한 선의 개수)
			dfs(0,0,0);
			System.out.println("#"+t+" "+ min);
		}
	}
	private static void dfs(int index, int cCnt, int wCnt) {
		
		if(index == list.size()) {
			if(cCnt > max) {
				max = cCnt;
				min = wCnt;
			}else if(cCnt == max) {
				min = Math.min(min, wCnt);
			}
			return ;
		}
		
		//방문한 코어
		Pos cur = list.get(index);
		for(int d = 0; d < dr.length; d++) {
			//연결 된다면
			if(isConnect(cur.r, cur.c, d)){
				dfs(index+1, cCnt+1, wCnt + setWire(cur.r, cur.c, d, 2));
				//다시 전선 회수
				setWire(cur.r, cur.c, d, 0);
			}
		}
		//연결을 안해보자
		dfs(index+1, cCnt, wCnt);
		
	}
	private static int setWire(int r, int c, int d, int set) {
		int nr = r;
		int nc = c;
		int cnt = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
			map[nr][nc] = set;
			cnt++;
		}
		return cnt;
	}
	private static boolean isConnect(int r, int c, int d) {
		
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) break;
			if(map[nr][nc] != 0) return false;
		}
		return true;
	}
}
