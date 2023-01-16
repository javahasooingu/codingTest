package hackerrank.algorithms.implementation.thetimeinword;

import java.util.HashMap;
import java.util.Map;


public class Result2 {

	public static String timeInWords(int h, int m) {
		String hour = ""; 						
		String minute = "";						
		String toOrPast = "past ";				
		String minuteUnit = " minutes ";		

		if(30 < m && m <60){                                                
			m = 60 - m;
			h = h%12 + 1;
			toOrPast = "to ";
		} // if

		hour = Result.timeInWordMap.get(h);			

		if(20 < m && m < 30){
			minute = Result.timeInWordMap.get(20) + " " + Result.timeInWordMap.get(m - 20);

		} else{
			minute = Result.timeInWordMap.get(m);

		} // if-else								

		// minuteUnit setting and return
		if(m == 0){
			return hour + " " + minute;

		} // if										

		if(m == 1){
			minuteUnit = " minute ";

		} else if(m == 15 || m == 30){
			minuteUnit = " ";

		} // if-else if 						

//		return minute + minuteUnit + toOrPast + hour;

		StringBuffer resultString = new StringBuffer();

		resultString.append(minute).append(minuteUnit).append(hour);

		return resultString.toString();

		// StingBuffer Class 이용

	} // timeInWords

} // result






