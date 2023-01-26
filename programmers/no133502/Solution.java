package programmers.no133502;

class Solution {

	public static int solution(int[] ingredient) {

		StringBuffer sb = new StringBuffer();
		String[] splited = {"null"};

		for(int i : ingredient) {
			sb.append(i);
		} // for

		int answer = 0;

		while(true)	{

			splited = sb.toString().split("1231");

			if(splited.length == 1) {

				if (splited[0].equals(sb.toString())) {
					break;
				} 

				answer++;
				
			} else {
				answer += splited.length - 1;
			}

			sb = new StringBuffer();

			for(String str : splited) {
				sb.append(str);
			}

		}

		return answer;

	} // solution

} // end class