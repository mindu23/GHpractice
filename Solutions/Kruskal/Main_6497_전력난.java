package com.Solutions.Kruskal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
	가로등 일부를 소등하여 돈을 절약하자
	가로등을 켜 두면 길의 미터 수만큼 돈이 들어간다.
	도시에 있는 모든 두 집 쌍에 대해, 불이 켜진 길만 왕래할 수 있다.
	=> 모든 집을 거치는 최소 신장 트리
	전체 - 절약된 = 절약할 수 있는 최대 액수
	
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0
 */
public class Main_6497_전력난 {
	
	public static class Edge implements Comparable<Edge>{
		int x, y, z;
		
		Edge(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.z, o.z);
		}
	}

	static int m, n, total, min;
	static Edge[] edgeList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		while(true) {
			total = 0;
			min = 0;
			edgeList = new Edge[n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				total += z;
				
				edgeList[i] = new Edge(x, y, z);
			}

			Arrays.sort(edgeList);
			
			make();
			
			int cnt = 0;
			for(Edge e : edgeList) {
				if(union(e.x, e.y)) {
					min += e.z;
					cnt++;
					if(cnt == m-1) break;
				}
			}
//			System.out.println(total+" "+min);
			System.out.println(total - min);
			
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			if(m == 0 && n == 0)
				break;
			
		}
	}
	
	static int[] parents;
	private static void make() {
		parents = new int[m];
		for(int i = 0; i < m; i++) {
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
