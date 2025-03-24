import java.util.Map;
import java.util.TreeMap;

/**
 * You are given a positive integer days representing the total number of days an employee is available for work (starting from day 1). You are also given a 2D array meetings of size n where, meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).
 * <p>
 * Return the count of days when the employee is available for work but no meetings are scheduled.
 * <p>
 * Note: The meetings may overlap.
 * <p>
 * Example 1:
 * <p>
 * Input: days = 10, meetings = [[5,7],[1,3],[9,10]]
 * <p>
 * Output: 2
 * <p>
 * Explanation:
 * <p>
 * There is no meeting scheduled on the 4th and 8th days.
 * <p>
 * Example 2:
 * <p>
 * Input: days = 5, meetings = [[2,4],[1,3]]
 * <p>
 * Output: 1
 * <p>
 * Explanation:
 * <p>
 * There is no meeting scheduled on the 5th day.
 * <p>
 * Example 3:
 * <p>
 * Input: days = 6, meetings = [[1,6]]
 * <p>
 * Output: 0
 * <p>
 * Explanation:
 * <p>
 * Meetings are scheduled for all working days.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= days <= 109
 * 1 <= meetings.length <= 105
 * meetings[i].length == 2
 * 1 <= meetings[i][0] <= meetings[i][1] <= days
 */
public class Solution {
    public static void main(String[] args) {
        // 2
        System.out.println(new Solution().countDays(10, new int[][]{
                new int[]{5, 7},
                new int[]{1, 3},
                new int[]{9, 10}
        }));
        // 1
        System.out.println(new Solution().countDays(5, new int[][]{
                new int[]{2, 4},
                new int[]{1, 3}
        }));
        // 0
        System.out.println(new Solution().countDays(6, new int[][]{
                new int[]{1, 6}
        }));
        // 1
        System.out.println(new Solution().countDays(57, new int[][]{
                new int[]{3,49},
                new int[]{23,44},
                new int[]{21,56},
                new int[]{26,55},
                new int[]{23,52},
                new int[]{2,9},
                new int[]{1,48},
                new int[]{3,31}
        }));
        // 0
        System.out.println(new Solution().countDays(2, new int[][]{
                new int[]{1, 2},
                new int[]{1, 1}
        }));
    }

    public int countDays(int days, int[][] meetings) {
        TreeMap<Integer, Integer> startToEndMeetingMap = new TreeMap<>();
        for (int[] meeting : meetings) {
            if (startToEndMeetingMap.containsKey(meeting[0])) {
                startToEndMeetingMap.put(meeting[0], Math.max(startToEndMeetingMap.get(meeting[0]), meeting[1]));
            } else {
                startToEndMeetingMap.put(meeting[0], meeting[1]);
            }
        }
        Map.Entry<Integer, Integer> entry1 = startToEndMeetingMap.pollFirstEntry();
        while (!startToEndMeetingMap.isEmpty()) {
            Map.Entry<Integer, Integer> entry2 = startToEndMeetingMap.pollFirstEntry();
            if (entry1.getValue() >= entry2.getValue() && entry2.getKey() > entry1.getKey()) {
                continue;
            }
            if (entry1.getValue() >= entry2.getKey()) {
                startToEndMeetingMap.put(entry1.getKey(), entry2.getValue());
                entry1 = startToEndMeetingMap.pollFirstEntry();
            } else {
                days -= (entry1.getValue() - entry1.getKey() + 1);
                entry1 = entry2;
            }
        }
        days -= (entry1.getValue() - entry1.getKey() + 1);
        return days;
    }
}