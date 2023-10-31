package exp01;

import java.util.Arrays;
import java.util.Random;

public class Tester {
    Random random = new Random();
    BubbleSortUntilNoChange<Integer> noChangeInt = new BubbleSortUntilNoChange<>();
    BubbleSortPassPerItem<Integer> passInt = new BubbleSortPassPerItem<>();
    BubbleSortWhileNeeded<Integer> whileInt = new BubbleSortWhileNeeded<>();

    public void randomArrayTest() {
        // Define the size of the array
        int arraySize = 10000;

        // Create an Integer array
        Integer[] randomArray_1 = new Integer[arraySize];

        // Fill the array with random integers
        for(int i = 0; i < arraySize; i++) {
            randomArray_1[i] = random.nextInt(); // Generates a random integer
        }

        Integer[] randomArray_2 = Arrays.copyOf(randomArray_1, arraySize);
        Integer[] randomArray_3 = Arrays.copyOf(randomArray_1, arraySize);


        long start_1 = System.currentTimeMillis();
        noChangeInt.sort(randomArray_1);
        long end_1 = System.currentTimeMillis();
        System.out.println("no change:" + (end_1-start_1));

        long start_2 = System.currentTimeMillis();
        passInt.sort(randomArray_2);
        long end_2 = System.currentTimeMillis();
        System.out.println("pass:" + (end_2-start_2));

        long start_3 = System.currentTimeMillis();
        whileInt.sort(randomArray_3);
        long end_3 = System.currentTimeMillis();
        System.out.println("while:" + (end_3-start_3));
    }

    public void sortedArray() {
        Integer[] sortedArray_1 = new Integer[10000];
        Integer[] sortedArray_2 = new Integer[10000];
        Integer[] sortedArray_3 = new Integer[10000];

        for(int i = 0; i < 10000; i++) {
            sortedArray_1[i] = i;
            sortedArray_2[i] = i;
            sortedArray_3[i] = i;
        }

        long start_1 = System.currentTimeMillis();
        noChangeInt.sort(sortedArray_1);
        long end_1 = System.currentTimeMillis();
        System.out.println("no change:" + (end_1-start_1));

        long start_2 = System.currentTimeMillis();
        passInt.sort(sortedArray_2);
        long end_2 = System.currentTimeMillis();
        System.out.println("pass:" + (end_2-start_2));

        long start_3 = System.currentTimeMillis();
        whileInt.sort(sortedArray_3);
        long end_3 = System.currentTimeMillis();
        System.out.println("while:" + (end_3-start_3));
    }
}
