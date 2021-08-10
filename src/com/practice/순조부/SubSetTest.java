package com.practice.순조부;


public class SubSetTest {

	static int[] input;
	static boolean[] isSelected;
	static int N = 5, S = 21;
	public static void main(String[] args) {
		
		input = new int[] {5,6,10,11,16}; 
		isSelected = new boolean[N];
		
		generateSubSet(0);
	}
	
	private static void generateSubSet(int cnt) { //cnt는 부분집합을 처리하기 위해 '고려된' 수

		if(cnt == N) {
			int sum = 0;
//			System.out.print((isSelected[i]?input[i]:"X")+" ");
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) {
					sum += input[i];
				}
			}
			if(sum > S) { // 특정 조건
				for(int j = 0; j < N; j++) {
					if(isSelected[j]) System.out.print(input[j]+" ");
				}
				System.out.println();
			}
			return;
		}
		
		//현재 원소를 부분집합에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt+1);
		
		//미포함
		isSelected[cnt] = false;
		generateSubSet(cnt+1);
	}

}
