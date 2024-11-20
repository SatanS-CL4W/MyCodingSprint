class Solution {
    public int takeCharacters(String s, int k) {
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }
        int requiredA = count[0] - k;
        int requiredB = count[1] - k;
        int requiredC = count[2] - k;

        int[] windowCount = new int[3];
        int maxWindowLength = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            windowCount[s.charAt(right) - 'a']++;

            while (windowCount[0] > requiredA || windowCount[1] > requiredB || windowCount[2] > requiredC) {
                windowCount[s.charAt(left) - 'a']--;
                left++;
            }
            maxWindowLength = Math.max(maxWindowLength, right - left + 1);
        }
        return s.length() - maxWindowLength;
    }
}