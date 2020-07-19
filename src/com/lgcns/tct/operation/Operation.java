package com.lgcns.tct.operation;

import java.util.ArrayList;
import java.util.List;

public class Operation {
	/**
	 * 문자열 분리 기능
	 * 
     * @param		inputData			String		입력데이터(문자열)
     * @return							List		[0]: 문자로 구성된 문자열, [1]: 숫자로 구성된 문자열
	 */
	public List<String> getStrList(String inputData){
		List<String> strList = new ArrayList<String>();
		StringBuilder str = new StringBuilder();
		StringBuilder num = new StringBuilder();
		//////////////////////여기부터 구현 (1) ---------------->
		for(int i=0; i< inputData.length(); i++) {
			if (isStringDouble(inputData.substring(i, i+1))){
				num.append(inputData.substring(i, i+1));
			} else {
				str.append(inputData.substring(i, i+1));
			}
		}
		strList.add(str.toString());
		strList.add(num.toString());
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return strList;
	}
	
	/**
	 * 새로운 문자열을 생성하는 기능
	 * 
     * @param		strList			List		[0]: 문자로 구성된 문자열, [1]: 숫자로 구성된 문자열
     * @return						String		새로운 문자열
	 */
	public String getNewStr(List<String> strList){
		String newStr = "";
		StringBuilder tmp = new StringBuilder();
		String str = strList.get(0);
		String num = strList.get(1);
		
		//////////////////////여기부터 구현 (2) ---------------->
		for(int i=0; i<num.length(); i++) { 
			tmp.append(str.substring(i,i+1));
			tmp.append(num.substring(i,i+1));
		}
		tmp.append(str.substring(num.length(),num.length()+1));
		
		newStr = tmp.toString();
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return newStr;
	}
	
	  public static boolean isStringDouble(String s) {
		  try {
			  Double.parseDouble(s);
		      return true;
		  } catch (NumberFormatException e) {
		      return false;
		  }
	 }
}
