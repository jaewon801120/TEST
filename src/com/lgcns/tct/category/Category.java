package com.lgcns.tct.category;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Category {
	/**
	 * 상위 카테고리를 검색하는 기능
	 *
     * @param		inputData		String[][]		입력데이터(카테고리 정보)
     * @param		categories		List			입력데이터(inputCategories[0]: 카테고리1, inputCategories[1]: 카테고리2)
     * @return						String 			상위 카테고리
	 */
	public String getTopCategory(String[][] inputData, List<String> categories) {
		String topCategory = "";
		////////////////////////여기부터 구현 (1) ---------------->
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		
		for(int i=0;i<inputData.length;i++){
			String parent = inputData[i][0];
			String child = inputData[i][1];
			
			if ( tMap.containsKey(parent) ) {
				List<String> childs = tMap.get(parent);
				childs.add(child);
				
				tMap.put(parent, childs);
			} else {
				List<String> childs = new ArrayList<String>();
				childs.add(child);
				
				tMap.put(parent, childs);
				
			}
		}
		
		List<String> hierarchy = new ArrayList<String>();
		
		int index = -1;
		
		boolean bFirst = false;
		
		for(String inputCategory:categories){
			if ( !bFirst ) {
				for(String key:tMap.keySet()){
					List<String> values = tMap.get(key);
					if ( values.contains(inputCategory) ) {
						hierarchy.add(key);
						
						String parent = getParent(tMap, key);
						while(!parent.isEmpty()){
							hierarchy.add(0, parent);
							parent = getParent(tMap, parent);
						}
						
						break;
					}
				}
				bFirst = true;
			} else {
				for(String key:tMap.keySet()){
					List<String> values = tMap.get(key);
					if ( values.contains(inputCategory) ) {
						List<String> tHierarchy = new ArrayList<String>();
						
						tHierarchy.add(key);
						
						String parent = getParent(tMap, key);
						while(!parent.isEmpty()){
							tHierarchy.add(0, parent);
							parent = getParent(tMap, parent);
						}
						
						for(String tParent:tHierarchy){
							for(int i=0;i<hierarchy.size();i++){
								String oParent = hierarchy.get(i);
								if ( oParent.equals(tParent) ) {
									if ( index < i ) {
										index = i;
									}
									break;
								}
							}
						}
						
						break;
					}
				}
			}
		}
		
		if ( index > -1 ) {
			topCategory = hierarchy.get(index);
		}
		
		///////////////////////////// <-------------- 여기까지 구현 (1)
		return topCategory;
	}
	
	public String getParent(Map<String, List<String>> tMap, String child){
		String parent = "";
		
		for(String key:tMap.keySet()){
			List<String> values = tMap.get(key);
			if ( values.contains(child) ) {
				parent = key;
				break;
			}
		}
		
		return parent;
	}
	
	public List<String> getChlids(Map<String, List<String>> tMap, String parent){
		List<String> childs = new ArrayList<String>();
		
		if ( tMap.containsKey(parent) ) {
			childs = tMap.get(parent);
		}
		
		return childs;
	}
	
	
	/**
	 * 하위 카테고리의 개수를 계산하는 기능
	 *
     * @param		inputData		String[][]		입력데이터(카테고리 정보)
     * @param		categoryStr		String			입력데이터(카테고리)
     * @return						int 			하위 카테고리의 개수
	 */
	public int getNumberOfSubcategories(String[][] inputData, String categoryStr) {
		int numberOfSubcategories = 0;
		////////////////////////여기부터 구현 (2) ---------------->
		Map<String, List<String>> tMap = new LinkedHashMap<String, List<String>>();
		
		for(int i=0;i<inputData.length;i++){
			String parent = inputData[i][0];
			String child = inputData[i][1];
			
			if ( tMap.containsKey(parent) ) {
				List<String> childs = tMap.get(parent);
				childs.add(child);
				
				tMap.put(parent, childs);
			} else {
				List<String> childs = new ArrayList<String>();
				childs.add(child);
				
				tMap.put(parent, childs);
				
			}
		}
		for(String key:tMap.keySet()){
			List<String> values = tMap.get(key);
			if ( values.contains(categoryStr) ) {
				
				String parent = getParent(tMap, categoryStr);
				
				List<String> children = new ArrayList<String>();
				getChildren(tMap, parent, children);

				numberOfSubcategories = children.size();
				
				break;
			}
		}
		///////////////////////////// <-------------- 여기까지 구현 (2)
		return numberOfSubcategories;
	}

	private void getChildren(Map<String, List<String>> tMap, String parent, List<String> children) {
		new ArrayList<String>();
		
		// 상위 카테고리..
		List<String> tChildren = getChlids(tMap, parent);
		if (tChildren.size() >  0 ) {
			children.addAll(tChildren);
			
			for(String tChildParents:tChildren){
				getChildren(tMap, tChildParents, children);
			}
		}
	}
	
}