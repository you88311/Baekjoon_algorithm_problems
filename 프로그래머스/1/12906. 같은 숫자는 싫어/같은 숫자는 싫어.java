import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int previous = -1;
        
        for(int e : arr){
            if(previous == e){
                continue;
            }
            
            answer.add(e);
            previous = e;
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}