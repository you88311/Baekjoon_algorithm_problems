import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Integer firstScoville;
        Integer secondScoville;
        Integer newScoville;
        
        // scoville 오름차순 정렬
        Arrays.sort(scoville);
        
        // scoville 0번째부터 queue.add()
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