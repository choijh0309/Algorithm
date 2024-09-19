import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 의상의 종류별로 개수 카운트
        for (String[] c : clothes) {
            String type = c[1]; 
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 조합의 수를 계산하기 위한 변수 초기화
        int answer = 1;

        // 각 의상 종류마다 곱함
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 아무것도 입지 않는 경우를 제외
        return answer - 1;
    }
}