package exp01.src;

import java.util.Arrays;
import java.util.Random;

public class TestCaseGenerator {

    public static void main(String[] args) {
        // Example usage:
        Integer[] testCase = generateRandomArray(Integer.class, 10, SortOrder.ASCENDING);
        System.out.println("Generated Test Case: " + Arrays.toString(testCase));
    }

    // Enum to represent the sorting order
    public enum SortOrder {
        ASCENDING, DESCENDING, RANDOM
    }

    // Method to generate a test case for a sorting algorithm
    public static <T extends Comparable<T>> T[] generateRandomArray(Class<T> type, int size, SortOrder sortOrder) {
        T[] array = (T[]) java.lang.reflect.Array.newInstance(type, size);
        Random random = new Random();

        // Fill the array with random elements
        for (int i = 0; i < size; i++) {
            if (type.equals(Integer.class)) {
                array[i] = (T) Integer.valueOf(random.nextInt(100));
            } else if (type.equals(Double.class)) {
                array[i] = (T) Double.valueOf(random.nextDouble() * 100);
            } else if (type.equals(Byte.class)) {
                array[i] = (T) Byte.valueOf((byte) random.nextInt(100));
            }
        }

        // Sort the array based on the specified order
        switch (sortOrder) {
            case ASCENDING:
                Arrays.sort(array);
                break;
            case DESCENDING:
                Arrays.sort(array);
                reverseArray(array);
                break;
            case RANDOM:
                break;
            default:
                throw new IllegalArgumentException("Invalid sort order");
        }

        return array;
    }

    // Helper method to reverse the elements of the array
    private static <T> void reverseArray(T[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            T temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}