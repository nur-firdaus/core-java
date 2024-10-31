import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

    // Helper method to find all occurrences of a word in the string
    public static List<Integer> findAllOccurrences(String s, String word) {
        List<Integer> indices = new ArrayList<>();
        int index = s.indexOf(word);
        while (index != -1) {
            indices.add(index);
            index = s.indexOf(word, index + 1); // Continue searching after the last found index
        }
        return indices;
    }

    // Method to find the starting indices of the consecutive appearance of the words
    public static List<Integer> findWordMatch(String s, String[] words) {
        Map<String, List<Integer>> wordIndicesMap = new HashMap<>();
        int wordLength = words[0].length();

        // Collect all occurrences of each word
        for (String word : words) {
            wordIndicesMap.put(word, findAllOccurrences(s, word));
        }

        List<Integer> result = new ArrayList<>();

        // Collect all indices across all words into one list
        List<Integer> allIndices = new ArrayList<>();
        for (List<Integer> indices : wordIndicesMap.values()) {
            allIndices.addAll(indices);
        }

        // Sort all collected indices
        allIndices.sort(Integer::compareTo);

        // Check for consecutive sequences of word appearances
        for (int i = 0; i <= allIndices.size() - words.length; i++) {
            boolean isConsecutive = true;

            // Check if there are words consecutively positioned
            for (int j = 1; j < words.length; j++) {
                if (allIndices.get(i + j) - allIndices.get(i + j - 1) != wordLength) {
                    isConsecutive = false;
                    break;
                }
            }

            if (isConsecutive) {
                result.add(allIndices.get(i));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};

        List<Integer> matches = findWordMatch(s, words);

        if (!matches.isEmpty()) {
            System.out.println("Matches found at indices: " + matches);
        } else {
            System.out.println("No match found.");
        }
    }
}
