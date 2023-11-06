import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(int num: nums){
            if(!hashSet.contains(num))
                hashSet.add(num);
            
            if(hashSet.size() == nums.length/2)
                break;
        }
        
        return hashSet.size();
    }
}