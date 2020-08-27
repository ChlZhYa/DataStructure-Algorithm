import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author changleamazing
 * @date 2020/8/27 21:07 source: https://leetcode-cn.com/problems/reconstruct-itinerary/
 **/
public class Solution {

    private Map<String, List<String>> graph = new HashMap<>();
    private List<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            List<String> list = graph.computeIfAbsent(ticket.get(0), K -> new LinkedList<>());
            list.add(ticket.get(1));
        }

        graph.values().forEach(x -> x.sort(String::compareTo));
        dfs("JFK");
        return res;
    }

    private void dfs(String fromCode) {
        List<String> toCodes = graph.get(fromCode);
        while (toCodes != null && toCodes.size() != 0) {
            dfs(toCodes.remove(0));
        }
        res.add(0, fromCode);
    }
}