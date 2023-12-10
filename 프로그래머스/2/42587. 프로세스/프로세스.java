import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int currentIdx = 0;
        ArrayList<Integer> priorityAtOrder = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++){
            queue.add(i);
            priorityAtOrder.add(priorities[i]);
        }
        Collections.sort(priorityAtOrder, Collections.reverseOrder());
        
        while(!queue.isEmpty()){
            // 일단 queue에서 하나 뽑고
            currentIdx = queue.poll();
            
            // if 그 우선순위가 max보다 작으면 다시 뒤에 넣어
            if(priorities[currentIdx] != priorityAtOrder.get(answer).intValue()){
                queue.add(currentIdx);
            }else{
                answer++;
                if(location == currentIdx){
                    return answer; 
                }
            }
            
        }
        
        return answer;
    }
}