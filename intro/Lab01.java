public class Lab01 {
    public static void main (String args[]) {

        long start;
        long end;

        int rows = 1000;
        int cols = 1000;

        byte[][] data = new byte[rows][cols];
        long[] results = new long[rows*cols];

        int index = 0;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {

                // ---
                start = System.nanoTime();
                data[i][j] = 1;
                end = System.nanoTime();
                // ---

                results[index] = end - start;
                index++;
            }
        }

        long sum = 0;
        for (long result : results) {
            sum += result;
//            System.out.println(result);
        }

        double result = (double) sum/(rows*cols);
        System.out.println(result);
    }
}