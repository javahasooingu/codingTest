package programmers.no87390;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	
	/*
	 * 1, 2, 3		1, 2, 3
	 * 4, 5, 6	=	2, 2, 3
	 * 7, 8, 9		3, 3, 3	
	 */
	
	public static int[] solution(int n, long left, long right) {
		
		Deque<Integer> arrDeque = new ArrayDeque<>();

		for(long count = left; count <= right; count++) {
			
			if((count % n + 1) <= (count / n + 1)) {
				
//				arrDeque.addLast((int)count / n + 1);
				arrDeque.addLast((int)(count / n) + 1);
				
			} else {
				
//				arrDeque.addLast((int)count % n + 1);
				arrDeque.addLast((int)(count % n) + 1);
				
			} // if-else
			// 괄호를 꼼꼼하게 사용하자!!
			
//			System.out.printf("%d-",arrDeque.peekLast());
			
		} // for
		
        int[] answer = new int[(int)(right - left + 1)];
        
        for(int idx = 0; idx < answer.length; idx++) {
        	
        	answer[idx] = arrDeque.pollFirst();
        	
        } // for

        return answer;
        
    } // solution

} // end class
