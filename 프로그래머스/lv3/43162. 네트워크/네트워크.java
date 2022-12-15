class Solution {
    
    public int solution(int n, int[][] computers) {
        boolean[] isVisited = new boolean[n];
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                dfs(isVisited, computers, n, i);
                answer++;
            }

        }
        
        
        return answer;
        
    }
    
    private void dfs(boolean[] isVisited, int[][] computers, int n, int k){
        
        for(int i = 0; i < computers[k].length; i++){
            if(!isVisited[i] && k != i && computers[k][i] == 1){
                isVisited[i] = true;
                System.out.println(i);
                dfs(isVisited, computers, n, i);
            }
                
        }
    }
}