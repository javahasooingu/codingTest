 package hackerrank.java.array1d.part2;

import java.util.*;


public class Solution {

    public static boolean canWin(int leap, int[] game) {      
        
        int[] dIdx = {-1, 1, leap}; 
        
        Stack<Integer> gameStack = new Stack<>();
        gameStack.push(0);
        
        while(!gameStack.isEmpty()){
            int nowIdx = gameStack.pop();
            
            for(int d = 0 ; d < dIdx.length ; d++){
                
                int idx = nowIdx + dIdx[d];
                
                if(idx >= game.length){
                    return true;
                } // if ==> win 
                if(0 < idx){
                    if(game[idx] == 0){
                        game[nowIdx] = 1;
                        gameStack.push(idx);
                    } // inner if
                } // outer if
            } // for
        } // while
        
        return false;    
        } // canWin

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
