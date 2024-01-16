import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int finishedJobCnt = 0;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        
        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0] );
        
        int currentTime = 0;
        int leastNotAddedIndex = 0;
        int noJobTime = 0;
        while(finishedJobCnt < jobs.length){
            
            for( ; leastNotAddedIndex < jobs.length; leastNotAddedIndex++){
                if(currentTime < jobs[leastNotAddedIndex][0]){ // 요청시간이 현재시간보다 늦는 경우 pass
                    break;
                }
               
                priorityQueue.add(jobs[leastNotAddedIndex]); // 작업의 소요시간을 우선순위큐에 넣어 오름차순 정렬
            }
            
            if(priorityQueue.isEmpty()){
                currentTime = jobs[leastNotAddedIndex][0];
            }else{
                int[] finishedJob = priorityQueue.poll();
                currentTime += finishedJob[1];
                answer += currentTime - finishedJob[0];
                finishedJobCnt++;
                noJobTime = 0;
            }
        }
 
        return answer / jobs.length;
    }
}