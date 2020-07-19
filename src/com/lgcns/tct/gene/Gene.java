package com.lgcns.tct.gene;

public class Gene {
	/**
	 * 단순비교 방식의 유사도 측정 기능
	 * 
     * @param		inputData			String		입력데이터(유전자 문자열)
     * @return							int			유사도
	 */
	public int measureSimpleComparison(String inputData){
		int similarity = 0;
		//////////////////////여기부터 구현 (1) ---------------->
		String[] genom = inputData.split(",");
		int size = genom[0].length() + genom[1].length();

		String tmpStr2 = getGenom(genom[1],size, size-genom[1].length());
		String str1 =null;
		String str2 = null;
		for(int i=0; i< genom[1].length()+1; i++) {
			int count =0;
			str1 = getGenom(genom[0],size, i);
			for(int j=0; j< size; j++) {
				if(str1.charAt(j) != '-' && str1.charAt(j) == tmpStr2.charAt(j)){
					count++;
				}
			}
			if(count > similarity)
				similarity = count;
		}
		
		String tmpStr1 = str1;
		
		for(int i=0; i< genom[0].length()+1; i++) {
			int count =0;
			str2 = getGenom(genom[1],size,genom[0].length()-i);
			for(int j=0; j< size; j++) {
				if(str2.charAt(j) != '-' && str2.charAt(j) == tmpStr1.charAt(j)){
					count++;
				}
			}
			if(count > similarity)
				similarity = count;
		}
		

		

		///////////////////////////// <-------------- 여기까지 구현 (1)
		return similarity;
	}
	
	public static String getGenom(String str, int size, int start) {
		StringBuilder tmp = new StringBuilder();
		
		for(int i=0; i<start; i++) {
			tmp.append("-");
		}
		tmp.append(str);
		for(int i=start+str.length(); i<size; i++) {
			tmp.append("-");
		}
		return tmp.toString();
	}
	
	/**
	 * 행렬비교 방식의 유사도 측정 기능
	 * 
     * @param		inputData				String		입력데이터(유전자 문자열)
     * @param		similarityMatrix		int[][]		입력데이터(유사도 측정 행렬)
     * @return								int			가장 큰 유사도
	 */
	public int measureSortComparison(String inputData, int[][] similarityMatrix){
		int maxSimilarity = 0;
		//////////////////////여기부터 구현 (2) ---------------->
		String[] genom = inputData.split(",");
		int size = genom[0].length() + genom[1].length();

		String tmpStr2 = getGenom(genom[1],size, size-genom[1].length());
		String str1 =null;
		String str2 = null;
		for(int i=0; i< genom[1].length()+1; i++) {
			int count =0;
			str1 = getGenom(genom[0],size, i);
			for(int j=0; j< size; j++) {
				if(str1.charAt(j) == '-' && tmpStr2.charAt(j) == '-'){
					continue;
				} else {
					int x= getNum(str1.charAt(j));
					int y = getNum(tmpStr2.charAt(j));
					count += similarityMatrix[x][y];
				}
			}
			if(count > maxSimilarity)
				maxSimilarity = count;
		}
		
		String tmpStr1 = str1;
		
		for(int i=0; i< genom[0].length()+1; i++) {
			int count =0;
			str2 = getGenom(genom[1],size,genom[0].length()-i);
			for(int j=0; j< size; j++) {
				if(str2.charAt(j) == '-' && tmpStr1.charAt(j) == '-'){
					continue;
				} else {
					int x= getNum(str2.charAt(j));
					int y = getNum(tmpStr1.charAt(j));
					count += similarityMatrix[x][y];
				}
			}
			if(count > maxSimilarity)
				maxSimilarity = count;
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return maxSimilarity;
	}
	
	public static int getNum(char ch) { 
		if(ch == 'A')
			return 0;
		else if(ch == 'C')
			return 1;
		else if(ch == 'G')
			return 2;
		else if(ch == 'T')
			return 3;
		else 
			return 4;
	}
	
}
