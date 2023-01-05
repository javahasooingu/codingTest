package kh.kakaouroboros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UroborosSolution {
	
	static Character[] case1 = {'C','K','Z','P'};
	static Character[] case2 = {'A','H','C','Y'};
	static Character[] case3 = {'Q','A','Z','D','E','L'};
	
	static List<Character[]> caseList;
	
	static List<Integer> lengthAnswerList;
	static List<Integer> timeAnswerList;
	
	static final int A_to_Z = 'z' - 'a' + 1;
	
	static int lengthSum;
	static int timeSum;
	
	static {
		caseList = new ArrayList<>();
		
		caseList.add(case1);
		caseList.add(case2);
		caseList.add(case3);
		
		lengthAnswerList = new ArrayList<>();
		timeAnswerList = new ArrayList<>();
	}
	
	public static int answerMe(char startPoint, char endPoint) {
		
		int num = 52;
		
		int answerTime = 0;
		
		for(int idx = startPoint - 'A'; idx != endPoint - 'A'; idx++) {
			
			idx = (idx + num) % 26;
			
			Uroboros.timeList.get(idx);
			
		} // answerMe
		
		return Uroboros.timeList.get(endPoint - 'A');
		
		
		
	}
	
	public static void main(String[] args) {
		
		// 이동하는 길이 구하기
		for (Character[] cases : caseList) {
			
			lengthSum = 0;

			for(int idx = 0; idx < cases.length-1; idx++) {
				
				int x =  Math.abs((cases[idx]) - (cases[idx + 1]));
				
				x = (x <= (A_to_Z/2) ) ? x : (A_to_Z) - x;
				
				lengthSum += x;
				
			} // inner for
			
			lengthAnswerList.add(lengthSum);
			
		} // outer for

		// 경과시간 구하기
		
		
		System.out.println(UroborosSolution.answerMe('A', 'Z'));
		
		
		
		
		System.out.println(lengthAnswerList);
		
	} // main
	
} // end class