import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String op : operations) {
            String[] parts = op.split(" ");
            String command = parts[0];
            int num = Integer.parseInt(parts[1]);
            
            if(command.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
            } else {
                if(minHeap.isEmpty()) continue;
                
                if(num == 1) {
                    // 최대값 삭제
                    int max = maxHeap.poll();
                    minHeap.remove(max); // 다른 힙에서도 동기화
                } else {
                    int min = minHeap.poll();
                    maxHeap.remove(min);
                }
            }
        }
        
        if(minHeap.isEmpty()) return new int[]{0, 0};

        
        return new int[]{maxHeap.peek(), minHeap.peek()};
    }
}
