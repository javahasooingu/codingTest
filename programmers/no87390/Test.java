package programmers.no87390;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		
		int n = 4;
		long left = 7;
		long right = 14;
		
		int[] answer = Solution.solution(n, left, right);
		
		System.out.println();
		
		System.out.println(Arrays.toString(answer));
		
	} // main

} // end class
