package programmers.no12909;

import java.util.ArrayDeque;


public class Solution {

	boolean solution(String s) {

		boolean answer = true;

		// 일단 홀수인경우 거르고 가자
		if(s.length() % 2 == 1){ return false;}

		// stack처럼 쓸 예정 last들만 사용
		ArrayDeque<Character> charDeque = new ArrayDeque<>();

		for(int idx = 0; idx < s.length(); idx++) {

			char now = s.charAt(idx);

			if(now == '(') {

				charDeque.add(now);

			} else {
				
				if(charDeque.isEmpty()) {

					return false;

				} else {

//					if(charDeque.peekLast() == '(') {
						
						charDeque.pollLast();
						
//					} // if
					
				} // if-else 
				
			} // if else 

		} // for
		
		return (charDeque.isEmpty()) ? true : false;
		
	} // solution
	
} // end class