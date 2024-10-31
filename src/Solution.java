import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int concatLength = wordLength * words.length;//For example, if words = ["foo", "bar"], and each word has a length of 3, then concatLength = 3 * 2 = 6 because the concatenated substring we're looking for would be 6 characters long (like "foobar" or "barfoo").

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1); // check how many time words appears
        }

        for (int i = 0; i <= s.length() - concatLength; i++) {
            /*
            //i <= s.length() - concatLength ensures that we do not start checking from a position where there would not be enough characters left
            // in s to match the total length of a valid concatenated string.
            //if start with char at the end of s it will return error
             */
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                int wordStart = i + j * wordLength;//calculate start index
                String word = s.substring(wordStart, wordStart + wordLength);

                if (!wordCount.containsKey(word)) {
                    break;
                }

                // Add the word to the seen map
                seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);

                // If the word appears more times than it should, break
                if (seenWords.get(word) > wordCount.get(word)) {// array only set once, if words appears two times it will not return any value
                    break;
                }

                j++;
            }

            // If all words are matched, add the index to the result
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"})); // [0, 9]
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"})); // []
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"})); // [6, 9, 12]
    }
}
