class Solution {
    public String removeKdigits(String num, int k) {
        
        
        Stack<Character> stack = new Stack<>();
    
        int j = 0;
        
        if (num.length() <= k) {
            return "0";
        }
        
        if (k == 0) {
            return num;
        }
        
        while(j<num.length()) {
            
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(j)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(j));
            j++;
        }
        
        while(k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}