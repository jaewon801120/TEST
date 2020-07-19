package com.edu.test;

public class HandPhone {

	public static void main(String[] args) {
		
		String str = "1234567890";
		Solution6 sol = new Solution6();
		sol.solution(str);

	}

}

class Solution6 {
    public String solution(String phone_number) {
        String answer = "";
        
        char[] ch = phone_number.toCharArray();
        for (int i=0; i<ch.length - 4; i++) {
        	ch[i] = '*';
        }
        
        answer = String.valueOf(ch);
        
        System.out.println(answer);
        
        return answer;
    }
}
