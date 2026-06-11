class Solution {
    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        List<Character> alphabets = new ArrayList<Character>();

        for (char c : charArray) {
            if (Character.isAlphabetic(c) || Character.isDigit(c))
                alphabets.add(Character.toLowerCase(c));
        }

        int left = 0, right = alphabets.size() - 1;
        while (left < right) {
            if (!Objects.equals(alphabets.get(left), alphabets.get(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
