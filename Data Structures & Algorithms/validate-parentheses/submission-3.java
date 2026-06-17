class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(Map.of(')', '(', '}', '{', ']', '['));
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(map.containsValue(c)) {
                stack.push(c);
            } else if(
                !stack.isEmpty() &&
                stack.peek() == map.get(c)
            ) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
