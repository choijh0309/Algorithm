import java.util.HashMap;

public class Solution {
    // 부모 노드와 이익금 관리
    static HashMap<String, String> parentMap = new HashMap<>();
    static HashMap<String, Integer> profitMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        
        // 1. 조직 구성
        for (int i = 0; i < n; i++) {
            String child = enroll[i];
            String parent = referral[i].equals("-") ? null : referral[i]; // 추천인이 없는 경우 null
            parentMap.put(child, parent);
            profitMap.put(child, 0);  // 초기 이익은 0
        }
        
        // 2. 판매 기록을 처리하며 이익 분배
        for (int i = 0; i < seller.length; i++) {
            String currentSeller = seller[i];
            int profit = amount[i] * 100;
            
            distributeProfit(currentSeller, profit);
        }
        
        // 3. 결과 배열을 생성하여 반환
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = profitMap.get(enroll[i]);
        }
        
        return result;
    }
    
    // 재귀적으로 이익을 분배하는 함수
    public void distributeProfit(String seller, int profit) {
        if (seller == null || profit == 0) return;  // 더 이상 분배할 필요가 없는 경우
        
        // 10%를 부모에게 주고 자신이 나머지를 가짐
        int parentProfit = profit / 10;
        int selfProfit = profit - parentProfit;
        
        // 이익 추가
        profitMap.put(seller, profitMap.get(seller) + selfProfit);
        
        // 부모에게 재귀적으로 이익 분배
        String parent = parentMap.get(seller);
        distributeProfit(parent, parentProfit);
    }
}
