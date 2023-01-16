package programmers.no42586;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
	
	public static void main(String[] args) {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(progresses));
		System.out.println(Arrays.toString(speeds));

		int[] answer = Solution.solution(progresses, speeds);
		
		System.out.println(Arrays.toString(answer));

	} // main
	
    public static int[] solution(int[] progresses, int[] speeds) {
        
    	ArrayDeque<Integer> progressesDeque = new ArrayDeque<>();
    	ArrayDeque<Integer> speedsDeque = new ArrayDeque<>();
    	
    	ArrayDeque<Integer> answerDeque = new ArrayDeque<>();
    	
    	List<Integer> answerList = new ArrayList<>();
    	
    	// array 를 Deque화
    	for (int idx = 0; idx < progresses.length; idx++) {
			
    		progressesDeque.addLast(progresses[idx]);
    		speedsDeque.addLast(speeds[idx]);
    		
		} // for
    	
    	while (!progressesDeque.isEmpty()) {
    		
    		if(progressesDeque.peekFirst() >= 100) {
    			answerDeque.;
    			progressesDeque.pollFirst();
    			speedsDeque.pollFirst();
    			continue;
    		} // if
    		
    		if(count100 != 0) {
    			answerList.add(count100);
    			count100 = 0;
    		} // if
    		
    		for(int count = 0; count < progressesDeque.size(); count++) {
    			
    			int progress = progressesDeque.pollFirst();
    			int speed = speedsDeque.pollFirst();
    			
    			progressesDeque.addLast(progress + speed);
    			speedsDeque.addLast(speed);
    			
    		} // for
    		
    	} // while
    	
    	
    	
    	int[] answer = new int[answerList.size()];
    	
    	for(int idx = 0; idx < answer.length; idx++) {
    		
    		answer[idx] = answerList.get(idx);
    		
    	} // for
    	
        return answer;
    }
}
