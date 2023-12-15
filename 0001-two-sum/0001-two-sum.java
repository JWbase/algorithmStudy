class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        
        //하나의 for 반복으로 통합
        for (int i = 0; i < nums.length; i++) {
            // target에서 num을 뺀 값이 있으면 정답으로 리턴
            if (numsMap.containsKey(target - nums[i])) {
                return new int[] {i, numsMap.get(target - nums[i])};
            }
            
            numsMap.put(nums[i], i);
        }
        return null;
    }
}