import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        // 음식을 다 먹는데 걸리는 총 시간
        long total = 0;
        for (int time : food_times) {
            total += time;
        }
        
        // 음식을 다 먹기 전에 네트워크 장애가 발생한 경우
        if (total <= k) return -1;
        
        // (음식 시간, 음식 번호) 쌍을 우선순위 큐에 넣음
        PriorityQueue<Food> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        for (int i = 0; i < food_times.length; i++) {
            pq.offer(new Food(food_times[i], i + 1));
        }
        
        total = 0; // 먹기 위해 사용한 시간
        long previous = 0; // 직전에 다 먹은 음식 시간
        long length = food_times.length; // 남은 음식 개수
        
        // 음식을 먹는 시간보다 k가 크거나 같으면 반복
        while (total + ((pq.peek().time - previous) * length) <= k) {
            int now = pq.poll().time;
            total += (now - previous) * length;
            length -= 1;
            previous = now;
        }
        
        // 남은 음식 중에서 몇 번째 음식인지 확인
        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        // 음식의 번호 기준으로 정렬
        result.sort((a, b) -> a.index - b.index);
        
        return result.get((int)((k - total) % length)).index;
    }
    
    class Food {
        int time;
        int index;
        
        Food(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}