import java.util.*;

/**
 * You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports of one flight. Reconstruct the itinerary in order and return it.
 * <p>
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 * <p>
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * Example 2:
 * <p>
 * <p>
 * Input: tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi and toi consist of uppercase English letters.
 * fromi != toi
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findItinerary(
                Arrays.asList(
                        Arrays.asList("MUC","LHR"),
                        Arrays.asList("JFK","MUC"),
                        Arrays.asList("SFO","SJC"),
                        Arrays.asList("LHR","SFO")
                )
        ));
        System.out.println(new Solution().findItinerary(
                Arrays.asList(
                        Arrays.asList("JFK","SFO"),
                        Arrays.asList("JFK","ATL"),
                        Arrays.asList("SFO","ATL"),
                        Arrays.asList("ATL","JFK"),
                        Arrays.asList("ATL","SFO")
                )
        ));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket : tickets) {
            PriorityQueue<String> queue = map.getOrDefault(ticket.get(0), new PriorityQueue<>(Comparator.naturalOrder())) ;
            queue.offer(ticket.get(1));
            map.put(ticket.get(0), queue);
        }
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        List<String> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            String source = stack.peek();
            PriorityQueue<String> queue = map.get(source);
            if(Objects.isNull(queue) || queue.isEmpty()) {
                result.add(stack.pop());
            } else {
                stack.push(queue.poll());
            }
        }
        Collections.reverse(result);
        return result;
    }

}