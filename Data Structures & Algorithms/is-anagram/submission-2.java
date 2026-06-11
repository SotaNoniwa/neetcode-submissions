class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<String, Integer> map = new HashMap<>();

        // Store chars in s to HashMap
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));

            if (map.get(c) == null)
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }

        // Remove chars in t from HashMap
        for (int i = 0; i < t.length(); i++) {
            String c = String.valueOf(t.charAt(i));

            if (map.get(c) == null)
                return false;
            else
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    map.remove(c);
        }

        if (!map.isEmpty())
            return false;
        
        return true;
    }
}
