package com.edu.test;

import java.util.Stack;

// https://bumbums.tistory.com/1?category=728916
public class DFS2 {

	public static void main(String[] args) {

		DFSAlgorithm d = new DFSAlgorithm();
		d.inputData(1, 2);
		d.inputData(1, 3);
		d.inputData(2, 3);
		d.inputData(2, 5);
		d.inputData(3, 4);
		d.inputData(3, 5);
		d.inputData(4, 5);

		//d.DFS(1);
		d.DFS(1, 5);

	}

}

class DFSAlgorithm {
	private int maps[][] = new int[6][6]; // DFS 인접행렬
	private boolean visit[] = new boolean[6]; // 방문했나 안했나 판단할 변수
	Stack<Integer> stack;

	public DFSAlgorithm() {
		// 클래스 생성자
		// 스택을 초기화하고
		// table 및 visit 변수를 할당 한다.
		stack = new Stack();

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				maps[i][j] = 0;
			}
		}

		for (int i = 0; i < 6; i++) {
			visit[i] = false;
		}
	}

	public void inputData(int i, int j) {
		// 데이터를 집어넣는 함수
		// i,j를 넣으면 인접행렬에 값을 넣어준다.
		// 무방향 그래프이므로 대칭해서 넣어준다.
		maps[i][j] = 1;
		maps[j][i] = 1;

	}

	public void DFS(int v) {
		// DFS 구현 부분
		visit[v] = true;
		System.out.print(v); // 방문노드를 보여주기위한 출력
		for (int i = 0; i < 6; i++) {
			if (maps[v][i] == 1 && !visit[i]) {
				// 노드가 이어져있고 방문을 하지 않았으면
				DFS(i);
			}
		}
	}

	public void DFS(int v, int goal) {
		// DFS 구현 부분
		visit[v] = true;
		stack.push(v); // 스택에 값을 넣어준다.

		if (v == goal) { // 목표노드에 왔으면

			//// 스택값 출력
			int count = stack.size(); // 스택의 크기를 받을 변수
			for (int i = 0; i < count; i++) {
				System.out.print(stack.elementAt(i) + " ");
			}
			System.out.println("출력완료");
			//// 스택값 출력

			stack.pop(); // DFS에서 빠져나올땐 pop을 합니다.
			return;
		}

		for (int i = 0; i < 6; i++) {
			if (maps[v][i] == 1 && !visit[i]) {
				// 노드가 이어져있고 방문을 하지 않았으면
				DFS(i, goal);
				visit[i] = false; // DFS에서 빠져나오면 해당노드는 방문하지 않은 것으로 한다.
			}
		}

		stack.pop(); // DFS에서 빠져나올땐 pop을 합니다.

	}

}
