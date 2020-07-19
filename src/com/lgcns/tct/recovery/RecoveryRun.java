package com.lgcns.tct.recovery;



public class RecoveryRun {

	public static String backup;
	public static String[] netWork;
	
    public static void main(String[] args) {    	
		// 제공 데이터 세트2를 실행하려면 loadData에서 제공 데이터 세트1을 주석 처리하고 제공 데이터 세트2를 주석 해제하여 실행
    	String inputData = loadData();
    	Recovery recovery = new Recovery();
    	
    	// 데이터 1차 복원 기능
    	String firstRecovery = recovery.getFirstRecovery(inputData, backup);
    	printFirstRecovery(inputData, firstRecovery);
    	
    	// 데이터 2차 복원 기능
    	String secondRecovery = recovery.getSecondRecovery(firstRecovery, netWork);
    	printSecondRecovery(firstRecovery, secondRecovery);
    }

    private static String loadData() {
    	
    	
		//////////////////////////////////
		// 제공 데이터 세트 1
		/////////////////////////////////
    	
//    	String inputData = "we1re3hewo34ddre67com21rue";
//    	backup = "1eare4hewor5dd8eamcome3rue";
//    	netWork = new String[]{
//    			"wear",
//    			"ethe",
//    			"worl",
//    			"ddre",
//    			"amco",
//    			"metr",
//    			"ue  "
//    	};
    	
		//////////////////////////////////
		// 제공 데이터 세트 2
		/////////////////////////////////    	
    	
    	String inputData = "ote12lkja23dhbgfl1ejkhf3uhe";
    	backup = "otek3lkjaopdhbgfl1ejkhf1uhe";
    	netWork = new String[]{
    			"otek",
    			"plkj",
    			"aopd",
    			"hbgf",
    			"lkej",
    			"khft",
    			"uhe "
    	};
    	
    	return inputData;
	}    
    
    private static void printFirstRecovery(String inputData, String firstRecovery) {   
    	System.out.println("[1차 복원된 데이터] ");
    	System.out.println("입력: "+inputData);
    	System.out.print("출력: ");
    	if(firstRecovery == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(firstRecovery);
    	}
    	printLine();    	
    } 
    
    private static void printSecondRecovery(String firstRecovery, String secondRecovery) {   
    	System.out.println("[2차 복원된 데이터] ");
    	System.out.print("입력: ");
    	if(firstRecovery == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(firstRecovery);
    	}
    	System.out.print("출력: ");
    	if(secondRecovery == ""){
    		System.out.println("결과값이 없습니다.");
    	}else{    		
    		System.out.println(secondRecovery);
    	}
    	printLine();      	
    } 

	private static void printLine(){
		System.out.println("--------------------------------------------------------------------");
	}  
}

