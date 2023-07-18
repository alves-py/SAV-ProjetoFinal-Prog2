package ArraySorter;

public class ArrayPrinter {

    public static void printArray(int[] array) throws InterruptedException {
        int maxElement = findMaxElement(array);
        int numDigits = countDigits(maxElement);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + padRight(" |", numDigits + 2));
            for (int j = 0; j < array[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        Thread.sleep(500);
    }

    private static int findMaxElement(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static int countDigits(int number) {
        return String.valueOf(number).length();
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
