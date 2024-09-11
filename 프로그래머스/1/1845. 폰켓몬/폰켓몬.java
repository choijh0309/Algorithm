import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> uniqueMons = new HashSet<>();
        for (int num : nums) {
            uniqueMons.add(num);
        }
        
        int maxSelectable = nums.length / 2;
        
        return Math.min(uniqueMons.size(), maxSelectable);
    }
}