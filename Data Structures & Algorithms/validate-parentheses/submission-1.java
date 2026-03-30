class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>(Map.of(')', '(', '}', '{', ']', '['));
        char[] string = s.toCharArray();
        Stack<Character> bracketStack = new Stack<>();

        for(char c : string) {
            if(brackets.containsValue(c)) {
                bracketStack.push(c);
            } else {
                if(!bracketStack.isEmpty() && brackets.get(c) == bracketStack.peek()) {
                    bracketStack.pop();
                } else {
                    return false;
                }
            }
        }

        return bracketStack.isEmpty();
    }
}
