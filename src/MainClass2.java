public class MainClass2 {
    public static void main(String[] args) {
        String input = "barfoothefoobarman"; // 30-char string

        // Determine the length of each substring
        int chunkSize = 3;
        String[] words = {"bar", "foo", "the"};
        chunkString(input,chunkSize,words);
    }

    public static void chunkString(String input,int chunkSize,String[] words){

        int arraySize = input.length() / chunkSize;
        String[] result = new String[arraySize];

        // Split the string into chunks
        for (int i = 0; i < arraySize; i++) {
            result[i] = input.substring(i * chunkSize, (i + 1) * chunkSize);
        }

        // Print the result
        for (String chunk : result) {
            System.out.println(chunk);
        }

    }


}
