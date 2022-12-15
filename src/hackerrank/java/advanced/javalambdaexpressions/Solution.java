package hackerrank.java.advanced.javalambdaexpressions;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public static PerformOperation isOdd(){
		PerformOperation p = a ->{
			if(a%2 != 0){
				return true; 
			} else{
				return false;
			}
		}; 
		return p;
	}

	public static PerformOperation isPrime(){
		PerformOperation p = a ->{

			if(a == 1){
				return false;
			}
			if(a == 2){
				return true;
			}

			for(int i = 2 ; i < a ; i++){
				if(a % i == 0){
					return false;
				}
			}
			return true; 
		}; 
		return p;
	}

	public static PerformOperation isPalindrome(){
		PerformOperation p = a ->{

			String aString = ""+a;

			for(int i = 0 ; i <= aString.length()/2 ; i++){
				if(aString.charAt(i) != aString.charAt(aString.length() -1 - i)) {
					return false;
				}
			}


			return true; 

		}; 
		return p;
	}
}

public class Solution {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T--> 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
