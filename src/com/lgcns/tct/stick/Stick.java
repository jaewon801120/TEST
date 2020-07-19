package com.lgcns.tct.stick;

public class Stick {
	
	
	/**
	 * N개의 삼각형을 만들기 위한 막대 개수를 구하는 기능
	 *
     * @param		inputData			int		입력데이터(삼각형 개수)
     * @return							int		막대 개수
	 */
	public int getNumberOfStickForTriangle(int inputData) {
		int numberOfStickForTriangle = 0;
		////////////////////////여기부터 구현 (1) ---------------->
		numberOfStickForTriangle =  3 + ( inputData - 1) * 2;
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return numberOfStickForTriangle;
	}
	
	
	/**
	 * N층의 피라미드를 만들기 위한 막대 개수를 구하는 기능
	 *
     * @param		numberOfLayers			int		입력데이터(피라미드 층수)
     * @return								int		막대 개수
	 */
	public int getNumberOfStickForPyramid(int numberOfLayers) {
		int numberOfStickForPyramid = 0;
		////////////////////////여기부터 구현 (2) ---------------->
		int tNumberOfLayers = numberOfLayers;
		int sum = 0;
		for(;tNumberOfLayers>0;tNumberOfLayers--){
			sum = sum + (3 + (((2*tNumberOfLayers) - 2 ) * 2)); 
		}
		
		int nSum = 0;
		while(numberOfLayers != 1 ) {
			nSum = nSum + (numberOfLayers-1);
			numberOfLayers = numberOfLayers -1;
		}
		
		numberOfStickForPyramid = sum - nSum;
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return numberOfStickForPyramid;
	}
	
}