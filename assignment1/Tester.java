package exp01;

<<<<<<< HEAD
public class Tester {
        public void Tester() {
        }
=======
import java.util.Random;

public class Tester {
    public static void main (String[] args) {
        Random random = new Random();

        // Define the size of the array
        int arraySize = 10000;

        // Create an Integer array
        Integer[] randomArray = new Integer[arraySize];

        // Fill the array with random integers
        for(int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(); // Generates a random integer
        }

        BubbleSortUntilNoChange<Integer> noChangeInt = new BubbleSortUntilNoChange<>();

        long start = System.currentTimeMillis();
        noChangeInt.sort(randomArray);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
>>>>>>> 15848d5ec563e190e6b81bc23ee3a138ac7efd8c
}
