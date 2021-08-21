package com.practice.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private final int SIZE;
	private int lastIndex; // 마지막에 추가된 노드의 인덱스
	
	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[SIZE+1]; // 인덱스는 1번부터
	}
	
	public void add(char c) {
		if(lastIndex == SIZE) return ; // 꽉 찬 상황
		nodes[++lastIndex] = c;
	}
	
	public void bfs() { // 탐색을 기다리는 노드들이 저장된다.
		// 배열로 관리하므로 탐색할 노드를 관리하는 인덱스를 저장
		Queue<Integer> queue = new LinkedList<>(); // 배열의 인덱스를 관리한다.
		queue.offer(1); // root 저장
		
		int current = 0;
		while(!queue.isEmpty()) { // 비어있지 않을 때
			current = queue.poll(); // 탐색할 노드
			System.out.println(nodes[current]);
			// 왼쪽 자식이 있는지 체크
			if(current*2 <= lastIndex)
				queue.offer(current*2); // 인덱스를 넣어주자
			// 오른쪽 자식이 있는지 체크
			if(current*2 + 1 <= lastIndex)
				queue.offer(current*2+1);
		}
	}
	
	public void bfs2() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1); // 인덱스는 1부터
		
		int current = 0, level = 0, size = 0;
		while(!queue.isEmpty()) {
			size = queue.size();
			System.out.print("level" + level+" : ");
			while(--size >= 0) { //size만큼 반복돌기
				current = queue.poll();
				System.out.print(nodes[current]+" ");
				
				if(current*2 <= lastIndex)
					queue.offer(current*2);
				if(current*2+1 <= lastIndex)
					queue.offer(current*2+1);
			}
			level++;
			System.out.println();
		}
	}
	
	public void dfsByPreOrder() {
		System.out.print("Preorder : ");
		dfsByPreOrder(1);
	}
	
	private void dfsByPreOrder(int current) { // 현재 탐색할 노드 current
		
		// 현재 노드 처리 -> 왼쪽  -> 오른쪽
		System.out.print(nodes[current]+" ");
		if(current*2 <= lastIndex) dfsByPreOrder(current*2);
		if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
	}
	
	
	

}
