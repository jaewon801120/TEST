package com.test.tct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		String str = "cplusplus";
		Solution1 sol = new Solution1();
		//sol.solution(str);
		sol.sample(str);

	}

}

class Solution1 {
	
	public String sample(String line) {
        String answer = "";

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String l : line.split("")) {
            map.put(l, map.getOrDefault(l, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue() == o2.getValue() ? o1.getKey().compareTo(o2.getKey()) : o2.getValue().compareTo(o1.getValue()));

        answer = list.get(0).getKey();

        return answer;
    }
	
    public String solution(String line) {
        String answer = "";
        
        Map<String, Integer> mapNum = new LinkedHashMap<String, Integer>();
        for (int i=0; i<line.length(); i++) {
        	char ch = line.charAt(i);
        	String str = Character.toString(ch);
        	
        	Integer sum = 0;
        	if (mapNum.containsKey(str)) {
        		sum = mapNum.get(str);
        	}
        	
        	sum++;
        	
        	mapNum.put(str, sum);
        }
        
        List<String> list = new ArrayList<String>();
        Integer max = 0;
        for(String key : mapNum.keySet()){
        	Integer n = mapNum.get(key);
        	if (n > max) {
        		max = n;
        	}
        }
        
        for(String key : mapNum.keySet()){
        	Integer n = mapNum.get(key);
        	if (n == max) {
        		list.add(key);
        	}
        }
        
        Collections.sort(list);
        
        answer = list.get(0);
        
        MyUtil.PrintArray(mapNum);
        
        MyUtil.PrintArray(list);
        
        return answer;
    }
}
