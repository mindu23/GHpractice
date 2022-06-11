package study;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    private char[] nodes;
    private final int SIZE;
    private int lastIndex; // 마지막에 추가된 노드의 인덱스

    public CompleteBinaryTree(int size) {
        this.SIZE = size;
        nodes = new char[size+1];

    }

    public void add(char c){
        if(lastIndex == SIZE) return;
        nodes[++lastIndex] = c;
    }

    public void bfs(){
        // 탐색을 기다리는 노드들이 저장됨
        // 배열로 관리하므로 탐색할 노드를 관리하는 인덱스 저장
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 루트 노드의 인덱스

        int cur = 0;
        while(!q.isEmpty()){
            cur = q.poll();
            System.out.println(nodes[cur]);
            // 왼쪽 자식
            if(cur*2 <= lastIndex) q.offer(cur*2);
            // 오른쪽 자식
            if(cur*2+1 <= lastIndex) q.offer(cur*2+1);

        }
    }

    public void bfsv2(){
        // 탐색을 기다리는 노드들이 저장됨
        // 배열로 관리하므로 탐색할 노드를 관리하는 인덱스 저장
        Queue<Integer> q = new LinkedList<>();
        q.offer(1); // 루트 노드의 인덱스

        int cur = 0, level = 0, size = 0;
        while(!q.isEmpty()){
            size = q.size();

            System.out.print("level "+level+" :");
            while(--size >= 0){
                cur = q.poll();
                System.out.print(nodes[cur]+" ");
                // 왼쪽 자식
                if(cur*2 <= lastIndex) q.offer(cur*2);
                // 오른쪽 자식
                if(cur*2+1 <= lastIndex) q.offer(cur*2+1);
            }
            System.out.println();
            level++;
        }
    }
}
