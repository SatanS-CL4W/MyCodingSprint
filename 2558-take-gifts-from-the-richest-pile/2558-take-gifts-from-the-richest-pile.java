class Solution {
    public long pickGifts(int[] g, int k) {
        // Create max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : g) maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            // Pop max element
            int x = maxHeap.poll();
            // Update element
            maxHeap.add((int) Math.sqrt(x));
        }

        // Return sum
        long sum = 0;
        for (int val : maxHeap) sum += val;
        return sum;
    }
}