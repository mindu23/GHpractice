package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
	
	static class Node {
		int vertex;
		Node link;
		
		Node(int vertex, Node link){
			this.vertex = vertex;
			this.link = link;
		}
	}
	
	static int V, E;
	static Node[] adjList;
	static int[] visited;
	static String ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		
		for(int k = 1; k <= K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjList = new Node[V+1];
			
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				adjList[u] = new Node(v, adjList[u]);
				adjList[v] = new Node(u, adjList[v]);
			}
			
			visited = new int[V+1];
			ans = "YES";
			for(int i = 1; i <= V; i++) {
				if(visited[i] == 0) {
					if(!bfs(i)) break ;
				}
			}
			System.out.println(ans);
			
		}

	}
	
	private static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = visited[start]==0?1:visited[start];
		q.offer(start);

		while(!q.isEmpty()) {
			int cur = q.poll();
			int color = visited[cur];
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
				if(visited[temp.vertex]==color) {
					ans = "NO";
					return false;
				}
				if(visited[temp.vertex] == 0){
					visited[temp.vertex] = color==1?2:1;
					q.offer(temp.vertex);
				}
			}
		}
		return true;
	}


}
