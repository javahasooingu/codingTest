package programmers.no118670;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {

		int[][] rc = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		String[] operations = {"Rotate", "ShiftRow"};
			
		int[][] anwer = solution(rc, operations);
		 
		Arrays.stream(anwer).forEach((int[] arr)->{
			System.out.println(Arrays.toString(arr));
		});

	} // main


	public static int[][] solution(int[][] rc, String[] operations) {

		ArrayDeque<Integer> leftDeque = new ArrayDeque<>();
		ArrayDeque<ArrayDeque<Integer>> midDeque = new ArrayDeque<>();
		ArrayDeque<Integer> rightDeque = new ArrayDeque<>();

		// 여기는 2차원 배열을 3개의 Deque로 변환
		for(int rowIdx = 0; rowIdx < rc.length; rowIdx++) { // rc배열을 순회하면서 저장. -> O(N) * O(N) Max : 100_000

			midDeque.addLast(new ArrayDeque<>()); // MID에 Deque 추가

			for(int columnIdx = 0; columnIdx < rc[rowIdx].length; columnIdx++) {

				int currentE = rc[rowIdx][columnIdx];

				if (columnIdx == 0) { // 각 배열의 첫 요소는 LEFT

					leftDeque.addLast(currentE);

				} else if (columnIdx == (rc[rowIdx].length -1)) { // 각 배열의 마지막 요소는 RIGHT

					rightDeque.addLast(currentE);

				} else { // 나머지 MID 

					midDeque.peekLast().addLast(currentE);

				} // if-else if-else

			} // inner for

		} // outer for

		// 명령들 수행.
		for (String operation : operations) { // 배열 순회 -> O(N) Max : 100_000

			if (operation.equalsIgnoreCase("ShiftRow")) { // 아마 O(1)??

				leftDeque.addFirst(leftDeque.pollLast()); // O(2)
				rightDeque.addFirst(rightDeque.pollLast()); // O(2)
				midDeque.addFirst(midDeque.pollLast()); // O(2) Max : * 6

			} else { // operation == "Rotate"

				midDeque.peekFirst().addFirst(leftDeque.pollFirst()); // O(3)
				rightDeque.addFirst(midDeque.peekFirst().pollLast()); // O(3) 
				midDeque.peekLast().addLast(rightDeque.pollLast()); // O(3)
				leftDeque.addLast(midDeque.peekLast().pollFirst()); // O(3) Max : * 12

			} // if-else

		} // for

		int[][] answer = new int[rc.length][rc[0].length]; // rc와 같은 사이즈의 배열 생성

		for (int rowIdx = 0; rowIdx < answer.length; rowIdx++) { // 순회 하면서 저장 Max : 100_000
			
			ArrayDeque<Integer> currentMidQ = midDeque.pollFirst(); // O(1)

			for (int columnIdx = 0; columnIdx < answer[rowIdx].length; columnIdx++) {
				
				int currentE;
				
				if (columnIdx == 0) { // 각 배열의 첫 요소는 LEFT 에서

					currentE = leftDeque.pollFirst(); // O(1)
					
				} else if (columnIdx == ( answer[rowIdx].length -1)) { // 각 배열의 마지막 요소는 RIGHT

					currentE = rightDeque.pollFirst();  // O(1)
					
				} else { // 나머지 MID 

					currentE = currentMidQ.pollFirst(); // O(1)

				} // if-else if-else
				
				answer[rowIdx][columnIdx] = currentE;

			} // inner for
			
		} // outer for


		return answer;

	} // solution


} // end class
