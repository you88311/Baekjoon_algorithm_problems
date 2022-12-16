class Solution {
    int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] isVisited = new boolean[words.length];
        dfs(begin, target, words, isVisited, 0);
        
        return answer;
    }
    
    private void dfs(String current, String target, String[] words, boolean[] isVisited, int depth){
        int sameCnt = 0;
        int differCnt = 0;
        
        if(current.equals(target)){
            answer = depth;
            return;
        }
        
        for(int i = 0; i < words.length; i++){
            sameCnt = 0;
            differCnt = 0;
            
            if(!isVisited[i]){
                for(int j = 0; j < target.length(); j++){
                    if(current.charAt(j) != words[i].charAt(j)){
                        differCnt++;
                    }
                    if(words[i].charAt(j) == target.charAt(j))
                        sameCnt++;
                }
                
                if(differCnt == 1 && sameCnt >= depth){
                    isVisited[i] = true;
                    System.out.printf("%s %d \n", words[i], depth+1);
                    dfs(words[i], target, words, isVisited, depth+1);        
                }
            }
        }

            
    }
}