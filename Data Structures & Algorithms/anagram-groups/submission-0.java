class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> ans = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];

            // 26 length array that count #character in s
            for (char c : s.toCharArray())
                count[c - 'a']++;

            // convert the array to string
            String key = Arrays.toString(count);

            // if key does not exist, create new one
            if (!ans.containsKey(key))
                ans.put(key, new ArrayList<>());

            // then, add new string to ArrayList (value of key)
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }
}
