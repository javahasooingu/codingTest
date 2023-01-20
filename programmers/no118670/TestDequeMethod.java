package programmers.no118670;

import java.util.ArrayDeque;

public class TestDequeMethod {

	public static void main(String[] args) {

		double s;
		double e;
		double t;

		int max = 10_000;
		
		ArrayDeque<Integer> intQ = new ArrayDeque<>();

		//		List<Integer> intL = new ArrayList<>();

		//		int[] intArr = {1, 2, 3, 9};

		for(int i = 0; i < max; i++) {

			intQ.addLast(i);
			//	intL.add(i%5);

		} // for

		//		System.out.println(intQ);
		//		
		//		intQ.remove(5);
		//		
		//		System.out.println(intQ);
		//		
		//		intQ.removeLastOccurrence(5);
		//		
		//		System.out.println(intQ);
		//		
		//		intQ.removeAll(intL);
		//		
		//		System.out.println(intQ);
		//		REMOVE TEST

//				s = System.currentTimeMillis();
//		
//				intQ.forEach((i)->{
//					System.out.printf("%d_",i);
//				});
//		
//				e = System.currentTimeMillis();
//		
//				System.out.println();
//		
//				t = (e - s) / 1000.0;
//		
//				System.out.printf("%f s\n",t);
//		
//				System.out.println(intQ.isEmpty());
//		
//				System.out.println();
//		
//				s = System.currentTimeMillis();
//		
//				for(var i : intQ) {
//					System.out.printf("%d_",intQ.pollFirst());
//				}
//		
//				e = System.currentTimeMillis();
//		
//				System.out.println();
//		
//				t = (e - s) / 1000.0;
//		
//				System.out.printf("%f s\n",t);
//				
//		
//				
//				System.out.println(intQ.isEmpty());
//		
//				System.out.println();
//		
//				s = System.currentTimeMillis();
//		
//				while (!intQ.isEmpty()) {
//					System.out.printf("%d_",intQ.pollFirst());
//				}
//		
//				e = System.currentTimeMillis();
//		
//				System.out.println();
//		
//				t = (e - s) / 1000.0;
//		
//				System.out.printf("%f s\n",t);

		//		FOREACH FOR TEST

		s = System.currentTimeMillis();

		intQ.contains(max-1);

		e = System.currentTimeMillis();
		t = (e - s) / 1000.0;
		System.out.printf("%f s\n",t);

		s = System.currentTimeMillis();

		intQ.contains(1);

		e = System.currentTimeMillis();
		t = (e - s) / 1000.0;
		System.out.printf("%f s\n",t);
		
		
		


	} // main

} // end class
