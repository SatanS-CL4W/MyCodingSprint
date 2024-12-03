class Solution {
    public String addSpaces(String s, int[] spaces) {
        int ind = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (ind < spaces.length && i == spaces[ind]) {
                ans.append(" ");
                ind++;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}