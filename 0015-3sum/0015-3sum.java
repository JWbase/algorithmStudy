class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, sum;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // 중복된 값 건너 뛰기
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 간격을 좁혀가며 sum 계산
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];

                //합이 0보다 작다면 왼쪽 포인터 이동
                if (sum < 0) {
                    left += 1;
                } else if (sum > 0) {
                    right -= 1;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left += 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right -= 1;
                    }

                    left += 1;
                    right -= 1;
                }
            }
        }
        return result;
    }
}