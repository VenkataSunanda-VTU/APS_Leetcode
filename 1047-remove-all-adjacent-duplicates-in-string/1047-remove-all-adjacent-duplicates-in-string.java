
class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // remove duplicate
            } else {
                stack.push(ch); // push character
            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : stack){
            result.append(ch);
        }
        return result.toString();
    }
}