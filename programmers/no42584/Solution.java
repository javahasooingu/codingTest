package programmers.no42584;

import java.util.*;


// 이중for문으로 O(n^2)으로 풀이가 가능하지만 stack으로 O(n)만에 풀어보기;
// 백준.no17298과 유하사게 풀어보고
// class를 만들어 index값과 price를 저장
class Price{
	int price;
	int idx;

	public Price(int price, int idx) {
		this.price = price;
		this.idx = idx;
	} // default constructor
} // end class

public class Solution {

	public int[] solution(int[] prices) {

		// Stack처럼 활용 예정 -> addLast, pollLast, peekLast만 가능;
		ArrayDeque<Price> priceDeque = new ArrayDeque<>();

		int[] answer = new int[prices.length];

		for(int idx = prices.length - 1; idx >= 0; idx--) { // O(N) + a MAX : 100_000

			Price now = new Price(prices[idx], idx);

			if(priceDeque.isEmpty() || priceDeque.peekLast().price < now.price) {

			}else {

				while (!priceDeque.isEmpty() && priceDeque.peekLast().price >= now.price) {

					priceDeque.pollLast();
				} // while

			} // if-else

			answer[idx] = priceDeque.isEmpty() ? ((prices.length - 1) - idx) : (priceDeque.peekLast().idx - idx);
			
			priceDeque.addLast(now);

		} // for

		return answer;

	} // solution

} // end class
