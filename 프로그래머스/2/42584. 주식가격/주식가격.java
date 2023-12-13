class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        int noDownTime = 0 ;
        int price = 0;
        for(int i = 0; i < prices.length; i++){
            noDownTime = 0;
            for(int j = i+1; j < prices.length; j++){
                noDownTime++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = noDownTime;
        }
        
        return answer;
    }
}