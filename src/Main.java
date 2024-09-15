public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }



    public int[] CyclicRotation(int[] A, int K) {
        int arrayLength = A.length;
        // Handle edge cases
        if (arrayLength == 0) {
            return A; // Return empty array as is
        }
        K = K % arrayLength; // Effective rotations needed
        if (K == 0) {
            return A; // No rotation needed
        }

        int[] rotatedArray = new int[arrayLength];
        // Compute the starting index for the rotated array
        int start = arrayLength - K;

        // Copy the rotated parts into the new array
        System.arraycopy(A, start, rotatedArray, 0, K);
        System.arraycopy(A, 0, rotatedArray, K, start);

        return rotatedArray;
    }


}