class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = Integer.bitCount(num2);
        int currentBits = Integer.bitCount(num1);
        int result = num1;

        if (currentBits < targetBits) {
            int bit = 0;
            while (currentBits < targetBits) {
                if ((result & (1 << bit)) == 0) {
                    result |= (1 << bit);
                    currentBits++;
                }
                bit++;
            }
        } else if (currentBits > targetBits) {
            int bit = 0;
            while (currentBits > targetBits) {
                if ((result & (1 << bit)) != 0) {
                    result &= ~(1 << bit);
                    currentBits--;
                }
                bit++;
            }
        }

        return result;
    }
}