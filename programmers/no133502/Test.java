package programmers.no133502;

public class Test {

	public static void main(String[] args) {

		int[] ingredient = {2,2,3,3,3,1,1,2,1,1,2,3,1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 2, 3, 1, 2, 3, 1, 2, 1, 2, 1, 2, 2, 3, 1};
		
		 int answer = Solution.solution(ingredient);
		 
		 System.out.println(answer);
		 
		 int answer2 = Solution2.solution(ingredient);
		 
		 System.out.println(answer2);
		 
		

	} // main

} // end class
