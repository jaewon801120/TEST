package com.edu.test;

public class Gap {

	public static void main(String[] args) {
		
		int a = 3;
		int b = 3;
		
		Solution5 sol = new Solution5();
		sol.solution(a, b);

	}

}

class Solution5 {
    public long solution(int a, int b) {
        long answer = 0;
        
        int temp = 0;
        if (max(a, b) == a) {
        	temp = b;
        	b = a;
        	a = temp;
        }
        
        for (int i=a; i<=b; i++) {
        	answer += i;
        }
        
        //return (b - a + 1) * (a + b) / 2;
        
        System.out.println(answer);
        
        return answer;
    }
    
    private int max(int a, int b) {
    	return a > b ? a : b;
    }
}
