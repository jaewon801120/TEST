package com.edu.test;

import java.util.Arrays;

public class Knumber {
	
	public static void main(String[] args) {
		
		Solution1 sol = new Solution1();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
		sol.solution(array, commands);
		
	}

}

class Solution1 {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        MyUtil.PrintArray(array);
        
        for (int i=0; i<commands.length; i++) {
        	
        	int[] command = commands[i];
        	PrintArray(command, "command" + i + " : ");
        	
        	int first = command[0] - 1;
            int end = command[1] - 1;
            int index = command[2] - 1;
            
            int count = 0;
            int[] ret = new int[end - first + 1];
            for (int j=first; j<=end; j++) {
            	ret[count++] = array[j];
            }
            
            Arrays.sort(ret);
            
            PrintArray(ret, "sort : ");
            
            answer[i] = ret[index];
            
            System.out.println("answer : " + answer[i]);
        }
        
        return answer;
    }
    
    public void PrintArray(int[] array, String message) {

    	System.out.print(message);
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();

	}
}
