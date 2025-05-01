import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.offer(works[i]);
        }
        
        while(n != 0) {
            int workTime = pq.poll();
            if (workTime == 0) break;
            pq.offer(workTime - 1);
            n--;
        }

        while(!pq.isEmpty()) {
            int num = pq.poll();
            
            answer += (long) num * num;
        }
        
        return answer;
       
    }
}
