package com.edu.test;

public class SpaceN {

	public static void main(String[] args) {
		
		int x = -10000000;
		int n = 1000;
		
		Solution3 sol = new Solution3();
		sol.solution(x, n);
		
	}

}

class Solution3 {
    public long[] solution(int x, int n) {
    	
        long[] answer = new long[n];
        
        for (int i=1; i<n+1; i++) {
        	answer[i-1] = (long)x * i;
        }
        
        System.out.print("MyUtil : ");
		for (int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + ", ");
		}
		System.out.println();
        
        return answer;
        
    }
}
