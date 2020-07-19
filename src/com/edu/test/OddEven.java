package com.edu.test;

public class OddEven {

	public static void main(String[] args) {
		
		int n = 1000;
		
		Solution4 sol = new Solution4();
		sol.solution(n);
		
	}

}

class Solution4 {
    public String solution(int num) {
        String answer = "";
        
        if (num % 2 == 0)
        	answer = "Even";
        else
        	answer = "Odd";
        
        return answer;
    }
}
