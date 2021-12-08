package com.Solutions.알고기초2.BFS610;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
	이미 1개
	1-1. 클립보드에 복사 : 클립보드 1
	1-2. 클립보드 붙여넣기 X
	1-3. 이모티콘 하나 삭제 : 화면 0
 */
public class Main_14226_이모티콘 {

	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		bfs(S);

		System.out.println(answer);
		sc.close();
	}

	private static void bfs(int s) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[1002][1002]; //화면에 몇개, 클립보드에 몉개에 따라
		q.offer(new int[] {1,0,0});//화면, 클립보드, 초
		visited[1][0] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int screen = cur[0];
			int clip = cur[1];
			int sec = cur[2];
			
			if(screen == s) {
				answer = sec;
				break;
			}
			
			// 클립이 비어있지 않고 총 임티가 1000을 넘지않으면 그리고 한번도 방문 X -> 1
			if(clip != 0 && screen+clip < 1001 && !visited[screen+clip][clip]) {
				q.offer(new int[] {screen+clip, clip, sec+1});
				visited[screen+clip][clip] = true;
			}
			
			// 화면의 임티와 클립보드의 임티 개수가 같지 않고 방문하지 않았으면 -> 2
			if(screen != clip && !visited[screen][screen]) {
				q.offer(new int[] {screen, screen, sec+1});
				visited[screen][screen] = true;
			}
			
			// 화면에 2개 넘게 있을 때 하나 삭제해주기
			if(screen > 2 && !visited[screen-1][clip]) {
				q.offer(new int[] {screen-1, clip, sec+1});
				visited[screen-1][clip] = true;
			}
		}
		
	}

}
