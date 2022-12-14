import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            if(map.containsKey(cloth[1]))
                map.replace(cloth[1], map.get(cloth[1]) + 1);
            else
                map.put(cloth[1], 2); //공집합까지 고려
        }
        
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
        
        while(iter.hasNext()){
            answer *= iter.next().getValue();
        }
        
        
        return answer-1;
    }
}