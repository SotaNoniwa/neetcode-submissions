class Solution {
    private final Map<Character, String> digitToChars = Map.ofEntries(
            Map.entry('2', "abc"),
            Map.entry('3', "def"),
            Map.entry('4', "ghi"),
            Map.entry('5', "jkl"),
            Map.entry('6', "mno"),
            Map.entry('7', "pqrs"),
            Map.entry('8', "tuv"),
            Map.entry('9', "wxyz"));

    public List<String> letterCombinations(String digits) {
        List<String> allCombos = new ArrayList<>();
        if (digits.isEmpty()) {
            return allCombos;
        }

        // I used StringBuilder for currStr to optimize time complexity, but overall
        // complexity will be O(4^n) where 4 is max length of chars and n is length of
        // digits. Thus using Stringbuilder just increase lines of code, its time
        // complexity is still O(4^n).
        backtrack(digits, 0, "", allCombos);
        return allCombos;
    }

    private void backtrack(String digits, int idx, String currStr, List<String> allCombos) {
        if (currStr.length() == digits.length()) {
            allCombos.add(currStr);
            return;
        }

        for (char c : digitToChars.get(digits.charAt(idx)).toCharArray()) {
            backtrack(digits, idx + 1, currStr + c, allCombos);
        }
    }
}
