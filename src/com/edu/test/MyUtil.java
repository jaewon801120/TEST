package com.edu.test;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {

	public static void PrintArray(int[] array) {

		System.out.print("MyUtil : ");
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();

	}
	
	public static List<Integer> getList(int[] array) {
		
		List<Integer> intList = new ArrayList<Integer>();
		for (int i : array)
		{
		    intList.add(i);
		}
		
//		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
//        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		return intList;
		
	}
}
