import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // N과 number가 같은 경우를 처리
        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();
        
        // 1부터 8까지의 사용 횟수에 대한 Set 초기화
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        // N을 1번 사용하는 경우 추가
        dp.get(1).add(N);
        
        // 2부터 8까지의 사용 횟수에 대해 계산
        for (int i = 2; i < 9; i++) {
            Set<Integer> current = dp.get(i);
            
            // N을 i번 연속해서 사용하는 경우 추가
            current.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            // j와 i-j 조합으로 만들 수 있는 모든 경우의 수 계산
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i - j)) {
                        current.add(x + y);
                        current.add(x - y);
                        current.add(x * y);
                        if (y != 0) current.add(x / y);
                    }
                }
            }
            
            // number를 찾았다면 해당 사용 횟수 반환
            if (current.contains(number)) {
                return i;
            }
        }
        
        // 8번 이내에 찾지 못한 경우 -1 반환
        return -1;
    }
}