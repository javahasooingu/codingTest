package programmers.no118670;

import java.util.ArrayDeque;
import java.util.Arrays;

public class TSolution {

	// 클론 코딩

	public static void main(String[] args) {

		int[][] rc = {{1, 2, 3, 4, 123}, {5, 6, 7, 8, 456}, {9, 10, 11, 12, 789}};
		String[] operations = {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};

		int[][] anwer = solution(rc, operations);

		Arrays.stream(anwer).forEach((int[] arr)->{
			System.out.println(Arrays.toString(arr));
		});
		/*
		 * [1, 6, 7 ,8]
		 * [5, 9, 10, 4]
		 * [2, 3, 12, 11]
		 */

	} // main

	public static int[][] solution(int[][] rc, String[] operations) {
		int[][] answer = new int[rc.length][rc[0].length];

		ArrayDeque<Integer> l = new ArrayDeque<>();
		ArrayDeque<Integer> r = new ArrayDeque<>();
		ArrayDeque<ArrayDeque<Integer>> m = new ArrayDeque<>();

		for (int[] a : rc) { // 배열의 순회는 향상된 for문이 빠르다. 
			ArrayDeque<Integer> x = new ArrayDeque<>();
			for (int j = 0; j < a.length; j++) { // O(N)
				if (j == 0)
					l.add(a[j]); 
				else if (j == a.length - 1) 
					r.add(a[j]);
				else
					x.add(a[j]);
			}
			m.add(x);
		}

		for (String operation : operations) {
			if ("ShiftRow".equals(operation)) {
				l.addFirst(l.pollLast());
				m.addFirst(m.pollLast());
				r.addFirst(r.pollLast());
			}
			else {
				m.peekFirst().addFirst(l.pollFirst());
				r.addFirst(m.peekFirst().pollLast());
				m.peekLast().addLast(r.pollLast());
				l.addLast(m.peekLast().pollFirst());
			}
		}
		
		for (int i = 0; i < rc.length; i++) {
			int j = 0;
			answer[i][j++] = l.pollFirst();
			ArrayDeque<Integer> x = m.pollFirst();
			while (!x.isEmpty()) {
				answer[i][j++] = x.pollFirst();
			}
			answer[i][j] = r.pollFirst(); 
			// if문으로 조건판단없이 한번에 해결.
			
			
		}

		return answer;
	}

} // end class
