package com.Solutions.DFS_BFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_2331_반복수열 {

	static int P, A, result;
	static ArrayList<Integer> numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		P = sc.nextInt();
		numbers = new ArrayList<>();
		perm(0, A);
		System.out.println(result);
		
		sc.close();
	}
	
	private static void perm(int cnt, int n) {
		if(numbers.contains(n)) {
			result = numbers.subList(0, numbers.indexOf(n)).size();
			return;
		}
		numbers.add(n);
		
		ArrayList<Integer> p = new ArrayList<>();
		while(n > 0) {
			int a = n%10;
			p.add(a);
			n /= 10;
		}
		
		int next = 0;
		for(int i = 0; i < p.size(); i++) {
			next += Math.pow(p.get(i), P);
		}
		
		perm(cnt+1, next);

	}

}
