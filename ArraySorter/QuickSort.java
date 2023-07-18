package ArraySorter;

import static ArraySorter.ArrayPrinter.*;

public class QuickSort implements SortAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) throws InterruptedException {
        System.out.println("Array antes da ordenação: ");
        printArray(toIntArray(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Array após a ordenação: ");
        printArray(toIntArray(array));

        return array;
    }

    private static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) throws InterruptedException {
        if (left < right) {
            int pivotIndex = partition(array, left, right);

            System.out.println("Iteração de ordenação:");
            printArray(toIntArray(array));

            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, right);
        return i + 1;
    }

    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int[] toIntArray(Object[] array) {
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i] = (int) array[i];
        }
        return intArray;
    }
}

