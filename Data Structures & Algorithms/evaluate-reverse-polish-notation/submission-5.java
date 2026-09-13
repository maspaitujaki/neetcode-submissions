class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new ArrayDeque<>();
        Set<String> operands = Set.of("+", "-", "*", "/");

        for (String s: tokens) {
            if (operands.contains(s)) {
                Integer right = nums.pop();
                Integer left = nums.pop();

                switch(s) {
                    case "+":
                        nums.push(left + right);
                        break;
                    case "-":
                        nums.push(left - right);
                        break;
                    case "*":
                        nums.push(left * right);
                        break;
                    case "/":
                        nums.push(left / right);
                        break;
                }
                continue;
            }

            nums.push(Integer.valueOf(s));
        }

        return nums.pop();
    }
}
