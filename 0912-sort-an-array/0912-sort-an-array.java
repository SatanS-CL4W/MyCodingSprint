class Solution {
    public int[] sortArray(int[] nums) {
        int[] arr = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;

        for(int elem: nums) {
            pq.add(elem);
        }

        while(!pq.isEmpty()) {
            arr[i] = pq.poll();
            i++;
        }

        return arr;
    }
}