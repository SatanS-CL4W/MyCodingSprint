class Solution {
    public int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while(st <= end) {
            int mid = st + (end - st) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[st] <= nums[mid]) { //Left Sorted
                if(nums[st] <= target && target <= nums[mid]) {
                    end = mid - 1;
                }else {
                    st = mid + 1;
                }
            } 
            else { //Right sorted
                if(nums[mid] <= target && target <= nums[end]) {
                    st = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}