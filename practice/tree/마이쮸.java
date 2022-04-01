package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class 마이쮸 {

	public static void main(String[] args) {
		Queue<int[]> queue = new LinkedList<>();
		// 사람 번호, 마이쮸 개수
		int person = 1; // 사람 번호
		int N = 20; // 마이쮸 개수
		
		queue.offer(new int[] {person, 1});
		while(N > 0) {
			if(!queue.isEmpty()) {
				int[] p = queue.poll();
				int availableCnt = (N>=p[1])?p[1]:N;
				N -= availableCnt;
				
				if(N == 0) {
					System.out.println("마지막 마이쮸 가져간 사람은 "+p[0]);
				}else {
					System.out.println(p[0]+"번이 마이쮸"+availableCnt+"개 가져감");
					p[1]++; // 마이쮸 개수 증가
					queue.offer(p);
					queue.offer(new int[] {++person, 1});
				}
			}
		}
	}

}
