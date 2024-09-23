import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // 모든 음식의 스코빌 지수를 힙에 추가
        for (int s : scoville) {
            heap.offer(s);
        }

        int mixCount = 0; 

        // 힙의 최소값이 K 이상이 될 때까지 반복
        while (heap.size() >= 2 && heap.peek() < K) {
            int leastSpicy = heap.poll(); 
            int secondLeastSpicy = heap.poll(); 

            int mixedScoville = leastSpicy + (secondLeastSpicy * 2); 

            heap.offer(mixedScoville); 
            mixCount++; 
        }

        // 모든 음식의 스코빌 지수가 K 이상인지 확인
        if (heap.peek() != null && heap.peek() >= K) {
            return mixCount; 
        } else {
            return -1; 
        }
    }
}
