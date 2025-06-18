class Solution {
    public List<List<Integer>> divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i += 3) {
            if ( nums[i + 2] - nums[i] > k) {
                return new ArrayList<>();
            }
            ans.add(Arrays.asList(nums[i], nums[i + 1], nums[i + 2]));
        }

        return ans;
    }
}
