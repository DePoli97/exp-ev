package exp01;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static exp01.TestCaseGenerator.generateRandomArray;

public class Tester {
    public static void main (String[] args) {

        // Define the size of the array
        int arraySize = 10000;

        TestCaseGenerator.SortOrder order = TestCaseGenerator.SortOrder.DESCENDING;

        // Generate test case
        Byte[] randomArray_1 = generateRandomArray(Byte.class, arraySize, order);
        Byte[] randomArray_2 = Arrays.copyOf(randomArray_1, arraySize);
        Byte[] randomArray_3 = Arrays.copyOf(randomArray_1, arraySize);

        BubbleSortUntilNoChange<Byte> noChangeInt = new BubbleSortUntilNoChange<>();
        BubbleSortPassPerItem<Byte> passInt = new BubbleSortPassPerItem<>();
        BubbleSortWhileNeeded<Byte> whileInt = new BubbleSortWhileNeeded<>();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorting_results.csv", true))) {
            // If the file is empty, write headers
            if (new File("sorting_results.csv").length() == 0) {
                writer.write("Algorithm,Array Type,Array Size,Sort Order,Execution Time (ns)\n");
            }

            // Perform tests and append results to the CSV file
            testAndWriteToCSV(writer, "BubbleSortUntilNoChange", randomArray_1, noChangeInt, order);
            testAndWriteToCSV(writer, "BubbleSortPassPerItem", randomArray_2, passInt, order);
            testAndWriteToCSV(writer, "BubbleSortWhileNeeded", randomArray_3, whileInt, order);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T extends Comparable<T>> void testAndWriteToCSV(BufferedWriter writer, String algorithmName, T[] array, Sorter<T> sortingAlgorithm, TestCaseGenerator.SortOrder order) throws IOException {
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(array);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // Create a CSV record
        String record = String.format("%s,%s,%d,%s,%d%n",
                algorithmName, array.getClass().getSimpleName(), array.length, order.toString(), executionTime);

        // Write the record to the CSV file
        writer.write(record);

        System.out.println(algorithmName + " execution time: " + executionTime + " ns");
    }
}
