import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        List<Integer> daysNeedList = new ArrayList<>();
        
        for(int i = 0; i < progresses.length; i++){
            int days = (100 - progresses[i] ) / speeds[i];
            days += ((100 - progresses[i]) % speeds[i] == 0 ) ? 0 : 1 ;  
            
            daysNeedList.add(days);
        }
        
        int deployAvailableCnt = 1;
        Integer prev = daysNeedList.get(0);
        for(int i = 1; i < daysNeedList.size(); i++){
            Integer daysNeed = daysNeedList.get(i);
            
            if(prev.compareTo(daysNeed) < 0){
                answer.add(deployAvailableCnt);
                deployAvailableCnt = 1;
                prev = daysNeed;
            }else{
                deployAvailableCnt++;
            }
        }
        answer.add(deployAvailableCnt);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}