class Solution {
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        dfs(numbers, 0, target, 0, numbers.length);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int prev, int target, int k, int end){
        if(k == end){
            if(prev == target)
                answer++;

            return;
        }
        
        dfs(numbers, prev+numbers[k], target,k+1, end);
        dfs(numbers, prev-numbers[k], target,k+1, end);
    }
}