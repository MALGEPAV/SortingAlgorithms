import java.util.Arrays;
import java.util.Random;

public class SortingPlayground {
    private static int[] a;
    private static int[] a1;

    public static void main(String[] args) {
        fillRandom();
        System.out.println("Сортируем случайный массив из "+a.length+" натуральных чисел:");
        System.out.println("Быстрая сортировка:");
        long begin = System.currentTimeMillis();
        quicksort(0, a.length);
        long end = System.currentTimeMillis();
        System.out.println("Время быстрой сортировки: "+(end-begin)+" ms");
        //System.out.println(Arrays.toString(a));

        System.arraycopy(a1, 0, a, 0, a.length);
        
        System.out.println("Сортировка вставками:");
        begin = System.currentTimeMillis();
        insertionSort();
        end = System.currentTimeMillis();
        System.out.println("Время сортировки вставками: "+(end-begin)+" ms");
        //System.out.println(Arrays.toString(a));
    }

    private static void fillRandom() {
        Random r =  new Random();
        int n = 100000;
        a = new int[n];
        a1 = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1,100001);
            a1[i] = a[i];
        }
    }

    private static int partition(int l, int r) {
        int x = a[r - 1];
        int i = l - 1;
        int tmp = 0;
        for (int j = l; j < r - 1; j++) {
            if (a[j] <= x) {
                i++;
                tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        tmp = x;
        a[r - 1] = a[i + 1];
        a[i + 1] = tmp;
        return i + 1;
    }

    private static void quicksort(int l, int r) {
        if (l >= r - 1) return;
        int m = partition(l, r);
        quicksort(l, m);
        quicksort(m, r);
    }

    private static void insertionSort() {
        for (int i = 1; i < a.length; i++) {
            int x = a[i];
            int j = i - 1;
            while ((j >= 0) && (a[j] >= x)) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = x;
        }
    }
}
