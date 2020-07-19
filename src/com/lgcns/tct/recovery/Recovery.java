package com.lgcns.tct.recovery;

public class Recovery {
	
	
	/**
	 * 데이터 1차 복원 기능
	 *
     * @param		inputData			String		입력데이터(원본 데이터)
     * @param		backup				String		입력데이터(백업 데이터)
     * @return							String		1차 복원된 데이터
	 */
	public String getFirstRecovery(String inputData, String backup) {
		String firstRecovery = "";
		for(int i = 0 ; i < inputData.length(); i++){
			char currentCh = inputData.charAt(i);
			char backupCh = backup.charAt(i);
			
			if(Character.isDigit(currentCh)){
				if(Character.isDigit(backupCh)){
//					currentCh = backupCh;
					firstRecovery += currentCh;
				} else {
					firstRecovery += backupCh;
				}
			} else {
				firstRecovery += currentCh;
			}
		}
		return firstRecovery;
	}
	
	
	/**
	 * 데이터 2차 복원 기능
	 *
     * @param		firstRecovery		String		1차 복원된 데이터
     * @param		netWork				String[]	입력데이터(네트워크에 저장된 데이터)
     * @return							String		2차 복원된 데이터
	 */
	public String getSecondRecovery(String firstRecovery, String[] netWork) {
		String secondRecovery = "";
		String netWorkStr = "";
		for(int i = 0; i < netWork.length; i++){
			netWorkStr += netWork[i].trim();
		}
		secondRecovery = getFirstRecovery(firstRecovery, netWorkStr);
		return secondRecovery;
	}
	
}