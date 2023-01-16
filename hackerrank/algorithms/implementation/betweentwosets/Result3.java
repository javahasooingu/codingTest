package hackerrank.algorithms.implementation.betweentwosets;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Result3 {

	static int X;
	static boolean isX;

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		/*
		TreeSet<Integer> aSet = new TreeSet<>(a);
		Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);		

		TreeSet<Integer> bSet = new TreeSet<>(b);						
		Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);	
		 */

		// 굳이 정렬할 필요 없다. 정렬 없이 최소값 최댓값 뽑아내기.
		int aMax = Collections.max(a);
		int bMin = Collections.min(b);

		int answer = 0;

		for(X = aMax ; X <= bMin ; X++){

			// for문 대신 forEath 와 lambda사용
			{/*
				for(int aNum : a){	
					if(X % aNum != 0){
						continue loop;
					} // if

				} // inner for

				for(int bNum : b){	
					if(bNum % X != 0){
						continue loop;
					} // if

				} // inner for
			 */}

			a.forEach(Result3::isX);

			if(!isX) { continue; }
			
			b.forEach(Result3::isX);
			
			if(!isX) { continue; }
			
			answer++; 
		} // outer for(loop)

		return answer;
	} // getTotalX

	public static void isX(int num) {

		if(num <= X) {
			if(X % num == 0) {isX = true;} // if
		}else {
			if(num % X == 0) {isX = true;} // if
		} // if-else
		
	} // isX
	
} // end class