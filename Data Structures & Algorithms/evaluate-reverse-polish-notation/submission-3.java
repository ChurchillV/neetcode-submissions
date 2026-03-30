class Solution {
    public int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<String> stack = new Stack();

        for(String token : tokens) {
            if(!operators.contains(token)) {
                stack.push(token);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(evaluateExpr(token, num1, num2)));
            }
        }

        int result = Integer.parseInt(stack.pop());
        return result;
    }

    public int evaluateExpr(String operation, int num1, int num2) {
        switch(operation) {
            case "+":
                return num1 + num2;
                
            case "-":
                return num1 - num2;
                
            case "*":
                return num1 * num2;
                
            case "/":
                return num1 / num2;
                
            default:
                return 0;
                
        }  
    }
}
