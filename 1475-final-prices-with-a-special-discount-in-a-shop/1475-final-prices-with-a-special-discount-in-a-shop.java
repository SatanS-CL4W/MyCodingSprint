//Stack is for indexes.
//Ans arr is for final ans.
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            ans[i] =  prices[i];
            while(!st.isEmpty() && ans[st.peek()] >= ans[i]){
                ans[st.pop()] -= ans[i]; 
            }
            st.push(i);
        }
        return ans;
    }
}