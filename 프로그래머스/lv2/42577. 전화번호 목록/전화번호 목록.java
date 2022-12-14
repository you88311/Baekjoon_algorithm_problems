import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        HashSet<String> set = new HashSet<>();
        
        for(String num : phone_book){
            set.add(num);
        }
        
        for(int i = 0; i < phone_book.length ; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(set.contains(phone_book[i].substring(0,j)))
                    return false;
            }       
        }
        
        /*이건 사전정렬의 특성을 이용한 천재의 풀이..*/
        // for(int i = 0; i < phone_book.length - 1; i++){
        //         if(phone_book[i+1].startsWith(phone_book[i]))
        //             return false;
        //    } 
        
        return true;
    }
}