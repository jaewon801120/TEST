package com.edu.test;

import java.io.FileInputStream;
import java.util.*;

public class BFSDistance {

	static int N = 0; // 행
	static int M = 0; // 열
	//static int[][] arr;
	static int[][] arr = {{1,1,1,1,1,1}, {1,0,1,0,1,0}, {1,0,1,0,1,1}, {1,1,1,0,1,1}};
	static boolean[][] visited;

	public static void main(String[] args) {

		try {

//			Scanner sc = new Scanner(System.in);
//			Scanner sc = new Scanner(new FileInputStream("C:\\Users\\vmpo\\Desktop\\bfs.txt"));

//			N = sc.nextInt();
//			M = sc.nextInt();
//			sc.nextLine();
			N = 4;
			M = 6;

			//arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				//String str = sc.nextLine();
				for (int j = 0; j < M; j++) {
					//arr[i][j] = str.charAt(j) - '0';
					visited[i][j] = false;
				}
			}

			visited[0][0] = true;
			BFS(0, 0);

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

	static void BFS(int start, int end) {

		try {

			Queue<Node> q = new LinkedList<>();
			// 최초 queue 삽입
			q.add(new Node(start, end, 1));

			while (!q.isEmpty()) {

				Node node = q.poll();
				visited[node.x][node.y] = true;
				System.out.println(node.x + "," + node.y);
				// 상하좌우 이동 가능여부를 확인해본다.

				// 좌
				if (node.y - 1 >= 0 && node.y - 1 < M && arr[node.x][node.y - 1] == 1
						&& visited[node.x][node.y - 1] == false) {
					q.add(new Node(node.x, node.y - 1, node.depth + 1));
				}

				// 우
				if (node.y + 1 >= 0 && node.y + 1 < M && arr[node.x][node.y + 1] == 1
						&& visited[node.x][node.y + 1] == false) {
					q.add(new Node(node.x, node.y + 1, node.depth + 1));
				}

				// 위
				if (node.x - 1 >= 0 && node.x - 1 < N && arr[node.x - 1][node.y] == 1
						&& visited[node.x - 1][node.y] == false) {
					q.add(new Node(node.x - 1, node.y, node.depth + 1));
				}

				// 아래
				if (node.x + 1 >= 0 && node.x + 1 < N && arr[node.x + 1][node.y] == 1
						&& visited[node.x + 1][node.y] == false) {
					q.add(new Node(node.x + 1, node.y, node.depth + 1));
				}

				if (visited[N - 1][M - 1]) {
					System.out.println("완료");
					System.out.println(node.depth);
					break;
				}

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}

class Node {
	int x;
	int y;
	int depth;

	Node(int _x, int _y, int _depth) {
		this.x = _x;
		this.y = _y;
		this.depth = _depth;
	}
}
