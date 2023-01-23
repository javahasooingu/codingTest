package programmers.no152995;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Solution {

	public static int solution(int[][] scores) {

		ArrayDeque<Integer[]> scoresDeque = new ArrayDeque<>();
		
		int[] wh = scores[0];

		for(int idx = 1; idx < scores.length; idx++){ // O(n) Max : 100_000

			Integer[] currentScore = {scores[idx][0],scores[idx][1]};

			scoresDeque.addLast(currentScore);

		} // for
        
		for(int[] compareE : scores) { // O(n) Max : 100_000

			if(wh[0] < compareE[0] && wh[1] < compareE[1]){

				return -1;

			} // if

		} // for 

		List<Integer> rankList = new ArrayList<>();

		whileL:
		while(!scoresDeque.isEmpty()) { // O(n*n) Max : 100_000*100_000 // 여기서 시간을 단축해야함...

			Integer[] currentE = scoresDeque.pollFirst(); 
            
			for(int[] compareE : scores) { // -> 이조건을 필터링해야함... 
				
				if(currentE[0] < compareE[0] && currentE[1] < compareE[1]){

					continue whileL;

				} // if

			} // for

			rankList.add(currentE[0] + currentE[1]);

		} // while

		Collections.sort(rankList);

		int whScore = wh[0] + wh[1];
		int answer = 1;

		for(int idx = (rankList.size() - 1); idx >= 0; idx--){ // O(n) Max : 100_000

			if(rankList.get(idx) <= whScore){
				break;
			} // if 

			answer++;

		} // for

		return answer;

	} // solution

} // end class
