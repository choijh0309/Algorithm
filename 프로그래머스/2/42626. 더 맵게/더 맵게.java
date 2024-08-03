import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 우선순위 큐에 모든 스코빌 지수 추가
        for (int scov : scoville) {
            pq.offer(scov);
        }
        
        int mixCount = 0;
        
        while (pq.size() > 1 && pq.peek() < K) {
            int least = pq.poll();
            int secondLeast = pq.poll();
            
            int newScov = least + (secondLeast * 2);
            pq.offer(newScov);
            
            mixCount++;
        }
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
        if (pq.peek() < K) {
            return -1;
        }
        
        return mixCount;
    }
}