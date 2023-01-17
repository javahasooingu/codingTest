package programmers.no42586;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	
	// 시간복잡도
	// 

	public static void main(String[] args) {

		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));

		int[] answer = Solution.solution(progresses, speeds);

		System.out.println(Arrays.toString(answer));

	} // main

	public static int[] solution(int[] progresses, int[] speeds) {

		ArrayDeque<Integer> progressesDeque = new ArrayDeque<>();
		ArrayDeque<Integer> speedsDeque = new ArrayDeque<>();

		List<Integer> answerList = new ArrayList<>();

		// array 를 Deque화
		for (int idx = 0; idx < progresses.length; idx++) {

			progressesDeque.addLast(progresses[idx]);
			speedsDeque.addLast(speeds[idx]);

		} // for
		
		int finishedCount = 0;

		while (!progressesDeque.isEmpty()) {

			if(progressesDeque.peekFirst() >= 100) {
				
				answerList.add(0);

				while (!progressesDeque.isEmpty() && progressesDeque.peekFirst() >= 100) { 
					answerList.set(finishedCount, answerList.get(finishedCount) + 1);
					progressesDeque.pollFirst();
					speedsDeque.pollFirst();
				} // while
				
				finishedCount++;
				
			} // if


			for(int count = 0; count < progressesDeque.size(); count++) {

				int progress = progressesDeque.pollFirst();
				int speed = speedsDeque.pollFirst();

				progressesDeque.addLast(progress + speed);
				speedsDeque.addLast(speed);

			} // for

		} // while



		int[] answer = new int[answerList.size()];

		for(int idx = 0; idx < answer.length; idx++) {

			answer[idx] = answerList.get(idx);

		} // for

		return answer;
	} // solution
	
} // end class
