import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int[] wanhoScore = scores[0];
        int rank = 1;
        int maxScore = 0;
        int wTotal = wanhoScore[0] + wanhoScore[1];
        
        Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        
        for (int[] score : scores) {
            if (maxScore <= score[1]) {
                maxScore = score[1];
                if (score[0] + score[1] > wTotal) rank++;
            } else {
                if (score.equals(wanhoScore)) return -1;
            }
        }
        
        return rank;
    }
}