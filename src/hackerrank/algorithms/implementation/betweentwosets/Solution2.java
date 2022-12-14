package hackerrank.algorithms.implementation.betweentwosets;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

class Result2 {

	public static int getTotalX(List<Integer> a, List<Integer> b) {

		TreeSet<Integer> aSet = new TreeSet<>(a);
		Integer[] aArr = aSet.toArray(new Integer[aSet.size()]);

		TreeSet<Integer> bSet = new TreeSet<>(b);
		Integer[] bArr = bSet.toArray(new Integer[bSet.size()]);

		int answer = 0;

		loof:
			for(int i = 1 ; i <= bArr[0] ; i++){
				for(int aNum : aArr){
					if(i % aNum != 0){
						continue loof;
					}
				}
				for(int bNum : bArr){
					if(bNum % i != 0){
						continue loof;
					}
				}
				answer++;
			}
		return answer;
	}
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