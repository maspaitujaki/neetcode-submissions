class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> chars = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            Integer count = chars.getOrDefault(s.charAt(i), 0);
            
            count = count + 1;
            chars.put(s.charAt(i), count);
        }

        for (int i = 0; i < t.length(); i++) {
            Integer count = chars.get(t.charAt(i));
            if (count == null) {
                return false;
            }

            count = count - 1;
            if (count == -1 ) {
                return false;
            }

            chars.put(t.charAt(i), count);
        }

        for (Integer value: chars.values()) {
            if (value > 1) {
                return false;
            }
        }

        return true;
    }
}
