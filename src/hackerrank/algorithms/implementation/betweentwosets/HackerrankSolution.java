package hackerrank.algorithms.implementation.betweentwosets;

import java.util.List;
import java.util.TreeSet;


public class HackerrankSolution{

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		TreeSet<Integer> aSet = new TreeSet<>(a);
		Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);

		TreeSet<Integer> bSet = new TreeSet<>(b);
		Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);

		int answer = 0;

		loop:
			for(int i = aArr[aArr.length - 1] ; i <= bArr[0] ; i++){
				for(int aNum : aArr){
					if(i % aNum != 0){
						continue loop;
					} // if
				} // for
				for(int bNum : bArr){
					if(bNum % i != 0){
						continue loop;
					} // if
				} // for
				answer++;
			} // for
		return answer;
	} // getTotalX
}