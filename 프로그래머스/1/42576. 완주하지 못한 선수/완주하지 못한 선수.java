import java.io.*;
import java.util.*;

class Solution {
    
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        int cnt;
        for(String e : participant){
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        

        for(String e : completion){
            if(!map.containsKey(e)) continue;
            
            cnt = map.get(e)-1;
            if(cnt == 0){
                map.remove(e);
            }else{
                map.put(e,cnt);
            }
        }
        
        String failedName = "";
        for(Map.Entry<String, Integer> entrySet : map.entrySet()){
            failedName = entrySet.getKey();
        }
        
        return failedName;
    }
}