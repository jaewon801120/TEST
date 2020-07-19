package com.lgcns.tct.sequence;

import java.util.ArrayList;
import java.util.List;

public class Sequence {
	
	
	/**
	 * 연속수 목록 검색 기능
	 *
     * @param		inputData		List		입력데이터(숫자열 목록)
     * @return						List		연속수 목록
	 */
	public List<String> getSequenceList(List<String> inputData) {
		List<String> sequenceList = new ArrayList<>();
		////////////////////////여기부터 구현 (1) ---------------->
		for(int i=0; i<inputData.size(); i++) { 
			String str = inputData.get(i);
			int flag =0;
			for(int j=0; j<str.length()-1;j++) {
				if(Integer.parseInt(str.substring(j, j+1))+1 == Integer.parseInt(str.substring(j+1, j+2))) {
					continue;
				} else {
					flag = 1;
					break;
				}
			}
			if(flag ==0) {
				sequenceList.add(str);
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return sequenceList;
	}
	
	/**
	 * 가장 큰 수 생성 기능
	 *
     * @param		sequenceList	List		연속수 목록
     * @return						int			가장 큰 수
	 */
	public int getMaxNum(List<String> sequenceList) {
		int maxNum = 0;
		List<Integer> num =  new ArrayList<Integer>();
		StringBuilder str = new StringBuilder();
		int max =0;
		int min =0;
		////////////////////////여기부터 구현 (2) ---------------->
		
		for(int i=0; i<sequenceList.size(); i++) { 
			num.add( Integer.parseInt(sequenceList.get(i)));
		}
		
		max = num.get(0);
		min = num.get(0);
		for(int i=1; i<num.size(); i++) {
			if(max < num.get(i))
				max = num.get(i);
			if(min > num.get(i))
				min = num.get(i);
		}
		
		String maxStr = String.valueOf(max);
		String minStr = String.valueOf(min);
		int len =0;
		if(maxStr.length() > minStr.length())
			len = minStr.length();
		else if(maxStr.length() <= minStr.length() )
			len = maxStr.length();

		int flag =0 ;
		for(int i=0; i<len; i++) { 
			if(Integer.parseInt(maxStr.substring(i, i+1)) > Integer.parseInt(minStr.substring(i, i+1)) ){
				str.append(maxStr);
				str.append(minStr);
				break;
			} else if(Integer.parseInt(maxStr.substring(i, i+1)) < Integer.parseInt(minStr.substring(i, i+1))) {
				str.append(minStr);
				str.append(maxStr);
				break;
			} else { 
				if(i== len-1) {
					str.append(maxStr);
					str.append(minStr);
				}
					
				continue;
			}
		}
		
		maxNum = Integer.parseInt(str.toString());
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return maxNum;
	}
}