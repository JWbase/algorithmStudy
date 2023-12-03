class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    public int binarySearch(int[] nums, int target, int left, int right) {
        // 왼쪽 포인터가 오른쪽 포인터보다 작다면 계속 탐색
        
        if (left <= right) {
            // 중앙값 계산
            int mid = (left + right) / 2;
            
            //만약 중앙값이 타깃보다 작으면, 포인터를 우측으로 옮겨서 다시 탐색
            if (nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, right);
            } else if(nums[mid] > target) {
            //만약 중앙값이 타깃보다 크면, 포인터를 좌측으로 옮겨서 다시 탐색
                return binarySearch(nums, target, left , mid - 1);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }
}