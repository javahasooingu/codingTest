package hackerrank.algorithms.implementation.betweentwosets;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Stream;

class Result { 
	// 너무 비효율적이다...
	// 최대 공배수라는 단어에 빠져버려서 이렇게까지 와버렸다... 

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        TreeSet<Integer> aTreeSet = new TreeSet<>(a);
        Integer[] aArray = aTreeSet.toArray(new Integer[aTreeSet.size()]);
        
        TreeSet<Integer> bTreeSet = new TreeSet<>(b);
        Integer[] bArray = bTreeSet.toArray(new Integer[bTreeSet.size()]);
        
        int aLCM = Result.getLCM(aArray);
        
        Map<Integer,Integer> bMap = new HashMap<>();
        
        for(int bNum : bArray){
            
            for(int i = 1 ; (aLCM*i) <= bArray[0] ; i++){
                
                if(bNum % (aLCM*i) == 0){
                    
                    if(bMap.get(aLCM * i) == null){
                        bMap.put(aLCM * i, 1);
                    } else{
                        bMap.put(aLCM * i, bMap.get(aLCM * i) + 1);
                    }
                } // if 
            } // for
        } // for
        
        Integer[] keyArr = bMap.keySet().toArray(new Integer[bMap.keySet().size()]);
zz        
        int answer = 0;
        
        for(int key : keyArr){
            if(bMap.get(key) == bArray.length){
                answer++;
            }
        }
        

    return answer;
    }
    
    public static int getLCM(Integer[] arr){
           if (arr.length == 1) {
            return arr[0];
        }

        int gcd = getGCD(arr[0], arr[1]);
        int lcm = (arr[0] * arr[1]) / gcd;

        for (int i = 2; i < arr.length; i++) {
            gcd = getGCD(lcm, arr[i]);
            lcm = (lcm * arr[i]) / gcd;
        }
    
        return lcm;  
        
    }
    
    public static int getGCD(int num1, int num2){
        if(num1 % num2 == 0){
            return num2;
        } // if
        return getGCD(num2, num1 % num2);
    }
}

public class Solution {
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

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
