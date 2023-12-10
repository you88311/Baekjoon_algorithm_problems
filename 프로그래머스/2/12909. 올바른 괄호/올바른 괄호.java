import java.util.*;

class Solution {
    boolean solution(String s) {
    
        int  cnt = 0;
        char[] arr = s.toCharArray();
        int left = arr.length;
        
        for(char ch: arr){
            if('(' == ch){
                cnt++;
            }else{
                cnt--;
            }
            
            if(cnt < 0){
                return false;
            }
            
            left -= 1;
            if(cnt > left){
                return false;
            }
        }
        
        if(cnt == 0){
            return true;
        }else{
            return false;
        } 
        
    }
}