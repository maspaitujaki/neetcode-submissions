class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        char top = 'a';
        for (char c: s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    top = stack.pop();
                    if (top != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    top = stack.pop();
                    if (top != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    top = stack.pop();
                    if (top != '[') return false;
                    break;
            }
        }

        return stack.isEmpty();
    }
}
