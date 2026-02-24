class Solution {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;  // 1 means +, -1 means -
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();  // sign
                result += stack.pop();  // previous result
            }
        }

        // Add remaining number
        result += sign * num;

        return result;
    }
}