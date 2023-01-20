package programmers.no42586;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

	// 시간복잡도

	public static void main(String[] args) {

		int[] progresses =	{93, 30, 55, 20, 12, 21, 29, 67, 1, 15, 98, 90, 77, 27, 10, 11, 14};
		int[] speeds =		{11, 10, 52, 99, 21, 22, 55, 32, 1, 11, 12, 21, 11, 11, 90, 11, 14};

		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));
		
//		long s = System.currentTimeMillis();
		
		int[] answer = Solution.solution(progresses, speeds);
		
//		long e = System.currentTimeMillis();
		
//		System.out.printf("for Test : %fs\n",(e-s) / 1000.0);
		System.out.println(Arrays.toString(answer));

	} // main

	public static int[] solution(int[] progresses, int[] speeds) {

		ArrayDeque<Integer> progressesDeque = new ArrayDeque<>();
		ArrayDeque<Integer> speedsDeque = new ArrayDeque<>();

		List<Integer> answerList = new ArrayList<>();

		// array 를 Deque화
		for (int idx = 0; idx < progresses.length; idx++) { //O(N) * 2

			progressesDeque.addLast(progresses[idx]);
			speedsDeque.addLast(speeds[idx]);

		} // for

		int finishedCount = 0; // answer[]의 크기가 될것이다.

		while (!progressesDeque.isEmpty()) {  // O(1)

			if(progressesDeque.peekFirst() >= 100) { // O(1)

				answerList.add(0);

				// 굳이 한번더 확인 하는 이유는 반복하면서 알아보라고!
				// 이러면 O(N^2)이긴 한데 일단 거름망이 있으니 괜찮겠지 라는 생각...?
				while (!progressesDeque.isEmpty() && progressesDeque.peekFirst() >= 100) { // O(2)

					answerList.set(finishedCount, answerList.get(finishedCount) + 1);
					
					progressesDeque.pollFirst(); 
					speedsDeque.pollFirst(); //O(2)

				} // while

				finishedCount++;

			} // if


			for(int count = 0; count < progressesDeque.size(); count++) { 

				int progress = progressesDeque.pollFirst(); 
				int speed = speedsDeque.pollFirst(); // O(2)

				progressesDeque.addLast(progress + speed);
				speedsDeque.addLast(speed); //O(2)

			} // for
			
//			for(int E : progressesDeque) { // O(1)
//				
//				int speed = speedsDeque.pollFirst(); // O(1)
//				
//				progressesDeque.addLast(E + speed);
//				speedsDeque.addLast(speed); // O(2)
//				
//			} // enhanced for 
			// 이게 더 빠르게 동작할 듯 싶다...
			// test결과 : 이건 불가능 이 로직에선ㅋㅋ
			// enhanced for 경우 forEach와 마찬가지로 반복문 안에서 크기를 변경하면 안됨!
			// 아예 사용하면 안되는 놈이었다... 
			
		} // while

		int[] answer = new int[answerList.size()]; // finishedCount 를 넣어도 된다.

		for(int idx = 0; idx < answer.length; idx++) {

			answer[idx] = answerList.get(idx);

		} // for

		return answer;
	} // solution

} // end class
