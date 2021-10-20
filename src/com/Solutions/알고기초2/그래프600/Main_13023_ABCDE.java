package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 친구 관계가 4단계가 돼야한다.
public class Main_13023_ABCDE {
	
	static class Node{
		int vertex;
		Node link;
		
		Node(int vertex, Node link){
			this.vertex = vertex;
			this.link = link;
		}
	}

	static int N, M, ans;
	static Node[] adjList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adjList = new Node[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a] = new Node(b, adjList[a]);
			adjList[b] = new Node(a, adjList[b]);
		}
		
		ans = 0;
		for(int i = 0; i < N; i++) 
			dfs(i, 0, new boolean[N]);
		
		System.out.println(ans);
	}

	private static void dfs(int n, int cnt, boolean[] visited) {
		visited[n] = true;
		
		if(cnt == 4) {
			ans = 1;
			return ;
		}
		
		for(Node temp = adjList[n]; temp != null; temp = temp.link) {
			if(!visited[temp.vertex])
				dfs(temp.vertex, cnt+1, visited);
		}
		visited[n] = false;
	}

}

