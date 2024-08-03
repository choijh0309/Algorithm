import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별 개수를 저장할 Map
        Map<String, Integer> clothesMap = new HashMap<>();
        
        // 의상 종류별 개수 계산
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 조합의 수 계산
        int answer = 1;
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }
        
        // 아무것도 입지 않는 경우 제외
        return answer - 1;
    }
}