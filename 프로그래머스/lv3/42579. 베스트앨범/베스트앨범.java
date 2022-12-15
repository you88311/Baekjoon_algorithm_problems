import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        String key;
        /*장르 전체 play횟수 기준 정렬*/
        HashMap<String, Integer> total = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            key = genres[i];
            //전체 개수 for genre순서
            total.put(key, total.getOrDefault(key, 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(total.entrySet());
        Collections.sort(entryList, (o1, o2) -> total.get(o2.getKey()) - total.get(o1.getKey())); //value기준 내림차순 정렬
        
        /*장르별 상위 2개 찾기*/
        ArrayList<Integer> answerIdx = new ArrayList<>();
        for(Map.Entry<String, Integer> entry: entryList){
            int firstMax = 0;
            int secondMax = 0;
            int index1 = -1;
            int index2 = -1;
            key = entry.getKey();
            
            System.out.println(key);
            
            
            for(int i = 0; i < genres.length; i++){
                if(key.equals(genres[i]) && firstMax < plays[i]){
                    secondMax = firstMax;
                    index2 = index1;
                    
                    firstMax = plays[i];
                    index1 = i;
                }else if(key.equals(genres[i]) && (firstMax == plays[i] || secondMax < plays[i])){
                    secondMax = plays[i];
                    index2 = i;
                    }
            }
            System.out.println(index1);
            System.out.println(index2);
            
            answerIdx.add(index1);
            if(index2 != -1) answerIdx.add(index2);
        }
        
        int[] answer = new int[answerIdx.size()];
        for(int i = 0; i < answer.length; i ++){
            answer[i] = answerIdx.get(i);
        }
        return answer;
    }
}