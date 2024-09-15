import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("OddOccurrencesInArray "+OddOccurrencesInArray(new int[]{1, 2, 2}));
        System.out.println("frogJump "+frogJump(0,200,30));
        System.out.println("missingInt "+missingInt(new int[]{1,3,4,7,6, 2, 5}));
        System.out.println("findIntArray "+findElement(2,new int[]{2,5,1,3,4,7,6, 2, 5}));
    }

    public static int findElement(int X, int[] A){
        if (A == null || A.length == 0) {
            return -1;  // Handle edge case if array is empty
        }

        // Create a boolean array to track positions from 1 to X
        boolean[] positions = new boolean[X + 1];
        int covered = 0;  // Count of positions covered by leaves

        // Iterate over the array A
        for (int i = 0; i < A.length; i++) {
            int pos = A[i];

            // Ensure the position is within the valid range (1 to X)
            if (pos >= 1 && pos <= X && !positions[pos]) {
                positions[pos] = true;
                covered++;

                // If all positions from 1 to X are covered, return the current time (i)
                if (covered == X) {
                    return i;
                }
            }
        }

        // If we finish the loop and not all positions are covered, return -1
        return -1;
    }

    public static int findIntArray(int X, int[] A){
        OptionalInt index = IntStream.range(0, A.length)
                .filter(i -> A[i] == X)
                .findFirst();

        // Check if the value X was found in the array
        if (index.isPresent()) {
            return index.getAsInt();
        } else {
            return -1;
        }
    }
    public static int permutation(int[]arrayA){

        if(arrayA.length==0){
            return 0;
        }

        if(arrayA.length==1){
            return 1;
        }
        Arrays.sort(arrayA);
        for (int i=0;i<arrayA.length;i++) {
            int value=i+1;
            if(value!=arrayA[i]){
                return 0;
            }
        }
        return 1;

    }

    public int distinct(int[] A) {
        int[] distinct= Arrays.stream(A).distinct().toArray();

        return distinct.length;
    }

    public int solution(int[] A) {
        int N = A.length;
        boolean[] present = new boolean[N + 1]; // Tracks numbers between 1 and N

        // Mark numbers that are present in the array
        for (int num : A) {
            if (num > 0 && num <= N) {
                present[num] = true;
            }
        }

        // Find the first number which is not present
        for (int i = 1; i <= N; i++) {
            if (!present[i]) {
                return i; // This is the smallest missing positive integer
            }
        }

        // If all numbers from 1 to N are present, the missing integer is N+1
        return N + 1;
    }

    public static int missingInt(int[]arrayA){

        if(arrayA.length==0){
            return 0;
        }

        if(arrayA.length==1){
            return arrayA[0];
        }
        Arrays.sort(arrayA);
        for (int i=0;i<arrayA.length;i++) {
            int value=i+1;
            if(value!=arrayA[i]){
                return value;
            }
        }
        return arrayA[arrayA.length-1]+1;

    }

    public static int missingIntWithInitial(int[]arrayA){

        if(arrayA.length==0){
            return 0;
        }

        if(arrayA.length==1){
            return arrayA[0];
        }

        Arrays.sort(arrayA);
        System.out.println("frogJump "+Arrays.toString(arrayA));
        int innitial=arrayA[0];
        for (int num : arrayA) {
            if(num!=innitial){
                return innitial;
            }
            innitial=num+1;
        }
        return 0;

    }

    public static int frogJump(int x,int y, int d){
        if(x>=y){
            return 0;
        }

        //return (int) Math.ceil((double) (y - x) / d); esieast ways

        boolean jumping = true;
        int countJump=0;
        while(true){
            x=x+d;
            if(x>=y){
                countJump++;
                return countJump;
            }
            countJump++;
        }
    }

    public static int OddOccurrencesInArray(int[] arrayA){
        try {
            HashSet<Integer> uniqueValue = new HashSet<>();

            for (int num : arrayA) {
                if (uniqueValue.contains(num)) {
                    uniqueValue.remove(num);
                } else {
                    uniqueValue.add(num);
                }
            }

            return uniqueValue.iterator().next();
        }catch (Exception e){
            return 0;
        }
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