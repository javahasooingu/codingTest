package hackerrank.algorithms.implementation.betweentwosets;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

class Result2 {

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		
		TreeSet<Integer> aSet = new TreeSet<>(a);						// a List의 요소를 TreeSet으로 오름차순으로 정렬하고
		Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);		// aArr의 배열에 저장
																		// 더 간단하게! -> Collections.sort(a); -> List a를 오름차순 정렬
		
		TreeSet<Integer> bSet = new TreeSet<>(b);						// b List의 요소를 TreeSet으로 오름차순으로 정렬하고
		Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);		// bArr의 배열에 저장
																		// 더 간단하게! -> Collections.sort(b); 

		int answer = 0;

		loof:	// 답이 될 가능성이 있는 수의 범위를 순회하면서 조건 체크
				// a요소의 최댓값 <=			num			<= b요소의 최솟값 -> b요소들의 공약수의 최댓값
				// ㄴ->a요소들의 공배수의 최솟값 != 최소 공약수
			for(int num =aArr[aArr.length - 1] ; num <= bArr[0] ; num++){
				
				for(int aNum : aArr){	// a요소들의 공통배수인지
					
					if(num % aNum != 0){
						
						continue loof;	// a의 배수가 아니면 정답ㄴ
					} // if
					
				} // inner for
				
				for(int bNum : bArr){	// b요소들의 공통약수인지
					
					if(bNum % num != 0){
						
						continue loof;	// b의 약수가 아니면 정답ㄴ
					} // if
					
				} // inner for
				
				answer++; // a요소들의 공통배수 && b요소들의 공통약수 -> 답 인정
			} // outer for(loof)
		
		return answer;
	} // getTotalX
}



public class Solution2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int total = Result2.getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}