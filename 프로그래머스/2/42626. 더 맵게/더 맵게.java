import java.util.*;

// 이거는 꼭 다시 풀어봐
// 내가 구현한 더러운?while문보다 깔끔한 답변 있음
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

        // 최초소스
//           while(!priorityQueue.isEmpty()){
//             firstScoville = priorityQueue.poll();
//             if(firstScoville.intValue() >= K){
//                 return answer;
//             }
            
//             if(priorityQueue.isEmpty()){
//                 return -1;
//             }
            
//             secondScoville =  priorityQueue.poll();
//             answer++;
            
//             newScoville = firstScoville  + secondScoville * 2;   
            
//             priorityQueue.add(newScoville);
            
//         }
        
        while(priorityQueue.size() > 1 && priorityQueue.peek() < K){
            firstScoville = priorityQueue.poll();
            secondScoville =  priorityQueue.poll();
            newScoville = firstScoville  + secondScoville * 2;   
            
            priorityQueue.add(newScoville);
            answer++;
        }
        
        return priorityQueue.peek() >= K ? answer : -1;
    }
}