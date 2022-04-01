package com.Solutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MSTKruskalTest {

/*
5 10
0 1 5
0 2 10
0 3 8
0 4 7
1 2 5
1 3 3
1 4 6
2 3 1
2 4 3
3 4 1	
 */
	
	public static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		// 가중치 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int V, E;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		// 간선 리스트 작성
		edgeList = new Edge[E];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}
		
		// 가중치 오름차순 정렬하기
		Arrays.sort(edgeList);
		
		// 서로소 집합
		// 모든 정점을 집합으로 만들기
		make();
		// 간선 하나씩 시도하며 트리 만들기
		int result = 0, cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.start, e.end)) {
				// union 성공
				result += e.weight;
				//신장트리 완성
				if(cnt == V-1) break; 
			}else {
				// 이미 같은 집합
			}
		}
		System.out.println(result);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}

	static int[] parents;
	private static void make() {
		parents = new int[V];
		for(int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

}
