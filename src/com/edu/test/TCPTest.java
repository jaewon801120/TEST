package com.edu.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TCPTest {

	public static void main(String[] args) {

		try (ServerSocket serverSocket = new ServerSocket(9876)) {
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("[ " + socket.getInetAddress() + " ] client connected");
				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);
				writer.println(new Date().toString());
				InputStream input = socket.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(input));
				System.out.println("###### msg : " + reader.readLine());
			}
		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

}
