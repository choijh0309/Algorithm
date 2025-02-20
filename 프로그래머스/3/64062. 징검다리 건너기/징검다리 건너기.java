import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;  // 최소 1명
        int right = Arrays.stream(stones).max().getAsInt();  // 최대 stones 중 가장 큰 값

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canCross(stones, k, mid)) {
                left = mid + 1;  // 더 많은 사람이 건널 수 있는지 확인
            } else {
                right = mid - 1; // 너무 많으므로 줄이기
            }
        }

        return right;
    }

    private boolean canCross(int[] stones, int k, int people) {
        int skip = 0;  // 연속된 0 이하의 디딤돌 개수
        for (int stone : stones) {
            if (stone < people) {
                skip++;
                if (skip >= k) return false;  // 건널 수 없음
            } else {
                skip = 0;  // 초기화
            }
        }
        return true;  // 건널 수 있음
    }
}
