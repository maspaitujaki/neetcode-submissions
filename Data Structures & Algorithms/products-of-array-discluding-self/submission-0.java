class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] leftProducts = new int[len + 2];
        int[] rightProducts = new int[len + 2];

        for (int i = 0; i < leftProducts.length; i++) {
            leftProducts[i] = 1;
            rightProducts[i] = 1;
        }
        //    0 1 2 3 4 5
        // // 1 1 1 1 1 1
        // //   1 2 4 6
        //      0 1 2 3 
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            leftProducts[i + 1] *= num * leftProducts[i];
        }

        
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            rightProducts[i + 1] *= num * rightProducts[i + 2];
        }

        // 0 1 2 3 4 5
        // 1 1 1 1 1 1
        //   1 2 4 6
        //   0 1 2 3 
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = leftProducts[i] * rightProducts[i+2];
        }

        return res;
    }
}  
