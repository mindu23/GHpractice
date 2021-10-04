package com.Solutions.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	왕국은 N개의 행성
	효율적인 행성 지배를 위해 행성을 연결하는 터널
	터널 가중치는 A(x1,y1,z1)와 B(x2,y2,z2) 터널 연결시
	= min(|x1 - x2|, |y1 - y2|, |z1- z2|);
	터널 총 N-1개 연결하는 최소 비용 구하기
	=> MST
 */
public class Main_2887_행성터널 {
	
	public static class Edge implements Comparable<Edge>{
		int start, end, weight;
		
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int N;
	static int[][] planet;
	static Edge[] edgeList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		edgeList = new Edge[N*2];
		planet = new int[N][3];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			planet[i][0] = Integer.parseInt(st.nextToken());
			planet[i][1] = Integer.parseInt(st.nextToken());
			planet[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int k = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				//가중치
				int w = Math.min(Math.min(Math.abs(planet[i][0]-planet[j][0]), Math.abs(planet[i][1]-planet[j][1])), Math.abs(planet[i][2]-planet[j][2]));
				edgeList[k++] = new Edge(i, j, w);
			}
		}
		
		make();
		Arrays.sort(edgeList);
		
		int result = 0, cnt = 0;
		for(Edge e : edgeList) {
			if(union(e.start, e.end)) {
				result += e.weight;
				cnt++;
				if(cnt == N-1) break;
			}
		}
		
		System.out.println(result);
	}
	
	static int[] parents;
	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
