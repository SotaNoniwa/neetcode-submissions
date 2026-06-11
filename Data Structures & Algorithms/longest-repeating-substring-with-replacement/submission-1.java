class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int mostFreqCh = 0;
        int res = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            // count (increment) #eachCharacter
            arr[s.charAt(r) - 'A']++;
            // update max number of occurence
            mostFreqCh = Math.max(mostFreqCh, arr[s.charAt(r) - 'A']);
            // current window size = r-l+1
            if (r - l + 1 - mostFreqCh > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
