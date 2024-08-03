import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> numberCount = new HashMap<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")) {
                minHeap.offer(number);
                maxHeap.offer(number);
                numberCount.put(number, numberCount.getOrDefault(number, 0) + 1);
            } else if (command.equals("D")) {
                if (number == 1) {
                    removeNumber(maxHeap, numberCount);
                } else if (number == -1) {
                    removeNumber(minHeap, numberCount);
                }
            }
        }

        // 최종 결과 계산
        int max = getNumber(maxHeap, numberCount);
        int min = getNumber(minHeap, numberCount);

        return new int[]{max, min};
    }

    private void removeNumber(PriorityQueue<Integer> heap, Map<Integer, Integer> numberCount) {
        while (!heap.isEmpty()) {
            int number = heap.poll();
            if (numberCount.containsKey(number)) {
                if (numberCount.get(number) == 1) {
                    numberCount.remove(number);
                } else {
                    numberCount.put(number, numberCount.get(number) - 1);
                }
                break;
            }
        }
    }

    private int getNumber(PriorityQueue<Integer> heap, Map<Integer, Integer> numberCount) {
        while (!heap.isEmpty()) {
            int number = heap.poll();
            if (numberCount.containsKey(number)) {
                return number;
            }
        }
        return 0;
    }
}