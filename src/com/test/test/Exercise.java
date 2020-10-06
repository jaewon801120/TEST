package com.test.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise {

	public static void main(String[] args) {
		
		int[] numbers = { -1, 6, 0, 2, 9, -8 };
		List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
		MyUtil.PrintArray(list);

		List<String> names = Arrays.asList("가나다","라마바","가나다","차카타","파하");
	    //이름 중복 제외.
		names.stream()
			.distinct()
			.forEach(System.out::println);
		System.out.println();
		
	    //"가"로 시작하는 이름만 필터
		names.stream()
			.filter(n->n.startsWith("가"))
			.forEach(System.out::println);
		System.out.println();
		
	    //중복 없애고 "라"로 시작하는 요소만 필터
		names.stream()
			.distinct()
			.filter(n->n.startsWith("라"))
			.forEach(System.out::println);
		
		List<String> input1 = Arrays.asList("java8 lambda","stream mapping");
		input1.stream()
			.flatMap(data -> Arrays.stream(data.split(" ")))
			.forEach(System.out::println);
		
		System.out.println();
		
		List<String> input2 = Arrays.asList("10","20","30","40","50","60");
		input2.stream()
			.flatMapToInt(data -> {
				String[] strArr = data.split(",");
				int[] intArr = new int[strArr.length];
				for(int i =0; i<strArr.length; i++) {
					intArr[i] = Integer.parseInt(strArr[i].trim());
				}
				return Arrays.stream(intArr);
			})
			.boxed()//이걸하고 number 타입을 보면 int/Integer로 바뀜.
			.forEach(number-> System.out.println(number));
		
		List<Student> studentList = Arrays.asList(
				new Student("가나다",10),
				new Student("라마바",20),
				new Student("사아자",30)
			);
			studentList.stream()
				.mapToInt(Student::getScore) //student 객체가 가진 score값으로 스트림 재생성.
				.boxed() //Integer 타입 Stream으로 변환.
				.forEach(score -> System.out.println(score));
			
			//AsDoubleStreamBoxedExample
			int[] intArray= {1,2,3,4,5};
			
			IntStream intStream = Arrays.stream(intArray);
			intStream
				.asDoubleStream()
				.forEach(d -> System.out.println(d));
			
			System.out.println();
			
			intStream = Arrays.stream(intArray);
			intStream
				.boxed() //Integer로 변환.
				//obj는 Integer 타입.
				.forEach(obj -> System.out.println(obj.intValue()));

	}

}

class Student {
	
	private String name = "";
	private Integer score = 0;
	
	public Student(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public Integer getScore() {
		return score;
	}
	
}
