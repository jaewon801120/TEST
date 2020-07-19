package com.edu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static Socket mSocket;

	public static BufferedReader mIn;
	public static PrintWriter mOut;

	public static void main(String[] args) {
		try {
			String ip = "localhost";
			mSocket = new Socket(ip, 9876);
			System.out.println(ip + " 연결됨");

			// 통로 뚫기
			mIn = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
			mOut = new PrintWriter(mSocket.getOutputStream());

			// 메세지 전달
			mOut.println("ABCDFILE.TXT");
			mOut.flush();

			// 응답 출력
			System.out.println(mIn.readLine());

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			// 소켓 닫기 (연결 끊기)
			try {
				mSocket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
