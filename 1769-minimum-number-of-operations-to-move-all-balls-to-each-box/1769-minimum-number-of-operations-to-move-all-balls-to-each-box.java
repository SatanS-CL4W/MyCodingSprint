class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int rtones=0, ltones=0;
        int sum=0,presum=0;
        // We are counting the number of ones and the sum of their indexes.
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                sum+=i; rtones+=1;
            }
        }
        // we iterate over boxes again to fill the respective moves.
        int[] res=new int[n];
        for(int i=0;i<n;i++){
            int moves = presum+sum;
            res[i]=moves;
            // we should update both the ones and the sum.
            if(boxes.charAt(i)=='1'){
                ltones += 1;
                rtones -= 1;
            }
            // As we are moving from left to right.
            presum += ltones;
            sum -= rtones;
        }
    return res;
    }
}