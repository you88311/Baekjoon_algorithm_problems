import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for( int i = 0; i < commands.length; i++ ){
            int[] current = Arrays.copyOfRange(
                array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(current);
            answer[i] = current[commands[i][2]-1];
        }
        
        return answer;
    }
}