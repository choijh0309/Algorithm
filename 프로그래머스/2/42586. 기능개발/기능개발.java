import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // 결과를 저장할 리스트 생성
        List<Integer> answerList = new ArrayList<>();
        
        // 큐를 사용하여 각 기능이 완료되기까지 필요한 일 수를 저장
        Queue<Integer> queue = new LinkedList<>();
        
        // 각 기능별로 완료까지 필요한 일 수 계산하여 큐에 추가
        for (int i = 0; i < progresses.length; i++) {
            // 남은 작업량을 해당 기능의 속도로 나누어 필요한 일 수 계산
            int days = (100 - progresses[i]) / speeds[i];
            // 나머지가 있을 경우 하루 더 필요
            if ((100 - progresses[i]) % speeds[i] != 0) {
                days += 1;
            }
            queue.add(days); 
        }
        
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int count = 1; // 동시에 배포될 기능의 수
            int first = queue.poll(); // 첫 번째 기능의 완료일 수
            
            // 다음 기능들이 첫 번째 기능의 완료일 수 이하로 완료된다면 함께 배포
            while (!queue.isEmpty() && queue.peek() <= first) {
                queue.poll();
                count++;
            }
            answerList.add(count); 
        }
        
        // 리스트를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
