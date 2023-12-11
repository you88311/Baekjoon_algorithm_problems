import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        
        Queue<Integer> queue = new LinkedList<>();
        int nextIdx = 0;
        int outWeight = -1;
        int onTheBridgeWeight = 0;
        int time = 0;
        int size = 0;
        do{
            time++;
            
            if(!queue.isEmpty()){
                outWeight = queue.poll(); 
                onTheBridgeWeight -= outWeight;
                
            }
            if(nextIdx == truck_weights.length){
                continue;
            }
            
            if(onTheBridgeWeight + truck_weights[nextIdx] <= weight){
                size = queue.size(); 
                for(int i = 0; i < bridge_length - size -1; i++){
                    queue.add(0);
                }
                queue.add(truck_weights[nextIdx]);
                onTheBridgeWeight += truck_weights[nextIdx];
                nextIdx++;
            }
            
            
        }while(!queue.isEmpty());
        
        
        return time;
    }
}