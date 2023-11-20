import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genreTotalPlay = new HashMap<>();
        HashMap<String, ArrayList<Integer>> genreMusicMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++ ){
            
            genreTotalPlay.put(
                genres[i], genreTotalPlay.getOrDefault( genres[i], 0) + plays[i] );
            
            ArrayList<Integer> list = 
                genreMusicMap.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            genreMusicMap.put(genres[i], list);
        }
        
//         List<Map.Entry<String, Integer>> entryList = genreTotalPlay.entrySet().stream().
//                                                         sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
//                                                         collect(Collectors.toList());

        for(Map.Entry<String, ArrayList<Integer>> entry: genreMusicMap.entrySet()){
            Collections.sort(entry.getValue(), (o1,o2) -> (plays[o2] - plays[o1]));
        }
        
        ArrayList<Integer> answerList = new ArrayList<>();
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(genreTotalPlay.entrySet());
        for(Map.Entry<String, Integer> entry: entryList){
            String genre = entry.getKey();
            ArrayList<Integer> musicIds = genreMusicMap.get(genre);
            
            if(musicIds.size() == 1){
                answerList.add(musicIds.get(0));
            }else{
                answerList.addAll(musicIds.subList(0,2));
            }
            
        }
        
        int[] answer = answerList.stream().mapToInt( a -> a.intValue()).toArray();
        return answer;
    }
}