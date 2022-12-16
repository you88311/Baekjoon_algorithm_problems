import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        boolean[] isVisited = new boolean[numbers.length()];
        boolean[] isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i*i <= 9999999 ; i++){
            for(int j = i*i; j <= 9999999; j+=i){
                isPrime[j] = false;
            }
        }
        
        String[] number = numbers.split("");
        // Integer[] num = new Integer[number.length];
        // for(int i = 0; i < number.length; i++){
        //     num[i] = Integer.parseInt(number[i]);
        // }
        System.out.println(Arrays.toString(number));
        
        combination(set, number, "0", isVisited, 0);
        
        Iterator<Integer> iter = set.iterator();
        int a;
        while(iter.hasNext()){
            a = iter.next();
            System.out.printf("%d ", a);
            if(isPrime[a]){
                answer++;
                System.out.printf("<- isPrime ");
            }
                
        }
        
        
            
        return answer;
    }
    
        private void combination(HashSet<Integer> set, String[] number, String current, boolean[] isVisited, int depth){
            set.add(Integer.parseInt(current));
            if(depth >= number.length)
                return;
            
        if(depth == 0){
            for(int i = 0; i < number.length; i++){
                isVisited[i] = true;
                combination(set, number, number[i], isVisited, depth+1);
                isVisited[i] = false;
            }
        }else{
            for(int i = 0; i < number.length; i++){
                if(!isVisited[i]){
                    isVisited[i] =  true;
                    combination(set, number, current+number[i], isVisited, depth+1);
                    isVisited[i] =  false;
                }
            }            
        }
            

        }
}