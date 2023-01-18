package programmers.no17680;

import java.util.ArrayDeque;

class TSolution {

	public static void main(String[] args) {

		int cacheSize = 5;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

		System.out.println(Solution.solution(cacheSize, cities)); // 52

	} // main

	public static final int HIT = 1;
	public static final int MISS = 5; // hit 와 miss 값 상수화 

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;

		ArrayDeque<String> cacheDeque = new ArrayDeque<>();
		
		
		for(String city : cities) { // 배열을 순회 -> O(배열크기) Max : 100_000

			city = city.toUpperCase(); // city는 대소문자 구분 X -> O(글자수 * 배열크기) Max : 20 * 100_000
			
			// HIT
			if(cacheDeque.contains(city)) { // cache에 city가 존재하니? -> 순회 -> O(캐시크기) Max : 30 * 20 * 100_000 

				answer += HIT;
				cacheDeque.remove(city); // O(N)
				cacheDeque.addLast(city); // LRU 에 의해 가장 나중으로 , O(1)

			// MISS
			} else { // cache에 없다면

				answer += MISS; 
				
				// cacheSize 초과 방지
				if(cacheDeque.size() > cacheSize) {
					
					cacheDeque.pollFirst(); // O(1)
					
				} // if
				
				cacheDeque.addLast(city); // O(1)
				
			} // if-else (HIT or MISS)

		} // for (cities array 순회)

		return answer;
		
	} // solution



} // end class
