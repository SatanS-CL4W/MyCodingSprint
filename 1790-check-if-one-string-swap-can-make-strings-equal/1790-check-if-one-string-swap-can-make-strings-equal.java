
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        List<Integer> swapIndex = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                swapIndex.add(i);
            }
        }
        if (swapIndex.size() == 2) {
            int i = swapIndex.get(0), j = swapIndex.get(1);
            return (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i));
        }return false;
    }
}

/* 100%
class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        char[] s1FrequencyMap = new char[26];
        char[] s2FrequencyMap = new char[26];
        int numDiffs = 0;

        for (int i = 0; i < s1.length(); i++) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(i);

            if (s1Char != s2Char) {
                numDiffs++;
                if (numDiffs > 2)
                    return false;
            }
            s1FrequencyMap[s1Char - 'a']++;
            s2FrequencyMap[s2Char - 'a']++;
        }return Arrays.equals(s1FrequencyMap, s2FrequencyMap);
    }
}
*/