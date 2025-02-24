 public class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string into words
        String[] words = s.split("\\s+");
        
        // Step 3: Reverse the list of words
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        // Step 4: Join the words with a single space
        return String.join(" ", words);
    }
}
