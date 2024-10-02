import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] firstPattern = {1, 2, 3, 4, 5}; 
        int[] secondPattern = {2, 1, 2, 3, 2, 4, 2, 5}; 
        int[] thirdPattern = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; 

        int[] scores = {0, 0, 0}; 

        // 문제를 순회하며 각 수포자의 답안과 비교
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstPattern[i % firstPattern.length]) {
                scores[0]++;
            }
            if (answers[i] == secondPattern[i % secondPattern.length]) {
                scores[1]++;
            }
            if (answers[i] == thirdPattern[i % thirdPattern.length]) {
                scores[2]++; 
            }
        }

        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 최고 점수를 받은 수포자를 저장할 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();
        if (scores[0] == maxScore) {
            list.add(1); 
        }
        if (scores[1] == maxScore) {
            list.add(2); 
        }
        if (scores[2] == maxScore) {
            list.add(3); 
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
