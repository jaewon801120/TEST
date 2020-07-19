package com.edu.test;

public class BadString {

	public static void main(String[] args) {

		String str = "try  a   b";
		Solution7 sol = new Solution7();
		sol.solution(str);

	}

}

class Solution7 {
	public String solution(String s) {
		String answer = "";

		String[] word = s.split(" ", -1);

		for (int i = 0; i < word.length; i++) {
			String temp = word[i];
			String target = "";
			for (int j = 0; j < temp.length(); j++) {
				char ch = temp.charAt(j);
				String str = Character.toString(ch);
				
				if (j % 2 == 0) {
					target += str.toUpperCase();
				} else {
					target += str.toLowerCase();
				}
			}
			
			answer += target;
			if (i != word.length - 1)
				answer += " ";
		}

		System.out.println(answer);

		return answer;
	}
}
