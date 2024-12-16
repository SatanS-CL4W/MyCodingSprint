class Solution {
    class Node implements Comparable<Node> {
        int num;
        int idx;
        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
        @Override
        public int compareTo(Node n) {
            if(this.num == n.num) {
                return this.idx - n.idx;
            }
            else {
                return this.num - n.num;
            }
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int ans[] = new int[nums.length];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            pq.add(new Node(nums[i], i));
            ans[i] = nums[i];
        }
        for(int i=0; i<k; i++) {
            Node n = pq.poll();
            pq.add(new Node(n.num * multiplier, n.idx));
            ans[n.idx] = n.num * multiplier;
        }

        return ans;
    }
}