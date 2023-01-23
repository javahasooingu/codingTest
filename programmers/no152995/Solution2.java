package programmers.no152995;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solution2 {
	

	public static int solution(int[][] scores) {

		ArrayDeque<Integer[]> scoresDeque = new ArrayDeque<>();
		
		int[] wh = scores[0];
		int whScore = wh[0] + wh[1];

		for(int idx = 1; idx < scores.length; idx++){ // O(n) Max : 100_000

			Integer[] currentScore = {scores[idx][0],scores[idx][1]};

			if(whScore < currentScore[0] + currentScore[1]){ // 요 조건만 추가해도 통과함... -> 총 횟수를 줄임
                
				scoresDeque.addLast(currentScore);
	                
	            } // if
			
		} // for
		
		for(int[] compareE : scores) { // O(n) Max : 100_000

			if(wh[0] < compareE[0] && wh[1] < compareE[1]){

				return -1;

			} // if

		} // for 

		List<Integer> rankList = new ArrayList<>();

		whileL:
		while(!scoresDeque.isEmpty()) { // O(n)

			Integer[] currentE = scoresDeque.pollFirst(); 
            
			for(int[] compareE : scores) {
				
				if(currentE[0] < compareE[0] && currentE[1] < compareE[1]){

					continue whileL;

				} // if

			} // for

			rankList.add(currentE[0] + currentE[1]);

		} // while

		Collections.sort(rankList);

		int rank = 1;

		for(int idx = (rankList.size() - 1); idx >= 0; idx--){ // O(n) Max : 100_000

			if(rankList.get(idx) <= whScore){
				
				break;
				
			} // if 

			rank++;

		} // for

		return rank;

	} // solution

} // end class
