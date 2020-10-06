package com.test.tct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MyUtil {

	public static <T> void PrintArray(ArrayList<T> array) {

		System.out.print("arraylist : ");
		for (int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) + ", ");
		}
		System.out.println();

	}
	
	public static <T> void PrintArray(List<T> array) {

		System.out.print("list : ");
		for (int i=0; i<array.size(); i++) {
			System.out.print(array.get(i) + ", ");
		}
		System.out.println();

	}
	
	public static <T> void PrintArray(Map<String, Integer> map) {

		System.out.print("map : ");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue());
        }
		System.out.println();

	}
	
	public static void PrintArray(int[] array) {

		System.out.print("array : ");
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
	
	public static void mapInteration() {
		 
        Map<String, String> map = new HashMap<String, String>();
        map.put("key01", "value01");
        map.put("key02", "value02");
        map.put("key03", "value03");
        map.put("key04", "value04");
        map.put("key05", "value05");
 
        // 방법 01 : entrySet()
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
        }
        
        // 방법 02 : keySet()
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("[key]:" + key + ", [value]:" + value);
        }
    
        // 방법 03 : entrySet().iterator()
        Iterator<Map.Entry<String, String>> iteratorE = map.entrySet().iterator();
        while (iteratorE.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iteratorE.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("[key]:" + key + ", [value]:" + value);
        }
    
        // 방법 04 : keySet().iterator()
        Iterator<String> iteratorK = map.keySet().iterator();
        while (iteratorK.hasNext()) {
            String key = iteratorK.next();
            String value = map.get(key);
            System.out.println("[key]:" + key + ", [value]:" + value);
        }
    }
}
