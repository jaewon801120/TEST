package com.test.tct;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

	public static void main(String[] args) {

		int[] array = { -1, 6, 0, 2, 9, -8 };
		Solution2 sol = new Solution2();
		sol.solution(array);
		//sol.sample(array);

	}

}

class Solution2 {
	
	public int[] sample(int[] numbers) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        Collections.sort(list, Collections.reverseOrder());

        Deque<Integer> deque = new ArrayDeque<>(list);

        while (true) {
            if (deque.isEmpty()) break;
            answer.add(deque.pollFirst());
            if (deque.isEmpty()) break;
            answer.add(deque.pollLast());
        }
        
        MyUtil.PrintArray(answer);

        return answer.stream().mapToInt(x -> x).toArray();
    }
	
	public int[] solution(int[] numbers) {
		int[] answer = {};

		int count = numbers.length;
		if (count == 1)
			return numbers;

		Arrays.sort(numbers);

		answer = new int[count];
		int asc = 0;
		int dsc = count - 1;
		for (int i = 0; i < count; i++) {
			int mod = i % 2;
			if (mod == 0) {
				answer[i] = numbers[dsc--];
			} else {
				answer[i] = numbers[asc++];
			}
		}

		// MyUtil.PrintArray(numbers);
		MyUtil.PrintArray(answer);

		return answer;
	}
}
