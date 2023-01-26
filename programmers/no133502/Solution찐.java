package programmers.no133502;

import java.util.ArrayDeque;

public class Solution찐 {

	public static int solution(int[] ingredient) {

		int answer = 0;

		ArrayDeque<Integer> bugerDeque = new ArrayDeque<>();

		bugerDeque.addLast(0);

		for (int i : ingredient) {

			switch (i) {
			case 2 -> {
				if(bugerDeque.peekLast() == 1) {
					bugerDeque.addLast(i);
				} else if(bugerDeque.peekLast() == 2 || bugerDeque.peekLast() == 3) {
					bugerDeque.clear();

					bugerDeque.addLast(0);
				}

			}// i = 2
			case 3 -> {
				if(bugerDeque.peekLast() == 2) {
					bugerDeque.addLast(i);
				} else if(bugerDeque.peekLast() == 3 || bugerDeque.peekLast() == 1){
					bugerDeque.clear();

					bugerDeque.addLast(0);
				}

			} // i = 3
			default ->{
				if(bugerDeque.peekLast() == 3) {

					bugerDeque.pollLast();
					bugerDeque.pollLast();
					bugerDeque.pollLast();

					answer++;
				} else {
					bugerDeque.addLast(i);
				}

			} // i = 1

			} // switch
		} // for 

		return answer;

	} // solution

} // end class
