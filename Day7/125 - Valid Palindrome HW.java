class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);
            
            // Move left pointer if not alphanumeric
            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
            } 
            // Move right pointer if not alphanumeric
            else if (!Character.isLetterOrDigit(cRight)) {
                right--;
            } 
            // Both are alphanumeric, compare them case-insensitively
            else {
                if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }
        
        return true;
    }
}
