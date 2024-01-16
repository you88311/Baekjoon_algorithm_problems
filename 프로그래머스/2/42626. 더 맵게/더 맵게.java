import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int e : scoville){
           list.add(e); 
        }
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.addAll(list);
        
        int prev = 0;
        int current = 0;
        int mixed = 0;
        while(priorityQueue.size() >=2 && priorityQueue.peek() < K){
            
            prev = priorityQueue.poll();
            current = priorityQueue.poll();
            mixed =  prev + current*2 ;  
            
            priorityQueue.add(mixed);
            
            answer++;
        }
        
        return priorityQueue.peek() < K ? -1 : answer;
    }
}