class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        String x = new StringBuilder(s).reverse().toString();

        if(x.equals(s)) {
            return true;
        }else {
            return false;
        }
    }
}