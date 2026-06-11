class Solution {
    public int characterReplacement(String s, int k) {
        int[] upperLetters = new int[26];
        int mostFreq = 0;
        int maxLen = 0;

        int begin = 0;
        for (int last = 0; last < s.length(); last++) {
            upperLetters[s.charAt(last) - 'A']++;
            mostFreq = Math.max(mostFreq, upperLetters[s.charAt(last) - 'A']);

            int windowSize = last - begin + 1;
            if (windowSize - mostFreq > k) {
                upperLetters[s.charAt(begin) - 'A']--;
                begin++;
                windowSize--;
            }

            maxLen = Math.max(maxLen, windowSize);
        }

        return maxLen;
    }
}
