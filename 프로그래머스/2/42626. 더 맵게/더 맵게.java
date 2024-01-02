import java.util.*;

// 이거는 꼭 다시 풀어봐
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Integer firstScoville;
        Integer secondScoville;
        Integer newScoville;
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int e : scoville){
            priorityQueue.add(e);
        }
        
        
        while(!priorityQueue.isEmpty()){
            firstScoville = priorityQueue.poll();
            if(firstScoville.intValue() >= K){
                return answer;
            }
            
            if(priorityQueue.isEmpty()){
                return -1;
            }
            
            secondScoville =  priorityQueue.poll();
            answer++;
            
            newScoville = firstScoville  + secondScoville * 2;   
            
            priorityQueue.add(newScoville);
            
        }
        
        
        return -1;
    }
}