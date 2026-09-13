class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> isExists = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (!isExists.add(num)) {
                return true;
            }
        }

        return false;
    }
}