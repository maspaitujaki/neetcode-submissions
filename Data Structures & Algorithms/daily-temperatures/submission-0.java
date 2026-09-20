class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] result = new int[n];            


        for (int i = n - 1; i >= 0; i--) {
            int val = temperatures[i];

            while (!stack.isEmpty() && val >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}
