package com.lgcns.tct.sum;

import java.util.Arrays;

public class Sum {
	
	
	/**
	 * 배열을 정렬하는 기능
	 *
     * @param		inputData		int[][]		입력데이터(이차원배열)
     * @return						int[][]		정렬된 배열
	 */
	public int[][] getSortedArray(int[][] inputData) {
		int[][] sortedArray = null;
		int size = inputData.length;
		sortedArray = new int[size][size];
		////////////////////////여기부터 구현 (1) ---------------->
		for(int i=0; i< size; i++) { 
			for(int j=0; j<size; j++) {
				sortedArray[i][j] = inputData[i][j]%10;
			}
		}
		
		for(int i=0;i<size; i++) {
		 	Arrays.sort(sortedArray[i]);
		}
		
		for(int i=0; i<size; i++) {
			int[] num = new int[size];
			for(int j=0;j<size; j++) {
				num[j] = sortedArray[j][i];
			}
			Arrays.sort(num);
			for(int j=0; j<size; j++) {
				sortedArray[j][i] = num[j];
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return sortedArray;
	}
	
	/**
	 * 배열합을 계산하는 기능
	 *
     * @param		sortedArray		int[][]		정렬된 배열
     * @return						int			배열합
	 */
	public int getArrSum(int[][] sortedArray) {
		int arrSum = 0;
		int size = sortedArray.length;
		int [][] temp = new int[size][size];
		for(int i=0; i<size; i++) {
			System.arraycopy( sortedArray[i], 0, temp[i], 0, size );
		}
		
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		////////////////////////여기부터 구현 (2) ---------------->
		for(int i=0; i< size; i++) {
			for(int j=0; j<size; j++) { 
				if(i != size-1 && j != size-1) {
					if(temp[i][j] == temp[i][j+1]) {
						sortedArray[i][j] =0;
						sortedArray[i][j+1] =0;
					}
					if(temp[i][j] == temp[i+1][j]) {
						sortedArray[i][j] =0;
						sortedArray[i+1][j] =0;
					}
				} else if (i == size-1 && j != size-1) {
					if(temp[i][j] == temp[i][j+1]) {
						sortedArray[i][j] =0;
						sortedArray[i][j+1] =0;
					}
				} else if(i != size-1 && j == size-1) {
					if(temp[i][j] == temp[i+1][j]) {
						sortedArray[i][j] =0;
						sortedArray[i+1][j] =0;
					}
				}
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				arrSum += sortedArray[i][j];
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return arrSum;
	}
	
}