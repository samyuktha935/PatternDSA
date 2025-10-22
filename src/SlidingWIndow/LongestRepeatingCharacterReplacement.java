package SlidingWIndow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "ABBBACCCDDDD";
        int k = 2;
        int result = obj.characterReplacement(s, k);
        System.out.println("Longest repeating substring length = " + result);
    }
}
class Solution {
    public int characterReplacement(String s, int k) {
        /*
            longest substring means ............?
            yes , Sliding window but how?
            break cond ?  operation atmost 'k'
            same letter so  u need freq
            once freq is incremented , check if that is maxFreq in that window
            when will this break?...that makes your break cond
            cal maxlen for all possible windows
        */
        int maxLen = 0 ;
        int left = 0 ;
        int maxFreq = 0 ;
        int[] freq = new int[26];
        for(int right = 0 ; right <s.length() ; right++){
            char c = s.charAt(right);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq ,freq[c - 'A'] );
            while((right-left+1) - maxFreq > k){
                freq[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen , right-left+1);
        }
        return maxLen;
    }
}
