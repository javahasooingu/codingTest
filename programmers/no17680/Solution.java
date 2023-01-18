package programmers.no17680;

import java.util.ArrayDeque;

class Solution {
	
	// 내가 만든 코드~
	// 불필요한 코드 엄청 많지~
	
	public static void main(String[] args) {
	
	int cacheSize = 5;
	String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
	
	System.out.println(Solution.solution(cacheSize, cities)); // 52

	} // main
	
	static final int HIT = 1;
	static final int MISS = 5;
	
    public static int solution(int cacheSize, String[] cities) {
    	
    	ArrayDeque<String> citiesDeque = new ArrayDeque<>(); 
    	// 굳이 Deque에 넣을 이유가 없었다
    	
    	ArrayDeque<String> cachesDeque = new ArrayDeque<>();
    	
    	int answer = 0;
    	
    	for(String city : cities) {
    		citiesDeque.addLast(city.toUpperCase());
    	} // for
    	
    	while (!citiesDeque.isEmpty()) {
    		
    		boolean isHit = false;
    		
    		String city = citiesDeque.pollFirst();
    		
    		int size = cachesDeque.size();
    		
    		// Deque.contains(object) 라는 메서드를 알았더라면~
    		for (int count = 0; count < size; count++) {
    			
    			String cache = cachesDeque.pollFirst();
    			
    			if(cache.equals(city)) {
    				isHit = true;
    			} else {
					cachesDeque.addLast(cache);
				} // if-else
    			
    		} // for 
    		
    		if (isHit) {
    			answer += HIT;
			} else {
				answer += MISS;
			} // if-else
    		
    		if (cacheSize <= cachesDeque.size()) {
				cachesDeque.pollFirst();
			} // if
    		
    		cachesDeque.addLast(city);
    		
    	} // while
    	
    	
        return answer;
        
    } // solution
    
} // end class
