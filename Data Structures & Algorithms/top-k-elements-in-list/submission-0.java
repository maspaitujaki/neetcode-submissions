class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            int prev = freq.getOrDefault(num, 0);
            freq.put(num, prev + 1);

            buckets.add(new ArrayList<>());
        }

        for (int key: freq.keySet()) {
            int value = freq.get(key);

            buckets.get(value - 1).add(key);
        }

        int[] res = new int[k];
        int pointer = nums.length - 1;
        while (k > 0) {
            if (buckets.get(pointer).isEmpty()) {
                pointer -= 1;
                continue;
            }

            for (int num: buckets.get(pointer)) {
                res[k-1] = num;
                k -= 1;
            }

                            pointer -= 1;

        }

        return res;
    }
}
