package com.ws;

public class Solution_타겟넘버 {

	public static void main(String[] args) {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		int ans = solution(numbers, target);
		
		System.out.println(ans);
	}

	static int answer = 0;
    private static int solution(int[] numbers, int target) {
        // 고려 숫자 횟수, 고려한 값, 배열, 목표 값
        dfs(0,0,numbers,target);
        
        return answer;
    }

	private static void dfs(int start, int res, int[] numbers, int target) {
		
		if(start == numbers.length && res == target) {
			answer++;
		}
		
		if(start == numbers.length) return;
		
		for(int i = start; i < numbers.length; i++) {
			// 덧셈
			dfs(i+1, res+numbers[i], numbers, target);
			// 뺄셈
			dfs(i+1, res-numbers[i], numbers, target);
			return ;
		}
		
	}
}
