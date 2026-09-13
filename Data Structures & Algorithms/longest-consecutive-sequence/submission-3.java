class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> digits = new HashSet<>();

        for (int i = 0; i < n; i++) {
            digits.add(nums[i]);
        }

        int longest = 0;
        for (int x: digits) {
           if (!digits.contains(x-1)) {
                int length = 0;
                while (digits.contains(x + length)) {
                    length += 1;
                }

                if (length > longest) {
                    longest = length;
                }
           }
        }

        return longest;
    }
}
