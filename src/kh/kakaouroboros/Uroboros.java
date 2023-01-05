package kh.kakaouroboros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Uroboros {
	
	static Map<Character, Integer> timeMap;
	static Map<Character, Integer> reverseTimeMap;
	
	static List<Integer> timeList;
	static Integer[] timeArray;
	
	static {
		timeMap = new TreeMap<>();
		reverseTimeMap = new TreeMap<>();
		
		timeList = new ArrayList<>();
		timeArray = new Integer[52];
		
		for(int count = 0; count < 26; count++) {
			
			char Alphabet = 'A';
			char alphabet = 'a';
			
			timeMap.put((char)(Alphabet + count), count + 1);
			reverseTimeMap.put((char)(Alphabet + count), 26 - (count));
			
			timeList.add(count + 1);
			timeArray[count] = count + 1;
			timeArray[count + 26] = 26 - count;
			
		} // for
		
	} // static initializer
	
	
	
	public static void main(String[] args) {
		System.out.println(timeMap);
		System.out.println(reverseTimeMap);
		System.out.println(timeList);
		System.out.println(Arrays.toString(timeArray));
	}

} // end class

