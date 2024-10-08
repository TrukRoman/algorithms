package leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "abc";
        String t = "";
        System.out.println(isSubsequence(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int sIndex = 0;

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(sIndex)) {
                sIndex++;
            }
            if (sIndex == s.length()) {
                return true;
            }
        }

        return false;
    }
}
