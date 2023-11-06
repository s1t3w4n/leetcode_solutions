import java.util.TreeSet;

/**
 * Design a system that manages the reservation state of n seats that are numbered from 1 to n.
 * <p>
 * Implement the SeatManager class:
 * <p>
 * SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are initially available.
 * int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
 * void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
 * [[5], [], [], [2], [], [], [], [], [5]]
 * Output
 * [null, 1, 2, null, 2, 3, 4, 5, null]
 * <p>
 * Explanation
 * SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
 * seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
 * seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
 * seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
 * seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
 * seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
 * seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
 * seatManager.reserve();    // The only available seat is seat 5, so return 5.
 * seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 * 1 <= seatNumber <= n
 * For each call to reserve, it is guaranteed that there will be at least one unreserved seat.
 * For each call to unreserve, it is guaranteed that seatNumber will be reserved.
 * At most 105 calls in total will be made to reserve and unreserve.
 */
public class Solution {

    class SeatManager {

        // Marker to point to unreserved seats.
        int marker;

        // Sorted set to store all unreserved seats.
        TreeSet<Integer> availableSeats;

        public SeatManager(int n) {
            // Set marker to the first unreserved seat.
            marker = 1;
            // Initialize the sorted set.
            availableSeats = new TreeSet<>();
        }

        public int reserve() {
            // If the sorted set has any element in it, then,
            // get the smallest-numbered unreserved seat from it.
            if (!availableSeats.isEmpty()) {
                int seatNumber = availableSeats.first();
                availableSeats.remove(seatNumber);
                return seatNumber;
            }

            // Otherwise, the marker points to the smallest-numbered seat.
            int seatNumber = marker;
            marker++;
            return seatNumber;
        }

        public void unreserve(int seatNumber) {
            // Push the unreserved seat in the sorted set.
            availableSeats.add(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}