class GenericSorter {

    public static <T extends Comparable<T>> void sort(T[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            for (int j = 0; j < array.length - i - 1; j++) {

                if (array[j].compareTo(array[j + 1]) > 0) {

                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}

public class GenericSorting {
    public static void main(String[] args) {

        Integer[] numbers = {5, 2, 8, 1, 9};

        GenericSorter.sort(numbers);

        for (Integer n : numbers) {
            System.out.print(n + " ");
        }
    }
}