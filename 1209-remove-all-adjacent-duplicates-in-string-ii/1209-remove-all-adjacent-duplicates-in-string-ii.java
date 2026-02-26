class Solution {
    public String removeDuplicates(String s, int k) {    
        StringBuilder sb = new StringBuilder();
        int[] count = new int[s.length()];
        
        int i = 0; 
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            sb.append(c);
            
            if (i > 0 && sb.charAt(i - 1) == c) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = 1;
            }
            
            if (count[i] == k) {
                sb.delete(sb.length() - k, sb.length());
                i = i - k;
            }
            
            i++;
        }
        
        return sb.toString();
    }
}