package com.edu.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExamArray {

	public static void main(String[] args) {

		int[] input = { 1, 3, 2, 3, 5, 1 };
		//int[] input = { 1, 3, 2, 4, 2 };
		Solution8 sol = new Solution8();
		sol.solution(input);

	}

}

class Solution8 {
	public int[] solution(int[] answers) {
		int[] answer = {};

		int[] a1 = { 1, 2, 3, 4, 5 };
		int[] a2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] a3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		ArrayList<Integer> answer1 = new ArrayList<Integer>();
		ArrayList<Integer> answer2 = new ArrayList<Integer>();
		ArrayList<Integer> answer3 = new ArrayList<Integer>();

		for (int i = 0; i < answers.length; i++) {
			answer1.add(a1[i % 5]);
			answer2.add(a2[i % 8]);
			answer3.add(a3[i % 10]);
		}

		int nA = 0;
		int nB = 0;
		int nC = 0;
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == answer1.get(i)) {
				nA++;
			}
			if (answers[i] == answer2.get(i)) {
				nB++;
			}
			if (answers[i] == answer3.get(i)) {
				nC++;
			}
		}

		ArrayList<User> ans3 = new ArrayList<User>();
		
		if (nA != 0) {
			User u1 = new User(1, nA);
			ans3.add(u1);
		}
		if (nB != 0) {
			User u2 = new User(2, nB);
			ans3.add(u2);
		}
		if (nC != 0) {
			User u3 = new User(3, nC);
			ans3.add(u3);
		}
		
		MyUtil.PrintArray(ans3);
		
		//Collections.sort(ans3, new OKCompare());
		// compareTo 호출
		Collections.sort(ans3);
		
		MyUtil.PrintArray(ans3);
		
		int nMax = 0;
		for (int i=ans3.size() - 1; i>=0; i--) {
			User u = ans3.get(i);
			if (nMax < u.nOK)
				nMax = u.nOK;
		}
		
		ArrayList<User> ret = new ArrayList<User>();
		for (User u : ans3) {
			if (u.nOK == nMax)
				ret.add(u);
		}
		
		MyUtil.PrintArray(ret);
		
		// comparator 호출
		Collections.sort(ret, new UserCompare());
		
		MyUtil.PrintArray(ret);

		answer = new int[ret.size()];
		for (int i = 0; i < ret.size(); i++) {
			User uN = ret.get(i);
			answer[i] = uN.user;
		}

		MyUtil.PrintArray(answer);

		return answer;
	}

}

class User implements Comparable<User> {

	public int user;
	public int nOK;

	public User(int user, int nOK) {
		this.user = user;
		this.nOK = nOK;
	}

	@Override
	public String toString() {
		return "User [user=" + user + ", nOK=" + nOK + "]";
	}

	@Override
	public int compareTo(User o) {
//		return Integer.compare(nOK, o.nOK);
		if (nOK == o.nOK) {
			return Integer.compare(user, o.user);
		}
		
		return Integer.compare(nOK, o.nOK);
	}

}

class OKCompare implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return Integer.compare(o1.nOK, o2.nOK);
	}
	
}

class UserCompare implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		
		return Integer.compare(o1.user, o2.user);
	}
	
}
