import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 요청 시간 순으로 작업 배열을 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        // 작업의 소요 시간이 짧은 순
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        int time = 0; 
        int index = 0;
        int total = 0; 
        int count = 0; 

        while (count < jobs.length) {
            while (index < jobs.length && jobs[index][0] <= time) {
                heap.offer(jobs[index]);
                index++;
            }

            if (heap.isEmpty()) {
                time = jobs[index][0];
            } else {
                int[] job = heap.poll();
                time += job[1]; 
                total += time - job[0];
                count++; 
            }
        }

        return total / jobs.length;
    }
}
