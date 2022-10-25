class Solution {
    public boolean isSubsequence(String s, String t) {
       int j = 0;
       char[] c = new char[t.length()];
       if (s.length() == 0) {
           return true;
       }
       if (s.length() > t.length()) {
           return false;
       }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j))
            {
               c[j] = t.charAt(i);
               j++;
                if (j == s.length()) {
                    return true;
                }
            }
        }
        return j == s.length();
}
}