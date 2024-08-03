import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        // 선택할 수 있는 폰켓몬의 수
        int selectableCount = nums.length / 2;
        
        // 중복을 제거하여 유니크한 폰켓몬의 종류를 구합니다
        Set<Integer> uniquePokemons = new HashSet<>();
        for (int num : nums) {
            uniquePokemons.add(num);
        }
        
        // 유니크한 폰켓몬의 종류 수와 선택 가능한 폰켓몬의 수 중 더 작은 값을 반환합니다
        return Math.min(uniquePokemons.size(), selectableCount);
    }
}