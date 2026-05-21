import java.util.ArrayList;
import java.util.List;

class RadixSorter {

    void sort(List<Integer> list) {

        int max = getMax(list);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(list, exp);
        }
    }

    int getMax(List<Integer> list) {

        int max = list.get(0);

        for (int n : list) {
            if (n > max) {
                max = n;
            }
        }

        return max;
    }

    void countingSort(List<Integer> list, int exp) {

        int n = list.size();

        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            output.add(0);
        }

        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(list.get(i) / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {

            int value = list.get(i);

            output.set(count[(value / exp) % 10] - 1, value);

            count[(value / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            list.set(i, output.get(i));
        }
    }
}

public class RadixSort {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(170);
        list.add(45);
        list.add(75);
        list.add(90);
        list.add(802);
        list.add(24);

        RadixSorter sorter = new RadixSorter();

        sorter.sort(list);

        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}