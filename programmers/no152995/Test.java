package programmers.no152995;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] scores = new int[100][2];

		for(int[] i : scores) {
			for(int j = 0; j < 2; j++) {
				i[j] = (int)(Math.random()*100);
			}
		}
		
		int answer = Solution.solution(scores);
		
		System.out.printf("답 : %d%n",answer);
		
		System.out.println("===================================");
		
		int setTest = Solution2.solution(scores);
		
		System.out.printf("test : %d",setTest);
		
	} // main

} // end class
