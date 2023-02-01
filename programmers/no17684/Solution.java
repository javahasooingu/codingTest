package programmers.no17684;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	// 메세지를 쪼개서 deq에 저장하기
	// 알파벳 + 순번 을 map에 저장하기
	// 정답 리스트를 만들기
	
	// deq에서 하나씩 빼오면서 map과 비교하기
	// - 있으

	static Map<String,Integer> lzw = new HashMap<>();

	public static int[] solution(String msg) {

		ArrayDeque<Character> msgDeque = new ArrayDeque<>();
		ArrayDeque<Integer> answerDeque = new ArrayDeque<>();

		int index = 1;

		for(char c = 'A'; c <= 'Z'; c++){
			lzw.put(""+c,index++);
		}

		for(int idx = 0; idx < msg.length(); idx++) {
			msgDeque.addLast(msg.charAt(idx));
			System.out.println(msgDeque.peekLast());
		}

		while (!msgDeque.isEmpty()) {

			StringBuffer now = new StringBuffer(""+msgDeque.pollFirst());
			
			while (contains(now.toString() + msgDeque.peekFirst())) { // lzw.get(~~) != null 로도 판단이 가능했다...
				now.append(msgDeque.pollFirst());
			}

			answerDeque.addLast(lzw.get(now.toString()));
			if(!msgDeque.isEmpty()) {
				now.append(msgDeque.peekFirst());
				lzw.put(now.toString(),index++);
			}

		}

		int[] answer = new int[answerDeque.size()];

		for(int idx = 0; idx < answer.length; idx++) {
			answer[idx] = answerDeque.pollFirst();
		}

		return answer;

	} // solution

	public static boolean contains(String string) {
		return lzw.get(string) != null ? true : false;
	} // contains

} // end class
