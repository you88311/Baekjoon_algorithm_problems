import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        Integer[] current;
        int x;
        int y;
        int targetX = maps[0].length;
        int targetY = maps.length;
        boolean[][] hasVisited = new boolean[targetX][targetY];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {0,0});
        maps[0][0] = 1;
        
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        
        while(!queue.isEmpty()){
                current = queue.poll();
                // System.out.println("----------");
                for(int i = 0; i < 4; i++){
                    x = current[0] + dx[i];
                    y = current[1] + dy[i];
                
                if(x+1 == maps.length && y+1 == maps[0].length)
                    return maps[current[0]][current[1]] + 1;
                if((x >= 0 && maps.length > x && y >= 0 && maps[0].length > y) && maps[x][y] == 1){
                    queue.add(new Integer[] {x, y});
                    maps[x][y] = maps[current[0]][current[1]] + 1;
                    // System.out.printf("x,y : %d %d  => %d\n", x, y, maps[x][y]);
                }
            }
        }
            
            
        return answer;
    }
    
}