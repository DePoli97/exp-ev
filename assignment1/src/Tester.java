package exp01.src;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import static exp01.src.TestCaseGenerator.generateRandomArray;

public class Tester {
    public static void main (String[] args) {

        long begin = System.currentTimeMillis();

        // ADJUST HERE ARRAY SIZE
        int arraySize = 10000;

        // ADJUST HERE ARRAY DATA TYPE
        BubbleSortUntilNoChange<Double> noChangeInt = new BubbleSortUntilNoChange<>();
        BubbleSortPassPerItem<Double> passInt = new BubbleSortPassPerItem<>();
        BubbleSortWhileNeeded<Double> whileInt = new BubbleSortWhileNeeded<>();

        // ADJUST HERE ARRAY INITIAL ORDER
        TestCaseGenerator.SortOrder order = TestCaseGenerator.SortOrder.ASCENDING;

        System.out.println("Beginning test...");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("results/sorting_results.csv", true))) {
            if (new File("results/sorting_results.csv").length() == 0) {
                writer.write("Algorithm,Array Type,Array Size,Sort Order,Execution Time (ns)\n");
            }

            // ADJUST HERE TOTAL NUMBER OF TESTS
            for (int i = 0; i < 125; i++) {

                // ADJUST HERE ARRAY DATA TYPE
                Double[] randomArray_1 = generateRandomArray(Double.class, arraySize, order);
                Double[] randomArray_2 = Arrays.copyOf(randomArray_1, arraySize);
                Double[] randomArray_3 = Arrays.copyOf(randomArray_1, arraySize);

                testAndWriteToCSV(writer, "BubbleSortUntilNoChange", randomArray_1, noChangeInt, order, i);
                testAndWriteToCSV(writer, "BubbleSortPassPerItem", randomArray_2, passInt, order, i);
                testAndWriteToCSV(writer, "BubbleSortWhileNeeded", randomArray_3, whileInt, order, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        long ex_time = (end - begin)/1000;
        System.out.println("Completed test in: " + ex_time + " seconds");
    }

    private static <T extends Comparable<T>> void testAndWriteToCSV(BufferedWriter writer, String algorithmName,
    T[] array, Sorter<T> sortingAlgorithm, TestCaseGenerator.SortOrder order, int iteration) throws IOException {
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(array);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        String record = String.format("%s,%s,%d,%s,%d%n",
                algorithmName, array.getClass().getSimpleName(), array.length, order.toString(), executionTime);

        // ADJUST HERE NUMBER OF WARM-UP ITERATIONS
        if (iteration >= 25) {
            writer.write(record);
        }
    }
}
