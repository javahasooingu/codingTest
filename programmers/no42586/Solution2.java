package programmers.no42586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution2 {

	// 시간복잡도

	public static void main(String[] args) {

		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));

		int[] answer = Solution.solution(progresses, speeds);

		System.out.println(Arrays.toString(answer));
		// {2, 1}

	} // main

	public static int[] solution(int[] progresses, int[] speeds) { // 최대 100 * 100 번 순회

		List<Integer> progressesList = new ArrayList<>();
		List<Integer> speedsList = new ArrayList<>();

		List<Integer> answerList = new ArrayList<>(); // 답의 정확한 수를 알 수 없어서 일단 list생성.

		int answerCount = 0;

		for(int idx = 0; idx < progresses.length; idx++) { // O(n) MAX : 100 * 2;

			progressesList.add(progresses[idx]);
			speedsList.add(speeds[idx]);

		} // for

		while (!progressesList.isEmpty()) { // O(n(n+1))

			if(progressesList.get(0) >= 100) {

				answerCount++;

				progressesList.remove(0);
				speedsList.remove(0);

				continue;

			} else {

				if(answerCount != 0) {
					answerList.add(answerCount);
				}

				for (int idx = 0; idx < progressesList.size(); idx++) {

					progressesList.set(idx, progressesList.get(idx)+speedsList.get(idx));

				} // for

			} // if-else

		} // while


		int[] answer = new int[answerList.size()];

		for(int idx = 0; idx < answer.length; idx++) {

			answer[idx] = answerList.get(idx);

		} // for

		return answer;

	} // solution

} // end class
