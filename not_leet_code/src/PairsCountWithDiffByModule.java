/**
 * Дан массив целых чисел a_1, a_2, ..., a_n и неотрицательное число k.
 * Найдите количество пар элементов массива (i, j),
 * таких что i < j и |a_i - a_j| = k (модуль разности равен k).
 * <p>
 * Примеры:
 * {-5, 1, -3, 0, 5}, k = 6 -> 1
 * {-2, 1, 3, 0, -10, 1}, k = 0 -> 1
 */
public class PairsCountWithDiffByModule {
    public static void main(String[] args) {
        // 1
        System.out.println(new PairsCountWithDiffByModule().getPairsCountWithDiffByModule(
                new int[]{-5, 1, -3, 0, 5}, 6
        ));
        // 1
        System.out.println(new PairsCountWithDiffByModule().getPairsCountWithDiffByModule(
                new int[]{-2, 1, 3, 0, -10, 1}, 0
        ));
        // 1
        System.out.println(new PairsCountWithDiffByModule().getPairsCountWithDiffByModule(
                new int[]{-5, 1, -3, 0, 5, 4, 10, 6, 0}, 6
        ));
    }

    public int getPairsCountWithDiffByModule(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
