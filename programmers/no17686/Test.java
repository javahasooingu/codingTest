package programmers.no17686;

import java.util.Arrays;

public class Test {
	
	public static void main(String[] args) {
		
//		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		
		String[] answer = Solution.solution(files);
		
		System.out.println(Arrays.toString(answer));
		
	} // main
	
} // end class
