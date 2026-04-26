class Solution {
    public String longestNiceSubstring(String s) {
        return helper(s);
    }

    private String helper(String s) {
        if (s.length() < 2) return "";

        int[] freq = new int[128];
        for (char c : s.toCharArray()) freq[c]++;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq[Character.toLowerCase(c)] > 0 && freq[Character.toUpperCase(c)] > 0) continue;

            String left = helper(s.substring(0, i));
            String right = helper(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }

        return s;
    }
}