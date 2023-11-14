import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        HashMap<String, Integer> map = new HashMap<>();
        // <의상의 종류, 개수> 쌍의 map 생성
        for(int i = 0; i < clothes.length; i++){
            String clothType = clothes[i][1];
            Integer cnt;
            
            if(map.containsKey(clothType)){
                cnt = map.get(clothType)+1;
            }else{
                cnt = new Integer(1);
            }
            map.put(clothType, cnt);
        }
        
        // 경우의 수 계산
        int result = 1;
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            result *= entry.getValue()+1;
        }
        result -= 1; // 모든 의상의 종류에 대해 입지 않은 경우의 수 제거
        
        return result;
    }
}