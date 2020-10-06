package com.test.tct;

import java.util.*;

public class Test4 {

	public static void main(String[] args) {

		// (x+2, y+1), (x+2, y-1), (x-2, y+1), (x-2, y-1)
		// (x+1, y+2), (x+1, y-2), (x-1, y+2), (x-1, y-2)
		int a = 3;
		int[][] n = { { 1, 2 }, { 2, 1 } }; // a=3, ret=2
		// int[][] n = [[1,3],[1,4],[2,1],[2,2],[3,3],[3,4],[4,1],[4,2]]; // a=4, ret=0
		// int[][] n = [[1,1]]; // a=2, ret=1
		Solution4 sol = new Solution4();
		sol.solution(a, n);

	}

}

class Solution4 {

	public int solution(int n, int[][] blocks) {
        int answer = -1;
        int [] board = new int[n];
        Arrays.fill(board, -1);

        Map<Integer, Set<Integer>> blockMap = new HashMap<>();
        for (int[] b : blocks) {
        	int a = b[0] - 1;
        	int c = b[1] - 1;
            blockMap.computeIfAbsent(a, x -> new HashSet<>()).add(c);
        }

        answer = put(n, board, 0, blockMap);

        return answer;
    }

	public int put(int n, int[] board, int row, Map<Integer, Set<Integer>> blockMap) {
		if (row >= n)
			return 1;

		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (check(n, board, row, i, blockMap)) {
				board[row] = i;
				ans += put(n, board, row + 1, blockMap);
				board[row] = -1;
			}
		}

		return ans;
	}

	public boolean check(int n, int[] board, int row, int col, Map<Integer, Set<Integer>> blockMap) {
		if (Arrays.stream(board).anyMatch(b -> b == col))
			return false;
		if (blockMap.getOrDefault(row, new HashSet<>()).contains(col))
			return false;
		if (row > 1 && (board[row - 2] == col - 1 || board[row - 2] == col + 1))
			return false;
		if (row > 0 && (board[row - 1] == col - 2 || board[row - 1] == col + 2))
			return false;

		return true;
	}

}
