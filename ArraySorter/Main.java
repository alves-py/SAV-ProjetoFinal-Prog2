package ArraySorter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        QuickSort quickSort = new QuickSort();

        Integer[] array = {5, 8, 2, 1, 6, 3, 9, 4, 7};
        quickSort.sort(array);
    }
}
