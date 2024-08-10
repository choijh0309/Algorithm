import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public long solution(int n, int[] works) {
        // 최대 힙 생성
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // 모든 작업을 최대 힙에 추가
        for (int work : works) {
            maxHeap.offer(work);
        }
        
        // n시간 동안 작업 수행
        for (int i = 0; i < n; i++) {
            if (maxHeap.isEmpty()) {
                return 0; // 모든 작업이 완료된 경우
            }
            int maxWork = maxHeap.poll();
            if (maxWork > 0) {
                maxHeap.offer(maxWork - 1);
            }
        }
        
        // 남은 작업들의 제곱의 합 계산
        long fatigue = 0;
        while (!maxHeap.isEmpty()) {
            long work = maxHeap.poll();
            fatigue += work * work;
        }
        
        return fatigue;
    }
}