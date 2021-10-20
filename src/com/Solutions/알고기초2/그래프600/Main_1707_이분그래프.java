package com.Solutions.알고기초2.그래프600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	static StringBuilder sb = new StringBuilder();
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
			
			bfs();
		}

	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[V+1];
		
		q.offer(new int[] {1,1});
		visited[1] = true;
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int c = cur[0];
			int color = cur[1];
			
			for(Node temp = adjList[c]; temp != null; temp = temp.link) {
				
			}
		}
	}


}
