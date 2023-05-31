package programmers.no17686;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static String[] solution(String[] files) {
    	
        String[] answer = new String[files.length];
        
        List<File> fileList = new ArrayList<File>();
        
        for(String fileName : files ) {
        	fileList.add(new File(fileName));
        }
        
        Collections.sort(fileList, (o1, o2) -> {
        	if(o1.head.compareToIgnoreCase(o2.head) == 0) {
    			Integer o1Num =Integer.parseInt(o1.number);
    			Integer o2Num =Integer.parseInt(o2.number);
    			
    			return o1Num.compareTo(o2Num);
    		}
    		
    		return o1.head.compareToIgnoreCase(o2.head);
        });
        
        for(int idx = 0; idx < files.length; idx++) {
        	answer[idx] = fileList.get(idx).toString();
        }
        
        return answer;
    }
}

class File {
	
	String head = "";
	String number = "";
	String tail = "";
	
	public File(String fileName) {
		int headStart = 0;
		int numberStart = 0;
		int tailStart = 0;
		
		for(int idx = 1; idx < fileName.length(); idx++) {
			if(fileName.charAt(idx) >= '0' && fileName.charAt(idx) <= '9') { // O(2)
				
				if(fileName.charAt(idx - 1) < '0' || fileName.charAt(idx - 1) > '9' ) {
					
					numberStart = idx;
				}
				
				if(idx + 1 == fileName.length() || fileName.charAt(idx + 1) < '0' || fileName.charAt(idx + 1) > '9') {
					tailStart = idx + 1;
					
					this.head = fileName.substring(headStart, numberStart);
					this.number = fileName.substring(numberStart, tailStart);
					
					if(idx + 1 != fileName.length()) {
						
						this.tail = fileName.substring(tailStart, fileName.length());
					}
					
					break;
				}
			}
		}
	}
	

	public String toString() {
		return head + number + tail;
	}

}