package com.Solutions;

import java.util.Arrays;

public class DisjointSetTest {

	static int N;
	static int[] parents;
	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		parents[a] = find(parents[a]);
		return parents[a];
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) {
		N = 5;
		make();
		System.out.println(union(0,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(2,1));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(3,2));
		System.out.println(Arrays.toString(parents));
		System.out.println(union(4,3));
		System.out.println(Arrays.toString(parents));
		

	}

}
