package com.ssafy;

public class ball {
	static int ballNum;
	static int ballRect;
	static int ballSpd;
	int x, y;
	
	
	public ball(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public static void main(String[] args) {
		//칠 공
		ball b1 = new ball(177,30);
		//하얀 공
		ball w = new ball(177,60);
		
		//각도 찾기
		double rect = Math.atan2(b1.y-w.y, b1.x-w.x);
		Math.tan(rect);
		System.out.println(rect*(180.0/Math.PI));
	}
	
}
