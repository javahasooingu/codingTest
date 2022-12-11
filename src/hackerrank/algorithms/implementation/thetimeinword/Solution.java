package hackerrank.algorithms.implementation.thetimeinword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		int h = Integer.parseInt(bufferedReader.readLine().trim());

		int m = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.timeInWords(h, m);

		bufferedWriter.write(result);
		bufferedWriter.flush();
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	} // main

} // Solution


class Result {

	// Key => 숫자
	// Value => 단어 로 이뤄진 맵생성
	static Map<Integer,String> timeInWordMap = new HashMap<Integer,String>();

	static{
		Result.timeInWordMap.put(0,"o' clock");
		Result.timeInWordMap.put(1,"one");
		Result.timeInWordMap.put(2,"two");
		Result.timeInWordMap.put(3,"three");
		Result.timeInWordMap.put(4,"four");
		Result.timeInWordMap.put(5,"five");
		Result.timeInWordMap.put(6,"six");
		Result.timeInWordMap.put(7,"seven");
		Result.timeInWordMap.put(8,"eight");
		Result.timeInWordMap.put(9,"nine");
		Result.timeInWordMap.put(10,"ten");
		Result.timeInWordMap.put(11,"eleven");
		Result.timeInWordMap.put(12,"twelve");
		Result.timeInWordMap.put(13,"thirteen");
		Result.timeInWordMap.put(14,"fourteen");
		Result.timeInWordMap.put(15,"quarter");
		Result.timeInWordMap.put(16,"sixteen");
		Result.timeInWordMap.put(17,"seventeen");
		Result.timeInWordMap.put(18,"eighteen");
		Result.timeInWordMap.put(19,"nineteen");
		Result.timeInWordMap.put(20,"twenty");
		Result.timeInWordMap.put(30,"half");
	} // static initializer

	public static String timeInWords(int h, int m) {
		String hour = ""; 						// 시간을 담을 그릇
		String minute = "";						// 분을 담을 그릇
		String toOrPast = "past ";				// 1~30 -> to / 31~59 -> past
		String minuteUnit = " minutes ";		// 1 -> minute / 나머지들

		// toOrPast, minuteUnit 은 선언과 동시에 초기화
		// 아래에서 로직에 의해 바꿔줄 예정
		
		// toOrPast setting
		if(30 < m && m <60){                                                
			m = 60 - m;
			h = h%12 + 1;
			toOrPast = "to ";
		} // if
		// 30을 기준으로 지나온 시간 / 향해가는 시간으로 나뉨
		
		// timeWord setting
		hour = Result.timeInWordMap.get(h);			// 시간단위 셋팅

		if(20 < m && m < 30){
			minute = Result.timeInWordMap.get(20) + " " + Result.timeInWordMap.get(m - 20);

		} else{
			minute = Result.timeInWordMap.get(m);

		} // if-else								// 분단위 셋팅

		// minuteUnit setting and return
		if(m == 0){
			return hour + " " + minute;

		} // if										// 0분

		if(m == 1){
			minuteUnit = " minute ";

		} else if(m == 15 || m == 30){
			minuteUnit = " ";

		} // if-else if 							// 1분은 단수형
													// 15,30분은 분단위 생략

		return minute + minuteUnit + toOrPast + hour;
		//		 분		  분단위	 to/past	시간
	} // timeInWords

} // result
