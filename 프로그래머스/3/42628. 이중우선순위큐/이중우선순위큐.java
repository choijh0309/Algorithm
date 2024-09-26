import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 최소 힙 (오름차순 정렬)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // 최대 힙 (내림차순 정렬)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> countMap = new HashMap<>();

        int size = 0; 

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0]; 
            int number = 0;
            if (parts.length > 1) {
                number = Integer.parseInt(parts[1]);
            }

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number); 
                countMap.put(number, countMap.getOrDefault(number, 0) + 1);
                size++; 
            } else if (command.equals("D")) {
                if (size == 0) {
                    continue;
                }
                if (number == 1) {
                    while (!maxHeap.isEmpty()) {
                        int max = maxHeap.poll(); 
                        int cnt = countMap.getOrDefault(max, 0);
                        if (cnt > 0) {
                            countMap.put(max, cnt - 1);
                            size--; 
                            break;
                        }
                    }
                } else if (number == -1) {
                    while (!minHeap.isEmpty()) {
                        int min = minHeap.poll(); 
                        int cnt = countMap.getOrDefault(min, 0);
                        if (cnt > 0) {
                            countMap.put(min, cnt - 1);
                            size--; 
                            break;
                        }
                    }
                }
            }
        }

        if (size == 0) {
            return new int[]{0, 0};
        } else {
            int max = 0;
            while (!maxHeap.isEmpty()) {
                int m = maxHeap.poll();
                int cnt = countMap.getOrDefault(m, 0);
                if (cnt > 0) {
                    max = m;
                    break;
                }
            }

            int min = 0;
            while (!minHeap.isEmpty()) {
                int m = minHeap.poll();
                int cnt = countMap.getOrDefault(m, 0);
                if (cnt > 0) {
                    min = m;
                    break;
                }
            }

            return new int[]{max, min};
        }
    }
}
