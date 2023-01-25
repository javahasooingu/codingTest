package programmers.no150370;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        
        Map<String, Integer> termsMap = new HashMap<>();
        
        int[] todays = {Integer.parseInt(today.substring(0,4)) // 년
        		,Integer.parseInt(today.substring(5, 7)) // 월
        		, Integer.parseInt(today.substring(8))}; // 일
        
        // String 에서 split 을 사용해서 "."을 빼고 싶으면?
        // "\\." || "[.]"
        // split()안에는 정규식을 포함한 문자가 들어가기 때문에
        // "." 은 그냥 임의의 문자 1개로 취급한다.
        
        int todayInt = todays[0] * 10000 
        		+ todays[1] * 100 
        		+ todays[2]; // YYYYMMDD
        
        // 아예 모두 일자로 처리해서 계산하는게 더 편했겠다....
        // 년 -> * 12 * 28 일
        // 월 -> * 28 일
        // 일 = 년 * 12 * 28 + 월 * 28 + 일
        
        List<Integer> answerList = new ArrayList<>();
        
        for(String term : terms) {
        	
        	String[] a = term.split(" ");
 		   
        	termsMap.put(a[0], Integer.parseInt(a[1]));
        	
        } // for
        
        int count = 0;
        
        for(String privacie : privacies) {
        	
        	count++;
        	
        	String[] pArr = privacie.split(" ");
        	
        	String pKey = pArr[1];
        	
        	int[] pDay = {Integer.parseInt(pArr[0].substring(0,4)) // 년
            		,Integer.parseInt(pArr[0].substring(5, 7)) // 월
            		, Integer.parseInt(pArr[0].substring(8))}; // 일 
        	
        	if(termsMap.get(pKey) >= 12) {
                pDay[0] += termsMap.get(pKey) / 12;
                pDay[1] += termsMap.get(pKey) % 12;
            } else {
                pDay[1] += termsMap.get(pKey) % 12;
            }
            
        	if(pDay[1] > 12) {
        		pDay[0] += pDay[1]/12;
        		pDay[1] = pDay[1]%12; 
        	}
        	
        	int endDayInt = pDay[0] * 10000 
            		+ pDay[1] * 100 
            		+ pDay[2]; // YYYYDDMM
        	
        	if(todayInt >= endDayInt) {
                
        		answerList.add(count);
                
        	} // if
        	
        } // for
        
        int[] answer = new int[answerList.size()];
        
        for(int idx = 0; idx < answer.length; idx++) {
        	answer[idx] = answerList.get(idx);
        }
        
        return answer;
        
    } // solution
    
} // end class