import java.util.Arrays;

public class Solution {
    
    public int minimumSubarrayLength(int[] nums, int k) {
        StringBuilder binK = new StringBuilder(Integer.toBinaryString(k));
        while (binK.length() < 33) {
            binK.insert(0, "0");
        }
        binK.reverse();

        int l = 1, h = nums.length, ans = -1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (good(nums, mid, binK)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean good(int[] nums, int val, StringBuilder binK) {
        int[] hashmap = new int[33];
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            int pos = 0;
            if (size == val) {
                boolean allTrue = true;
                for (int bit = 32; bit >= 0; --bit) {
                    char pq = hashmap[bit] >= 1 ? '1' : '0';
                    if (pq != binK.charAt(bit)) {
                        if (pq > binK.charAt(bit) && allTrue == true) {
                            return true;
                        } else {
                            allTrue = false;
                            break;
                        }
                    }
                }
                if (allTrue == true) {
                    return true;
                }
                --size;
                int mn = nums[i - val];
                int innerPos = 0;
                while (mn > 0) {
                    if ((mn & 1) == 1) {
                        --hashmap[innerPos];
                    }
                    mn = mn >> 1;
                    ++innerPos;
                }
            }
            while (x > 0) {
                if ((x & 1) == 1) {
                    ++hashmap[pos];
                }
                x = x >> 1;
                ++pos;
            }
            ++size;
        }
        if (size == val) {
            boolean allTrue = true;
            for (int bit = 32; bit >= 0; --bit) {
                char pq = hashmap[bit] >= 1 ? '1' : '0';
                if (pq != binK.charAt(bit)) {
                    if (pq > binK.charAt(bit) && allTrue == true) {
                        return true;
                    } else {
                        allTrue = false;
                        break;
                    }
                }
            }
            if (allTrue == true) {
                return true;
            }
        }
        return false;
    }
}