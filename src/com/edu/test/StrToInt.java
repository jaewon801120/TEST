package com.edu.test;

public class StrToInt {

	public static void main(String[] args) {
		
		String input = "-1234";
		Solution2 sol = new Solution2();
		sol.solution(input);
		
	}

}

class Solution2 {
    
	public int solution(String s) {
		
        int answer = 0;
        
        if (s.length() == 0 || s.length() > 5)
        	return 0;
        
        if (s.charAt(0) == '0')
        	return 0;

        String temp = s;
		boolean bMinus = false;
		char first = s.charAt(0);
		if (first == '-' || first == '+') {
			if (first == '-')
				bMinus = true;
			
			temp = s.substring(1);
		}
        
        for (char ch : temp.toCharArray()) {
        	if (ch < 48 || ch > 57)
        		return 0;
        }

        for (int i=0; i<temp.length(); i++) {
        	char ch = temp.charAt(i);
        	int digit = (int)(Math.pow(10, (double)temp.length() - i - 1)) * (ch - '0');
        	answer += digit;
        }
        
        if (bMinus)
            answer = -1 * answer;
        
        System.out.println(answer);
        
        return answer;
        
    }
    
}
