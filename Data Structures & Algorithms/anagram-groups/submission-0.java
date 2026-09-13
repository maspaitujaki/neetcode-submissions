class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] isFound = new boolean[strs.length];
        
        if (strs.length == 1) {
            List<String> inner = new ArrayList<>();
            inner.add(strs[0]);
            result.add(inner);

            return result;
        }

        int i = 0;
        while (i < strs.length) {
            if (isFound[i]) {
                i += 1;
                continue;
            }

            List<String> inner = new ArrayList<>();
            String a = strs[i];
            inner.add(a);
            isFound[i] = true;

            int j = i + 1;
            while (j < strs.length) {
                if (isFound[j]) {
                    j += 1;
                    continue;
                }

                String b = strs[j];
                if (isAnagram(a, b)) {
                    inner.add(b);
                    isFound[j] = true;
                }

                j += 1;
            }

            result.add(inner);
            i += 1;
        }

        return result;
    }

    private boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int[] alphabet = new int[26];
        for (int i = 0; i < a.length(); i++) {
            alphabet[a.charAt(i) - 'a'] += 1;
            alphabet[b.charAt(i) - 'a'] -= 1;
        }

        for (int x: alphabet) {
            if (x != 0) {
                return false;
            }
        }

        return true;
    }
}
