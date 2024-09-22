import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        class PrintJob {
            int priority; 
            int index;    

            PrintJob(int priority, int index) {
                this.priority = priority;
                this.index = index;
            }
        }

        Queue<PrintJob> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new PrintJob(priorities[i], i));
        }

        int answer = 0; 

        while (!queue.isEmpty()) {
            PrintJob current = queue.poll(); 

            boolean hasHigherPriority = false;
            for (PrintJob p : queue) {
                if (p.priority > current.priority) {
                    hasHigherPriority = true;
                    break;
                }
            }

            if (hasHigherPriority) {
                queue.add(current);
            } else {
                answer++; 
                if (current.index == location) {
                    return answer; 
                }
            }
        }

        return answer;
    }
}
