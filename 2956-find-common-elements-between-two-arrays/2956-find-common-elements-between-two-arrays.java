class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int ans1 = 0, ans2 = 0;

        // Store unique elements of nums1 in set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check how many nums2 elements exist in set1
        for (int num : nums2) {
            set2.add(num);  // Store unique elements of nums2
            if (set1.contains(num)) {
                ans2++; // Counting elements in nums2 that exist in nums1
            }
        }

        // Check how many nums1 elements exist in set2
        for (int num : nums1) {
            if (set2.contains(num)) {
                ans1++; // Counting elements in nums1 that exist in nums2
            }
        }

        return new int[]{ans1, ans2};
    }
}