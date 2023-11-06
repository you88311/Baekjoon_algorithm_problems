import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> failed = new HashMap<>();
        int cnt;
        for(String e : participant){
            if(failed.containsKey(e)){
                cnt = failed.get(e)+1;
            }else{
                cnt = 1;
            }
            failed.put(e,cnt);
        }
        

        for(String e : completion){
            if(!failed.containsKey(e)) continue;
            
            cnt = failed.get(e)-1;
            if(cnt == 0){
                failed.remove(e);
            }else{
                failed.put(e,cnt);
            }
        }
        String failedName = "";
        for(Map.Entry<String, Integer> entrySet : failed.entrySet()){
            failedName = entrySet.getKey();
        }
        
        return failedName;
    }
}