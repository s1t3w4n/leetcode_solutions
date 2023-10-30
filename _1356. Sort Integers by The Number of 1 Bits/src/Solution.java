import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an integer array arr. Sort the integers in the array in ascending order by the number of 1's in their binary representation and in case of two or more integers have the same number of 1's you have to sort them in ascending order.
 * <p>
 * Return the array after sorting it.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 * Output: [0,1,2,4,8,3,5,6,7]
 * Explantion: [0] is the only integer with 0 bits.
 * [1,2,4,8] all have 1 bit.
 * [3,5,6] have 2 bits.
 * [7] has 3 bits.
 * The sorted array by bits is [0,1,2,4,8,3,5,6,7]
 * Example 2:
 * <p>
 * Input: arr = [1024,512,256,128,64,32,16,8,4,2,1]
 * Output: [1,2,4,8,16,32,64,128,256,512,1024]
 * Explantion: All integers have 1 bit in the binary representation, you should just sort them in ascending order.
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8})));
        System.out.println(Arrays.toString(new Solution().sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1})));
    }

    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Comparator<Integer> comparator = new CustomComparator();
        Arrays.sort(nums, comparator);
        return Arrays.stream(nums).mapToInt(Integer::intValue).toArray();
    }
}

class CustomComparator implements Comparator<Integer> {
    private int findWeight(int num) {
        int mask = 1;
        int weight = 0;

        while (num > 0) {
            if ((num & mask) > 0) {
                weight++;
                num ^= mask;
            }

            mask <<= 1;
        }

        return weight;
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (findWeight(a) == findWeight(b)) {
            return a - b;
        }

        return findWeight(a) - findWeight(b);
    }
}